package com.siweisoft.lib.base.ui.common;

public class CommonDAOpe<A extends CommonUIFrag> extends CommonOpe {

    protected A frag;

    public CommonDAOpe(A frag) {
        this.frag = frag;
    }

    public A getFrag() {
        return frag;
    }
}