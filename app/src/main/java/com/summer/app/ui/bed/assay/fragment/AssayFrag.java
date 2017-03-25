package com.summer.app.ui.bed.assay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.bed.assay.ope.AssayUIOpe;
import com.summer.app.ui.bed.assaydetail.fragment.AssayDetailFrag;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.ope.BaseDBOpe;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.lib.util.dialog.DialogUtil;
import com.summer.lib.view.pickerview.TimePickerDialog;
import com.summer.lib.view.pickerview.data.Type;
import com.summer.lib.view.pickerview.listener.OnDateSetListener;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.bed.assay.bean.resbean.AssayListResBean;
import com.summer.app.ui.bed.assay.ope.AssayDAOpe;
import com.summer.app.ui.bed.assay.ope.AssaySortOpe;
import com.summer.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.summer.lib.util.fragment.FragManager;

import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AssayFrag extends BaseNurseFrag<AssayUIOpe, NurseNetOpe, BaseDBOpe, AssayDAOpe> implements OnAppItemClickListener {

    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        getOpe().getUiOpe().initTitle(patientAdditionDAOpe.getMidTitle());
        getOpe().getUiOpe().getRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
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
        getOpe().getNetOpe().getAssayDataList(patientAdditionDAOpe.getPatientBedResBean().get住院号(), getOpe().getDaOpe().getBeginTime(), new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    AssayListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), AssayListResBean.class);
                    getOpe().getUiOpe().initList(new AssaySortOpe().sortAssay(resBean.getData()));
                    getOpe().getUiOpe().getAssayListAdapter().setOnAppItemClickListener(AssayFrag.this);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public BaseNurseOpes<AssayUIOpe, NurseNetOpe, BaseDBOpe, AssayDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AssayUIOpe(activity, getView()), new NurseNetOpe(activity), null, new AssayDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_assay;
    }

    @OnClick({BaseID.ID_RIGHT, BaseID.ID_MID})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                DialogUtil.showTimePick(activity, getFragmentManager(), "date", Type.ALL, new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        getOpe().getDaOpe().setBeginTime(DateFormatUtil.convent_YYYYMMDD(new Date(millseconds)));
                        getOpe().getUiOpe().getRefreshLayout().autoRefreshWithUI(0);
                    }
                });
                break;
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, patientAdditionDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        getOpe().getUiOpe().initTitle(patientAdditionDAOpe.getMidTitle());
                        getOpe().getUiOpe().getRefreshLayout().autoRefreshWithUI(0);
                    }
                });
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA, getOpe().getUiOpe().getAssayListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(), index, new AssayDetailFrag(), bundle);
    }
}
