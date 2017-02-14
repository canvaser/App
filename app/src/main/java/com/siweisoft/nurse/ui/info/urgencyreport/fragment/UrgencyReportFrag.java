package com.siweisoft.nurse.ui.info.urgencyreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.bed.bedlist.fragment.BedListFGM;
import com.siweisoft.nurse.ui.home.activity.IndexActivity;
import com.siweisoft.nurse.ui.home.bean.reqbean.WriteAlarmReqBean;
import com.siweisoft.nurse.ui.home.ope.HomeNetOpe;
import com.siweisoft.nurse.ui.info.urgencyreport.bean.resbean.UrgencyReportListResBean;
import com.siweisoft.nurse.ui.info.urgencyreport.ope.UrgencyReportNetOpe;
import com.siweisoft.nurse.ui.info.urgencyreport.ope.UrgencyReportUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.SPUtil;
import com.siweisoft.util.SheetDialogUtil;
import com.siweisoft.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UrgencyReportFrag extends BaseNurseFrag implements OnAppItemClickListener{

    UrgencyReportUIOpe urgencyReportUIOpe;

    UrgencyReportNetOpe urgencyReportNetOpe;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urgencyReportUIOpe = new UrgencyReportUIOpe(activity,getView());
        urgencyReportNetOpe = new UrgencyReportNetOpe(activity);
        urgencyReportUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
        urgencyReportUIOpe.getRefreshLayout().autoRefresh();
    }

    public void getData(final OnFinishListener onFinishListener){
        urgencyReportNetOpe.getAlarmLogs(new BaseNurseReqBean(), new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    UrgencyReportListResBean urgencyReportListResBean = GsonUtil.getInstance().fromJson(o.toString(),UrgencyReportListResBean.class);
                    urgencyReportUIOpe.initList(urgencyReportListResBean.getData());
                    urgencyReportUIOpe.getUngencyReportListAdapter().setOnAppItemClickListener(UrgencyReportFrag.this);
                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_urgencyreport;
    }

    @Override
    public void onAppItemClick(View view, final int position) {
        final String[] s1= new String[]{"取消报警","查看病人","返回"};
        final String[] s2= new String[]{"查看病人","返回"};
        String[] s=null;
        switch (urgencyReportUIOpe.getData().get(position).getUpdate_value()){
            case "0":
                s=s1;
                break;
            default:
                s=s2;
                break;
        }
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity,s);
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                switch (textView.getText().toString()){
                    case "取消报警":
                        WriteAlarmReqBean reqBean = new WriteAlarmReqBean();
                        reqBean.setZyh(urgencyReportUIOpe.getData().get(position).getZyh());
                        reqBean.setContent(urgencyReportUIOpe.getData().get(position).getContent());
                        switch (urgencyReportUIOpe.getData().get(position).getUpdate_value()){
                            case "0":
                                reqBean.setUpdate_value("1");
                                break;
                            default:
                                reqBean.setUpdate_value("0");
                                break;
                        }
                        reqBean.setLevel("1");
                        reqBean.setMode("update");
                        reqBean.setLogid(urgencyReportUIOpe.getData().get(position).getId());
                        reqBean.setPatname(urgencyReportUIOpe.getData().get(position).getPatname());
                        new HomeNetOpe(activity).writeAlarmLogs(reqBean, new UINetAdapter(activity) {
                            @Override
                            public void onNetWorkResult(boolean success, Object o) {
                                if(success){
                                    urgencyReportUIOpe.getRefreshLayout().autoRefresh();
                                }
                            }
                        });
                        break;
                    case "查看病人":
                        FragManager.getInstance().clear(getFragmentManager(),0);
                        if(activity instanceof  IndexActivity){
                            IndexActivity indexActivity = (IndexActivity) activity;
                            indexActivity.getHomeUIOpe().getViewPager().setCurrentItem(0);
                            Bundle bundle = new Bundle();
                            bundle.putString(ValueConstant.DATA_POSITION,urgencyReportUIOpe.getData().get(position).getZyh());
                            bundle.putString(ValueConstant.FARG_TYPE,ValueConstant.FARG_TYPE_CMD);
                            FragManager.getInstance().startFragment(getFragmentManager(),0,new BedListFGM(),bundle);
                        }
                        break;
                    case "返回":
                        SheetDialogUtil.getInstance().dismess();
                        break;
                }
                SheetDialogUtil.getInstance().dismess();
            }
        });
    }
}
