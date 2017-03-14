package com.siweisoft.app.ui.bed.advice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

import com.siweisoft.app.R;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.nursevalue.BaseID;
import com.siweisoft.app.ui.bed.advice.ope.AdviceUIOpe;
import com.siweisoft.app.ui.bed.persontask.bean.uibean.MyMissionHeadUIBean;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.app.nursevalue.DataValue;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.app.ui.bed.advice.bean.resbean.AdviceListResBean;
import com.siweisoft.app.ui.bed.advice.ope.AdviceDAOpe;
import com.siweisoft.app.ui.bed.advice.ope.TimeSortOpe;
import com.siweisoft.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.app.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class AdviceFrag extends BaseNurseFrag<AdviceUIOpe, NurseNetOpe, BaseDBOpe, AdviceDAOpe> implements
        ExpandableListView.OnChildClickListener,
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener {


    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public BaseNurseOpes<AdviceUIOpe, NurseNetOpe, BaseDBOpe, AdviceDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AdviceUIOpe(activity, getView()), new NurseNetOpe(activity), null, new AdviceDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        getOpe().getUiOpe().initTitle(patientAdditionDAOpe.getMidTitle());
        getOpe().getUiOpe().getDoubleExpandView().setOnHeaderUpdateListener(this);
        getOpe().getUiOpe().getDoubleExpandView().setOnChildClickListener(this);
        getOpe().getUiOpe().getMaterialRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getUiOpe().getMaterialRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }


    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        super.onRefresh(materialRefreshLayout);
        getData(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                materialRefreshLayout.finishRefreshingDelay();
            }
        });
    }

    public void getData(final OnFinishListener onFinishListener) {
        getOpe().getNetOpe().getPatientAdviceData(patientAdditionDAOpe.getPatientBedResBean().get住院号(), getOpe().getDaOpe().getBegin(), new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    AdviceListResBean adviceListResBean = GsonUtil.getInstance().fromJson(o.toString(), AdviceListResBean.class);
                    getOpe().getDaOpe().cutTime(adviceListResBean.getData());
                    getOpe().getUiOpe().initAdviceList(new TimeSortOpe().sortTime(adviceListResBean.getData()));
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
        View headerView = LayoutInflater.from(activity).inflate(R.layout.list_head_advice, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (firstVisibleGroupPos < 0 || getOpe().getUiOpe() == null || getOpe().getUiOpe().getAdviceListAdapter() == null) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        MyMissionHeadUIBean myMissionHeadUIBean = new MyMissionHeadUIBean(activity, headerView);
        myMissionHeadUIBean.getTitleTV().setText(DataValue.STATUS_TYPE_TIME.get(firstVisibleGroupPos));
        myMissionHeadUIBean.getNumTV().setText(StringUtil.getStr(getOpe().getUiOpe().getAdviceListAdapter().getChildrenCount(firstVisibleGroupPos)));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {

    }

    @OnClick({BaseID.ID_RIGHT, BaseID.ID_MID})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, patientAdditionDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        getOpe().getUiOpe().initTitle(patientAdditionDAOpe.getPatientBedResBean().get住院号() + patientAdditionDAOpe.getPatientBedResBean().get姓名());
                        getOpe().getUiOpe().getMaterialRefreshLayout().autoRefresh();
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                DialogUtil.showTimePick(activity, getFragmentManager(), "date", Type.YEAR_MONTH_DAY, new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        getOpe().getDaOpe().setBegin(DateFormatUtil.convent_yyyyMMdd(new Date(millseconds)));
                        getOpe().getUiOpe().getMaterialRefreshLayout().autoRefresh();
                    }
                });
                break;
        }
    }
}
