package com.siweisoft.nurse.ui.info.urgencyreport.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class UrgencyReportNetOpe extends BaseNetOpe {


    public UrgencyReportNetOpe(Context context) {
        super(context);
    }


    public void getAlarmLogs(BaseNurseReqBean reqBean,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_ALARM_LOGS, reqBean, reqInterf);
    }

}
