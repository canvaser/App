package com.summer.nurse.ui.app.ope.netope;

import android.content.Context;

import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.network.NetWork;
import com.summer.network.bean.req.BaseReqBean;
import com.summer.network.interf.OnNetWorkReqInterf;

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
