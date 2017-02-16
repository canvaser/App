package com.siweisoft.nurse.ui.bed.inputhandoverreport.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.MyMission.bean.reqbean.GetPatientTaskOfTodayReqBean;
import com.siweisoft.nurse.ui.bed.MyMission.bean.reqbean.GetPatientTaskReqBean;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.bean.reqbean.InputHORReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class InputHORNetOpe extends BaseNetOpe {


    public InputHORNetOpe(Context context) {
        super(context);
    }


    public void writePatientReportData(InputHORReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_PATIENT_REPORT, reqBean, reqInterf);
    }




}
