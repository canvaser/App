package com.siweisoft.nurse.ui.info.checkbookdetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.info.checkbook.bean.resbean.CheckBookResBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.reqbean.CheckBookDetailReqBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.resbean.CheckBookResbean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.uibean.CheckBookDetailHeadUIBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.ope.CheckBookDetailNetOpe;
import com.siweisoft.nurse.ui.info.checkbookdetail.ope.CheckBookDetailUIOpe;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookDetailFrag extends BaseNurseFrag implements PinnedHeaderExpandableListView.OnHeaderUpdateListener{


    CheckBookDetailUIOpe checkBookDetailUIOpe;

    CheckBookDetailNetOpe checkBookDetailNetOpe;

    CheckBookResBean checkBookResBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        checkBookResBean = (CheckBookResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        checkBookDetailUIOpe = new CheckBookDetailUIOpe(activity,getView());
        checkBookDetailNetOpe = new CheckBookDetailNetOpe(activity);
        checkBookDetailUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
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
        checkBookDetailUIOpe.getListView().setOnHeaderUpdateListener(this);
        checkBookDetailUIOpe.getRefreshLayout().autoRefresh();

    }

    public void getData(final OnFinishListener onFinishListener){
        CheckBookDetailReqBean reqBean = new CheckBookDetailReqBean();
        reqBean.setFileid(checkBookResBean.getFileid());
        checkBookDetailNetOpe.getInstrumentCountData(reqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    CheckBookResbean checkBookResbean = GsonUtil.getInstance().fromJson(o.toString(),CheckBookResbean.class);
                    checkBookDetailUIOpe.initList(checkBookResbean.getData());
                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_checkbookdetail;
    }

    @Override
    public View getPinnedHeader() {
        CheckBookDetailHeadUIBean checkHeadUIBean =null;
        View convertView = LayoutInflater.from(activity).inflate(R.layout.list_head_checkbookdetail,null);
        checkHeadUIBean= (CheckBookDetailHeadUIBean) convertView.getTag();
        convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ValueConstant.DIMEN_1*40));
        return convertView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if(firstVisibleGroupPos<0 || checkBookDetailUIOpe==null || checkBookDetailUIOpe.getData()==null){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        CheckBookDetailHeadUIBean checkHeadUIBean =new CheckBookDetailHeadUIBean(activity,headerView);
        checkHeadUIBean.getTimeTV().setText(StringUtil.getStr(checkBookDetailUIOpe.getData().get(firstVisibleGroupPos).getExectime()));
        checkHeadUIBean.getDuteTV().setText(StringUtil.getStr(checkBookDetailUIOpe.getData().get(firstVisibleGroupPos).getShift()));
        checkHeadUIBean.getNameTV().setText(StringUtil.getStr(checkBookDetailUIOpe.getData().get(firstVisibleGroupPos).getUsername()));
    }
}
