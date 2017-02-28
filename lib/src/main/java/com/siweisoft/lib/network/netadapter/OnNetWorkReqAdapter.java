package com.siweisoft.lib.network.netadapter;

import android.content.Context;

import com.google.gson.Gson;
import com.siweisoft.lib.constant.MethodConstant;
import com.siweisoft.lib.network.bean.res.BaseResBean;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.NetWorkUtil;

import org.json.JSONObject;

/**
 * Created by ${viwmox} on 2016-05-15.
 */
public abstract class OnNetWorkReqAdapter implements OnNetWorkReqInterf {

    protected Context context;
    Gson gson = new Gson();

    protected String tag;

    public OnNetWorkReqAdapter(Context context) {
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
