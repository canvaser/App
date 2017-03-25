package com.summer.nurse.ui.index.ope;

import android.content.Context;

import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.network.NetWork;
import com.summer.network.bean.req.BaseReqBean;
import com.summer.network.interf.OnNetWorkReqInterf;
import com.summer.nurse.nursevalue.DataValue;
import com.summer.nurse.ui.index.bean.reqbean.WriteAlarmReqBean;

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
