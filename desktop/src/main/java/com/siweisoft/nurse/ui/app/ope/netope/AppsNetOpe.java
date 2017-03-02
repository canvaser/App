package com.siweisoft.nurse.ui.app.ope.netope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppsNetOpe extends BaseNetOpe {


    public AppsNetOpe(Context context) {
        super(context);
    }

    public void onNetLoadData(Context context, String model, BaseReqBean baseReqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequset(context, model, baseReqBean, reqInterf);
    }
}
