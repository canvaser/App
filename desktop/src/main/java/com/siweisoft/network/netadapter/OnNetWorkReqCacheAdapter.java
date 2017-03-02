package com.siweisoft.network.netadapter;

import android.content.Context;

import com.google.gson.Gson;
import com.siweisoft.constant.MethodConstant;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.bean.db.NetCacheDBBean;
import com.siweisoft.network.bean.res.BaseResBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.network.ope.NetCacheDBOpe;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.NetWorkUtil;

/**
 * Created by ${viwmox} on 2016-05-15.
 */
public abstract class OnNetWorkReqCacheAdapter implements OnNetWorkReqInterf {

    protected Context context;
    Gson gson = new Gson();

    protected String tag;

    public OnNetWorkReqCacheAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean onNetWorkReqStart(String tag, String reqjson) {
        this.tag = tag;
        boolean isNetOk = NetWorkUtil.getInstance().getNetisAvailable(context);
        return isNetOk;
    }

    @Override
    public void onNetWorkReqFinish(boolean haveData, String url, BaseResBean baseResBean) {
        LogUtil.E(gson.toJson(baseResBean));
        if (!haveData) {
            onNetWorkResult(false, baseResBean);
            switch (baseResBean.getErrorCode()) {
                case ValueConstant.ERROR_CODE_NET_NO_CONNETCT:
                    NetCacheDBOpe netCacheDBOpe = new NetCacheDBOpe(context, new NetCacheDBBean());
                    netCacheDBOpe.save(MethodValue.getUserInfo(context).getData().getUser().getDisplayname(), baseResBean.getData().toString(), url);
                    break;
            }
        } else {
            if (baseResBean.isException()) {
                onNetWorkResult(false, baseResBean);
            } else {
                if (baseResBean.getData() == null) {
//                    baseResBean.setErrorMessage(ValueConstant.ERROR_STR_DATA_NULL);
//                    baseResBean.setErrorCode(ValueConstant.ERROR_CODE_DATA_NULL);
//                    onNetWorkResult(false,baseResBean);

                    onNetWorkResult(true, MethodConstant.toObject(baseResBean.getData()));
                } else {
                    onNetWorkResult(true, MethodConstant.toObject(baseResBean.getData()));
                }
            }

        }
    }

    public abstract void onNetWorkResult(boolean success, Object o);

}
