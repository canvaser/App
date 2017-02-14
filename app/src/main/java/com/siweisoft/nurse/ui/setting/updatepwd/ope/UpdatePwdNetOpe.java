package com.siweisoft.nurse.ui.setting.updatepwd.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.setting.updatepwd.bean.reqbean.UpdatePwdReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class UpdatePwdNetOpe extends BaseNetOpe{


    public UpdatePwdNetOpe(Context context) {
        super(context);
    }


    public void changePassword(UpdatePwdReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_CHANGE_PWD, reqBean, reqInterf);
    }

}
