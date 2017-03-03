package com.siweisoft.lib.base.ui.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.common.CommonUIFrag2;

public class BaseDAOpe<A extends CommonUIFrag2> extends BaseOpe {

    protected A frag;


    public BaseDAOpe(Context context) {
        super(context);
    }

    public A getFrag() {
        return frag;
    }
}