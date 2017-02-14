package com.siweisoft.nurse.ui.user.setting.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class SettingNetOpe extends BaseNetOpe{


    public SettingNetOpe(Context context) {
        super(context);
    }


    public void getReportData(BaseNurseReqBean reqBean,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_REPORT_DATA, reqBean, reqInterf);
    }

}
