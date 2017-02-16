package com.siweisoft.nurse.ui.bed.patient.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.patient.bean.reqbean.PatientAdditionReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class PatientNetOpe extends BaseNetOpe {


    public PatientNetOpe(Context context) {
        super(context);
    }


    public void getPatientAdditionData(PatientBedResBean resBean, OnNetWorkReqInterf reqInterf) {

        PatientAdditionReqBean patientAdditionReqBean = new PatientAdditionReqBean();
        patientAdditionReqBean.setZyh(resBean.get住院号());
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_ADDITION, patientAdditionReqBean, reqInterf);
    }

}
