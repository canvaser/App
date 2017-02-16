package com.siweisoft.nurse.ui.bed.shiftdute.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class ShiftDuteListNetOpe extends BaseNetOpe {


    public ShiftDuteListNetOpe(Context context) {
        super(context);
    }


    public void getMyPatientList(BaseNurseReqBean reqBean,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_LIST_RESULT_PATIENT, reqBean, reqInterf);
    }
}
