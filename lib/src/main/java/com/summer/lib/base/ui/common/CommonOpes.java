package com.summer.lib.base.ui.common;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class CommonOpes<A extends CommonUIOpe, B extends CommonDAOpe> implements Serializable {

    A uiOpe;

    B daOpe;

    public CommonOpes(A uiOpe, B daOpe) {
        this.uiOpe = uiOpe;
        this.daOpe = daOpe;
    }

    public B getDaOpe() {
        return daOpe;
    }

    public void setDaOpe(B daOpe) {
        this.daOpe = daOpe;
    }

    public A getUiOpe() {
        return uiOpe;
    }

    public void setUiOpe(A uiOpe) {
        this.uiOpe = uiOpe;
    }
}
