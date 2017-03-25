package com.summer.app.ui.bed.advice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.bed.advice.bean.resbean.AdviceTaskResBean;
import com.summer.app.ui.bed.advice.ope.AdviceUIOpe;
import com.summer.app.ui.bed.persontask.bean.uibean.MyMissionHeadUIBean;
import com.summer.app.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseDBOpe;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.lib.util.dialog.DialogUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.pickerview.TimePickerDialog;
import com.summer.lib.view.pickerview.data.Type;
import com.summer.lib.view.pickerview.listener.OnDateSetListener;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.app.nursevalue.DataValue;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.bed.advice.bean.resbean.AdviceListResBean;
import com.summer.app.ui.bed.advice.ope.AdviceDAOpe;
import com.summer.app.ui.bed.advice.ope.TimeSortOpe;
import com.summer.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.text.ParseException;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class AdviceFrag extends BaseNurseFrag<AdviceUIOpe, NurseNetOpe, BaseDBOpe, AdviceDAOpe> implements
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
                    getOpe().getDaOpe().setHashMap(new TimeSortOpe().sortTime(adviceListResBean.getData()));
                    getOpe().getUiOpe().initAdviceList(getOpe().getDaOpe().getHashMap());
                    getOpe().getUiOpe().getAdviceListAdapter().setOnAppItemsClickListener(AdviceFrag.this);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    public void getAdviceTask(String begin, String end, final String adviceid) {
        SimpleNetOpe.getTaskListByAdviceID(activity, begin, end, adviceid, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                AdviceTaskResBean adviceTaskResBean = GsonUtil.getInstance().fromJson(o.toString(), AdviceTaskResBean.class);
                if (success && adviceTaskResBean.getData() != null && adviceTaskResBean.getData().size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ValueConstant.DATA_DATA, getOpe().getDaOpe().getData(adviceTaskResBean, patientAdditionDAOpe.getPatientBedResBean().get姓名()));
                    FragManager.getInstance().startFragment(getFragmentManager(), index, new MissionDetailFrag(), bundle);
                } else {
                    ToastUtil.getInstance().showShort(activity, "无关联任务");
                }
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_advice;
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
        String begin = "";
        String end = "";
        try {
            begin = DateFormatUtil.convent_yyyyMMdd(DateFormatUtil.convent_yyyyMMddHHmmss(getOpe().getDaOpe().getHashMap().get(DataValue.STATUS_TYPE_TIME.get(index)).get(position).get开始时间s())).trim();
            end = DateFormatUtil.convent_yyyyMMdd(DateFormatUtil.convent_yyyyMMddHHmmss(getOpe().getDaOpe().getHashMap().get(DataValue.STATUS_TYPE_TIME.get(index)).get(position).get结束时间s())).trim();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        getAdviceTask(begin, end, getOpe().getDaOpe().getHashMap().get(DataValue.STATUS_TYPE_TIME.get(index)).get(position).get医嘱IDs());
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
                        getOpe().getUiOpe().getMaterialRefreshLayout().autoRefreshWithUI(0);
                    }
                });
                break;
        }
    }
}
