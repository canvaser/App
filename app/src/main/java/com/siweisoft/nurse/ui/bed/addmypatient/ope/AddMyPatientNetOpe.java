package com.siweisoft.nurse.ui.bed.addmypatient.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientNetOpe extends BaseNetOpe {


    public AddMyPatientNetOpe(Context context) {
        super(context);
    }


    public void updateMyPatientList(MyPaitentUpdateListReqBean myPaitentUpdateListReqBean,OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_Y_PATIENT_LIST, myPaitentUpdateListReqBean, reqInterf);
    }
}
