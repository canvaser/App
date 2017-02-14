package com.siweisoft.nurse.ui.bed.additionlist.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.additionlist.bean.reqbean.UpdateAdditionReqBean;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AdditionListNetOpe extends BaseNetOpe{


    public AdditionListNetOpe(Context context) {
        super(context);
    }


    public void updateMyPatientList(MyPaitentUpdateListReqBean myPaitentUpdateListReqBean,OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_Y_PATIENT_LIST, myPaitentUpdateListReqBean, reqInterf);
    }

    public void writePatientAdditionData(UpdateAdditionReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_PATIENT_ADDITION, reqBean, reqInterf);
    }
}
