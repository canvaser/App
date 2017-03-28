package com.summer.lib.ope;

//by summer on 2017-03-28.

import java.io.Serializable;

public class BaseOpes<A extends BaseUIOpe, B extends BaseDAOpe> extends BaseOpe {

    A uiope;

    B daope;

    private BaseOpes() {

    }

    public BaseOpes(A uiope, B daope) {
        this.uiope = uiope;
        this.daope = daope;
    }

    public B getDaope() {
        return daope;
    }

    public A getUiope() {
        return uiope;
    }
}
