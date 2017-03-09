package com.siweisoft.ui.bed.nurserecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nursenet.NurseNetOpe;
import com.siweisoft.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.siweisoft.ui.bed.nurserecord.ope.NurseRecordUIOpe;
import com.siweisoft.ui.bed.nurserecorddetail.fragment.NurseRecordDetailFrag2;
import com.siweisoft.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.ui.dialog.dialog.fragment.NurseDialogFrag;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class NurseRecordFrag extends BaseNurseFrag<NurseRecordUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> implements OnAppItemClickListener {


    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public BaseNurseOpes<NurseRecordUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new NurseRecordUIOpe(activity, getView()), new NurseNetOpe(activity), null, null);
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
        getOpe().getUiOpe().initTile(patientAdditionDAOpe.getMidTitle());
        getOpe().getUiOpe().getRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getUiOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
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
        getOpe().getNetOpe().getTaskSummaryByPatient(patientAdditionDAOpe.getPatientBedResBean().get住院号(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    NurseRecordListResBean nurseRecordListResBean = GsonUtil.getInstance().fromJson(o.toString(), NurseRecordListResBean.class);
                    getOpe().getUiOpe().initList(nurseRecordListResBean.getData());
                    getOpe().getUiOpe().getNurseRecordListAdapter().setOnAppItemClickListener(NurseRecordFrag.this);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @OnClick({BaseID.ID_MID})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, patientAdditionDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {

                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        getOpe().getUiOpe().initTile(patientAdditionDAOpe.getMidTitle());
                        getOpe().getUiOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
                    }
                });
                break;
        }
    }


    @Override
    public int getContainView() {
        return R.layout.frag_nurserecord;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA2, patientAdditionDAOpe.getPatientBedResBean());
        bundle.putSerializable(ValueConstant.DATA_DATA, getOpe().getUiOpe().getNurseRecordListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(), index, new NurseRecordDetailFrag2(), bundle);
    }
}
