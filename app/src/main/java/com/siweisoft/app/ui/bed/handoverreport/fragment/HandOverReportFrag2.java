package com.siweisoft.app.ui.bed.handoverreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.nursevalue.BaseID;
import com.siweisoft.app.ui.bed.handoverreport.ope.HandOverReportUIOpe;
import com.siweisoft.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.app.ui.bed.shiftdute.bean.resbean.ShiftDuteListResBean;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseOpes;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.app.ui.bed.bedlist.ope.BedListDAOpe;
import com.siweisoft.app.ui.bed.inputhandoverreport.fragment.InputHandOverReportFrag;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.app.ui.dialog.dialog.fragment.NurseDialogFrag;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class HandOverReportFrag2 extends CommonUIFrag2<HandOverReportUIOpe<HandOverReportFrag2>, BaseDAOpe> implements OnAppItemClickListener {


    NurseNetOpe handOverNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        baseOpes.getUiOpe().initMid(patientAdditionDAOpe.getMidTitle());
        handOverNetOpe = new NurseNetOpe(activity);
        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }


    @Override
    public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
        super.onRefresh(materialRefreshLayout);
        getData();
    }

    public void getData() {
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setZyh(patientAdditionDAOpe.getPatientBedResBean().get住院号());
        handOverNetOpe.getPatientReportData(baseNurseReqBean, new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    ShiftDuteListResBean shiftDuteListResBean = GsonUtil.getInstance().fromJson(o.toString(), ShiftDuteListResBean.class);
                    baseOpes.getUiOpe().initList(shiftDuteListResBean.getData());
                    baseOpes.getUiOpe().getShiftDuteListAdpter().setOnAppItemClickListener(HandOverReportFrag2.this);
                }
                baseOpes.getUiOpe().getRefreshLayout().finishRefreshingDelay();
            }
        });
    }


    @OnClick({BaseID.ID_MID, BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, new BedListDAOpe(activity, null).getPatientNames(patientAdditionDAOpe.getPatientBedResBeen()), NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        baseOpes.getUiOpe().getMidTV().setText(patientAdditionDAOpe.getMidTitle());
                        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(0);
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putString(ValueConstant.DATA_TYPE, InputHandOverReportFrag.TYPE_INPUT);
                bundle.putSerializable(ValueConstant.DATA_DATA, patientAdditionDAOpe);
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new InputHandOverReportFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA2, baseOpes.getUiOpe().getData().get(position));
        bundle.putString(ValueConstant.DATA_TYPE, InputHandOverReportFrag.TYPE_PLAY);
        FragManager.getInstance().startFragment(getFragmentManager(), index, new InputHandOverReportFrag(), bundle);
    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new HandOverReportUIOpe<HandOverReportFrag2>(activity, getView(), this), null);
        }
        return R.layout.frag_handoverreprot;
    }
}
