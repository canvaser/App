package com.siweisoft.nurse.ui.index.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.index.bean.reqbean.WriteAlarmReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class HomeNetOpe extends BaseNetOpe {


    public HomeNetOpe(Context context) {
        super(context);
    }


    public void getAdditionList(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_ADDITION, new BaseReqBean(), reqInterf);
    }

    public void writeAlarmLogs(WriteAlarmReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_ALARM_LOG, reqBean, reqInterf);
    }


    public void keepAlive(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_KEEP_ALIVE, new BaseReqBean(), reqInterf);
    }


}
