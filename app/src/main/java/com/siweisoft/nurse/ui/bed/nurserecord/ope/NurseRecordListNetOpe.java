package com.siweisoft.nurse.ui.bed.nurserecord.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class NurseRecordListNetOpe extends BaseNetOpe {


    public NurseRecordListNetOpe(Context context) {
        super(context);
    }


    public void getTaskSummaryByPatient(BaseNurseReqBean reqBean,OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_SUMMARY_BY_PAITENT, reqBean, reqInterf);
    }
}
