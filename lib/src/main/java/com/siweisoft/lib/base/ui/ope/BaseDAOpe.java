package com.siweisoft.lib.base.ui.ope;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.siweisoft.lib.base.ui.fragment.CommonUIFrag;
import com.siweisoft.lib.constant.ValueConstant;

public class BaseDAOpe<A extends CommonUIFrag> extends BaseOpe {

    protected A frag;


    public BaseDAOpe(Context context) {
        super(context);
    }

    public A getFrag() {
        return frag;
    }
}