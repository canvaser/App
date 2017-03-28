package com.summer.lib.ope;

//by summer on 2017-03-28.

import android.content.Context;

import com.summer.lib.bean.BaseUIBean;

public class BaseUIOpe<A extends BaseUIBean> extends BaseOpe {

    protected A uiBean;

    protected Context context;

    public BaseUIOpe(Context context, A uiBean) {
        this.context = context;
        this.uiBean = uiBean;
    }

    private BaseUIOpe() {

    }

    public A getUiBean() {
        return uiBean;
    }
}
