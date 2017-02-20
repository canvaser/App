package com.siweisoft.nurse.ui.bed.nurserecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.siweisoft.nurse.ui.bed.nurserecord.ope.NurseRecordUIOpe;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.fragment.NurseRecordDetailFrag;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class NurseRecordFrag extends BaseNurseFrag<NurseRecordUIOpe,NurseNetOpe,BaseDBOpe,BaseDAOpe> implements OnAppItemClickListener {


    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public BaseNurseOpes<NurseRecordUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new NurseRecordUIOpe(activity,getView()),new NurseNetOpe(activity),null,null);
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
        getOpe().getBaseNurseUIOpe().initTile(patientAdditionDAOpe.getPatientBedResBean().get病人住院号()+" "+patientAdditionDAOpe.getPatientBedResBean().get姓名());
        getData();

    }

    public void getData(){
        getOpe().getBaseNetOpe().getTaskSummaryByPatient(patientAdditionDAOpe.getPatientBedResBean().get住院号(), new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    NurseRecordListResBean nurseRecordListResBean = GsonUtil.getInstance().fromJson(o.toString(),NurseRecordListResBean.class);
                    getOpe().getBaseNurseUIOpe().initList(nurseRecordListResBean.getData());
                    getOpe().getBaseNurseUIOpe().getNurseRecordListAdapter().setOnAppItemClickListener(NurseRecordFrag.this);
                }
            }
        });
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_MID:
                getOpe().getBaseNurseUIOpe().showMidList(activity, patientAdditionDAOpe.getNames(), v, 0, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        PopupUtil.getInstance().dimess();
                        getOpe().getBaseNurseUIOpe().initTile(patientAdditionDAOpe.getPatientBedResBean().get病人住院号()+" "+patientAdditionDAOpe.getPatientBedResBean().get姓名());
                        getData();
                    }
                });
                break;
        }
    }


    @Override
    public int getContainView() {
        return R.layout.frag_assay;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA2,patientAdditionDAOpe.getPatientBedResBean());
        bundle.putSerializable(ValueConstant.DATA_DATA,getOpe().getBaseNurseUIOpe().getNurseRecordListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(),index,new NurseRecordDetailFrag(),bundle);
    }
}
