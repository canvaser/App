package com.siweisoft.nurse.ui.user.login.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginReqBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserNetBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class LoginNetOpe extends BaseNetOpe{


    public LoginNetOpe(Context context) {
        super(context);
    }

    public void onGetallregionbyuser(String account,OnNetWorkReqInterf reqInterf) {

        GetallregionbyuserNetBean getallregionbyuserNetBean = new GetallregionbyuserNetBean();
        getallregionbyuserNetBean.setUid(account);
        NetWork.getInstance(context).doHttpRequset(context, DataValue.URL_GETALLREGIONBYUSER,getallregionbyuserNetBean, reqInterf);
    }

    public void onLogin(String account,String pwd,OnNetWorkReqInterf reqInterf) {

        DoLoginReqBean doLoginReqBean = new DoLoginReqBean();
        doLoginReqBean.setDeviceid(ValueConstant.UUUID);
        doLoginReqBean.setPassword(pwd);
        doLoginReqBean.setUsername(account);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_DOLOGIN, doLoginReqBean, reqInterf);
    }

    public void onDologout(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_DOLOGIN_OUT, baseReqBean, reqInterf);
    }
}
