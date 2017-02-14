package com.siweisoft.nurse.ui.bed.nurserecorddetail.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.bean.reqbean.NurseRecordReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class NurseRecordDetailNetOpe extends BaseNetOpe{


    public NurseRecordDetailNetOpe(Context context) {
        super(context);
    }


    public void getTaskDetailByCondition(NurseRecordReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_TASK_DETAIL_BY_CONDITION, reqBean, reqInterf);
    }
}
