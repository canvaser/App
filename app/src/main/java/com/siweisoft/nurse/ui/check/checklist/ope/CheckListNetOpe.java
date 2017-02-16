package com.siweisoft.nurse.ui.check.checklist.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.check.checklist.bean.reqbean.UpdateCheckListReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class CheckListNetOpe extends BaseNetOpe {


    public CheckListNetOpe(Context context) {
        super(context);
    }


    public void getCheckTasks(BaseNurseReqBean reqBean,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_CHECK_TASK, reqBean, reqInterf);
    }


    public void updateCheckStatus(UpdateCheckListReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_CHECK_TASK, reqBean, reqInterf);
    }


}
