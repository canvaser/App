package com.siweisoft.nurse.ui.bed.advice.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.DatePickUitl;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.MyMission.bean.uibean.MyMissionHeadUIBean;
import com.siweisoft.nurse.ui.bed.advice.bean.resbean.AdviceListResBean;
import com.siweisoft.nurse.ui.bed.advice.ope.AdviceUIOpe;
import com.siweisoft.nurse.ui.bed.advice.ope.GetPatientAdviceNetOpe;
import com.siweisoft.nurse.ui.bed.advice.ope.TimeSortOpe;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.util.Calendar;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class AdviceFrag extends BaseNurseFrag<AdviceUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> implements
        ExpandableListView.OnChildClickListener,
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener {


    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public BaseNurseOpes<AdviceUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AdviceUIOpe(activity, getView()), new NurseNetOpe(activity), null, null);
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
           return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        getOpe().getBaseNurseUIOpe().initTitle(patientAdditionDAOpe.getPatientBedResBean().get住院号() + patientAdditionDAOpe.getPatientBedResBean().get姓名());
        getOpe().getBaseNurseUIOpe().getDoubleExpandView().setOnHeaderUpdateListener(this);
        getOpe().getBaseNurseUIOpe().getDoubleExpandView().setOnChildClickListener(this);
        getOpe().getBaseNurseUIOpe().getMaterialRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getBaseNurseUIOpe().getMaterialRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }


    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        super.onRefresh(materialRefreshLayout);
        getData(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                materialRefreshLayout.finishRefresh();
            }
        });
    }

    public void getData(final OnFinishListener onFinishListener) {
        getOpe().getBaseNetOpe().getPatientAdviceData(patientAdditionDAOpe.getPatientBedResBean().get住院号(), new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    AdviceListResBean adviceListResBean = GsonUtil.getInstance().fromJson(o.toString(),AdviceListResBean.class);
                    getOpe().getBaseNurseUIOpe().initAdviceList(new TimeSortOpe().sortTime(adviceListResBean.getData()));
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_advice;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    @Override
    public View getPinnedHeader() {
        View headerView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.list_head_advice, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (firstVisibleGroupPos < 0 || getOpe().getBaseNurseUIOpe() == null || getOpe().getBaseNurseUIOpe().getAdviceListAdapter() == null) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        MyMissionHeadUIBean myMissionHeadUIBean = new MyMissionHeadUIBean(activity,headerView);
        myMissionHeadUIBean.getTitleTV().setText(DataValue.STATUS_TYPE_TIME.get(firstVisibleGroupPos));
        myMissionHeadUIBean.getNumTV().setText(StringUtil.getStr(getOpe().getBaseNurseUIOpe().getAdviceListAdapter().getChildrenCount(firstVisibleGroupPos)));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {

    }

    @OnClick({BaseID.ID_RIGHT, BaseID.ID_MID})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, patientAdditionDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        getOpe().getBaseNurseUIOpe().initTitle(patientAdditionDAOpe.getPatientBedResBean().get住院号() + patientAdditionDAOpe.getPatientBedResBean().get姓名());
                        getOpe().getBaseNurseUIOpe().getMaterialRefreshLayout().autoRefresh();
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                DialogUtil.showTimePick(activity, getFragmentManager(), "date", Type.ALL, new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {

                    }
                });
                break;
        }
    }
}
