package com.siweisoft.app.ui.info.urgencyreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.ui.home.activity.IndexActivity;
import com.siweisoft.app.ui.home.bean.reqbean.WriteAlarmReqBean;
import com.siweisoft.app.ui.info.urgencyreport.bean.resbean.UrgencyReportListResBean;
import com.siweisoft.app.ui.info.urgencyreport.ope.UrgencyReportUIOpe;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SheetDialogUtil;
import com.siweisoft.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.app.ui.bed.bedlist.fragment.BedListFGM;
import com.siweisoft.lib.util.fragment.FragManager;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UrgencyReportFrag extends BaseNurseFrag implements OnAppItemClickListener {

    UrgencyReportUIOpe urgencyReportUIOpe;

    NurseNetOpe urgencyReportNetOpe;


    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urgencyReportUIOpe = new UrgencyReportUIOpe(activity, getView());
        urgencyReportNetOpe = new NurseNetOpe(activity);
        urgencyReportUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefreshingDelay();
                    }
                });
            }
        });
        urgencyReportUIOpe.getRefreshLayout().autoRefresh();
    }

    public void getData(final OnFinishListener onFinishListener) {
        urgencyReportNetOpe.getAlarmLogs(new BaseNurseReqBean(), new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    UrgencyReportListResBean urgencyReportListResBean = GsonUtil.getInstance().fromJson(o.toString(), UrgencyReportListResBean.class);
                    urgencyReportUIOpe.initList(urgencyReportListResBean.getData());
                    urgencyReportUIOpe.getUngencyReportListAdapter().setOnAppItemClickListener(UrgencyReportFrag.this);
                }
                if (onFinishListener != null) {
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
        final String[] s1 = new String[]{"取消报警", "查看病人", "返回"};
        final String[] s2 = new String[]{"查看病人", "返回"};
        String[] s = null;
        switch (urgencyReportUIOpe.getData().get(position).getUpdate_value()) {
            case "0":
                s = s1;
                break;
            default:
                s = s2;
                break;
        }
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, s);
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                switch (textView.getText().toString()) {
                    case "取消报警":
                        WriteAlarmReqBean reqBean = new WriteAlarmReqBean();
                        reqBean.setZyh(urgencyReportUIOpe.getData().get(position).getZyh());
                        reqBean.setContent(urgencyReportUIOpe.getData().get(position).getContent());
                        switch (urgencyReportUIOpe.getData().get(position).getUpdate_value()) {
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
                        new NurseNetOpe(activity).writeAlarmLogs(reqBean, new UINetAdapter(activity) {
                            @Override
                            public void onNetWorkResult(boolean success, Object o) {
                                if (success) {
                                    urgencyReportUIOpe.getRefreshLayout().autoRefresh();
                                }
                            }
                        });
                        break;
                    case "查看病人":
                        FragManager.getInstance().clear(getFragmentManager(), 0);
                        if (activity instanceof IndexActivity) {
                            IndexActivity indexActivity = (IndexActivity) activity;
                            indexActivity.getHomeUIOpe().getViewPager().setCurrentItem(0);
                            Bundle bundle = new Bundle();
                            bundle.putString(ValueConstant.DATA_POSITION, urgencyReportUIOpe.getData().get(position).getZyh());
                            bundle.putString(ValueConstant.FARG_TYPE, ValueConstant.FARG_TYPE_CMD);
                            FragManager.getInstance().startFragment(getFragmentManager(), 0, new BedListFGM(), bundle);
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
