package com.siweisoft.nurse.ui.base.netadapter;

import android.content.Context;
import android.os.Handler;

import com.siweisoft.constant.MethodConstant;
import com.siweisoft.network.bean.res.BaseResBean;
import com.siweisoft.util.LoadUtil;
import com.siweisoft.util.LogUtil;

/**
 * Created by ${viwmox} on 2016-12-02.
 */
public abstract class DelayUINetAdapter extends UINetAdapter {


    private int delay = 500;

    Handler handler = new Handler();

    public DelayUINetAdapter(Context context, int delay) {
        super(context);
    }

    public DelayUINetAdapter(Context context) {
        super(context);
    }


    @Override
    public void onNetWorkReqFinish(boolean haveData, String url, final BaseResBean baseResBean) {
        if (!haveData) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    onNetWorkResult(false, baseResBean);
                    LoadUtil.getInstance().onStopLoading(tag);
                }
            }, delay);
        } else {
            if (baseResBean.isException()) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onNetWorkResult(false, baseResBean);
                        LoadUtil.getInstance().onStopLoading(tag);
                    }
                }, delay);
            } else {
                if (baseResBean.getData() == null) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onNetWorkResult(true, MethodConstant.toObject(baseResBean.getData()));
                            LoadUtil.getInstance().onStopLoading(tag);
                        }
                    }, delay);
                } else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onNetWorkResult(true, MethodConstant.toObject(baseResBean.getData()));
                            LoadUtil.getInstance().onStopLoading(tag);
                        }
                    }, delay);
                }
            }
        }
    }
}
