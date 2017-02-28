package com.siweisoft.lib.base.ui.ope;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class BaseNurseOpes<A extends BaseNurseUIOpe, B extends BaseNetOpe, C extends BaseDBOpe, D extends BaseDAOpe> implements Serializable {

    A uiOpe;

    B netOpe;

    C dbOpe;

    D daOpe;

    public BaseNurseOpes(A uiOpe, B netOpe, C dbOpe, D daOpe) {
        this.uiOpe = uiOpe;
        this.netOpe = netOpe;
        this.dbOpe = dbOpe;
        this.daOpe = daOpe;
    }


    public D getDaOpe() {
        return daOpe;
    }

    public void setDaOpe(D daOpe) {
        this.daOpe = daOpe;
    }

    public C getDbOpe() {
        return dbOpe;
    }

    public void setDbOpe(C dbOpe) {
        this.dbOpe = dbOpe;
    }

    public B getNetOpe() {
        return netOpe;
    }

    public void setNetOpe(B netOpe) {
        this.netOpe = netOpe;
    }

    public A getUiOpe() {
        return uiOpe;
    }

    public void setUiOpe(A uiOpe) {
        this.uiOpe = uiOpe;
    }
}
