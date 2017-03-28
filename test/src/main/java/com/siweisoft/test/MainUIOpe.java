package com.siweisoft.test;

//by summer on 2017-03-25.

import android.content.Context;

import com.summer.lib.ope.BaseUIOpe;


public class MainUIOpe extends BaseUIOpe<MainUIBean> {


    public MainUIOpe(Context context, MainUIBean uiBean) {
        super(context, uiBean);
    }

    public void o() {
        uiBean.checkBox.setChecked(true);
    }
}
