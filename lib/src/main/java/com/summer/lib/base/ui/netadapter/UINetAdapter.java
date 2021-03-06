package com.summer.lib.base.ui.netadapter;

import android.content.Context;

import com.summer.lib.network.bean.res.BaseResBean;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.LoadUtil;


/**
 * Created by ${viwmox} on 2016-12-01.
 */
public abstract class UINetAdapter extends OnNetWorkReqAdapter {


    public UINetAdapter(Context context) {
        super(context);
    }

    @Override
    public boolean onNetWorkReqStart(String tag, String reqjson) {
        LoadUtil.getInstance().onStartLoading(context, tag);
        return super.onNetWorkReqStart(tag, reqjson);
    }

    @Override
    public void onNetWorkReqFinish(boolean haveData, String url, BaseResBean baseResBean) {
        super.onNetWorkReqFinish(haveData, url, baseResBean);
        LoadUtil.getInstance().onStopLoading(tag);
    }


}
