package com.siweisoft.base.ui.ope;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;

/**
 * 逻辑处理类
 * Created by ${viwmox} on 2016-04-27.
 */
public class BaseNetOpe {

    protected Gson gson=new Gson();

    protected  Context context;

    protected Handler handler=new Handler();

    public BaseNetOpe(Context context){
        this.context=context;
    }

    protected void onNetLoadData(Context context, String model, BaseReqBean baseReqBean, OnNetWorkReqInterf reqInterf){
        NetWork.getInstance(context).doHttpRequset(context,model,baseReqBean, reqInterf);
    }
}
