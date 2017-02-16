package com.siweisoft.nurse.ui.bed.handoverreport.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class HandOverNetOpe extends BaseNetOpe {


    public HandOverNetOpe(Context context) {
        super(context);
    }


    public void getPatientReportData(BaseNurseReqBean reqBean,OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_REPORT, reqBean, reqInterf);
    }
}
