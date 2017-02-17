package com.siweisoft.nurse.ui.addwater.addwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppBaseExpandableListAdapter;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.ToastUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListener;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.nurse.ui.addwater.addwater.bean.uibean.AddWaterListHeadUIBean;
import com.siweisoft.nurse.ui.addwater.addwater.ope.daope.AddWaterListDAOpe;
import com.siweisoft.nurse.ui.addwater.addwater.ope.uiope.AddWaterListUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.DelayUINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.io.Serializable;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-17.
 */
//补液卡
public class AddWaterListFrag extends BaseNurseFrag<AddWaterListUIOpe,NurseNetOpe,BaseDBOpe,AddWaterListDAOpe>
        implements PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener{


    PatientAdditionDAOpe patientAdditionDAOpe;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        getOpe().getBaseNurseUIOpe().getRefreshLayout().finishRefresh();
                        ((AppBaseExpandableListAdapter)(getOpe().getBaseNurseUIOpe().getListView().getExpandableListAdapter())).setOnAppItemsClickListener(AddWaterListFrag.this);
                    }
                });
            }
        });
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getData(final OnFinishListener onFinishListener){
        getOpe().getBaseNetOpe().addwater_list(patientAdditionDAOpe.getPatientBedResBean().get住院号(),"71",getOpe().getBaseDAOpe().getStartTime(),getOpe().getBaseDAOpe().getEndtime(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    getOpe().getBaseDAOpe().setAddWaterListResBean(GsonUtil.getInstance().fromJson(o.toString(),AddWaterListResBean.class));
                    getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getAddWaterListResBean());
                    getOpe().getBaseNurseUIOpe().getListView().setOnHeaderUpdateListener(AddWaterListFrag.this);
                }
                onFinishListener.onFinish(o);
            }
        });
    }

    @Override
    public BaseNurseOpes<AddWaterListUIOpe, NurseNetOpe, BaseDBOpe, AddWaterListDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new AddWaterListUIOpe(activity,getView()),new NurseNetOpe(activity),null,new AddWaterListDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addwater_list;
    }

    @Override
    public View getPinnedHeader() {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_head_addwater,null);
        view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return view;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if(getOpe().getBaseDAOpe()==null || getOpe().getBaseDAOpe().getAddWaterListResBean()==null || firstVisibleGroupPos<0 || getOpe().getBaseDAOpe().getAddWaterListResBean().getData().get(firstVisibleGroupPos)==null){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        AddWaterListHeadUIBean uiBean = new AddWaterListHeadUIBean(activity,headerView);
        uiBean.getNameTV().setText(StringUtil.getStr(getOpe().getBaseDAOpe().getAddWaterListResBean().getData().get(firstVisibleGroupPos).getAdvCon()+getOpe().getBaseDAOpe().getAddWaterListResBean().getData().get(firstVisibleGroupPos).getStart()));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA, (Serializable) view.getTag(R.id.data));
        FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new AddWaterDetailFrag(),bundle,ValueConstant.CODE_REQUSET1);
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                DialogUtil.showTimePick(activity,getFragmentManager(),"date", Type.ALL, new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        getOpe().getBaseDAOpe().setStartTime(DateFormatUtil.convent_yyyyMMddHHMM(new Date(millseconds)));
                        getOpe().getBaseDAOpe().setEndtime(DateFormatUtil.getTomorromTimeYYYYMMdd()+" 00:00");
                        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh();
                    }
                });
                break;
        }
    }

}
