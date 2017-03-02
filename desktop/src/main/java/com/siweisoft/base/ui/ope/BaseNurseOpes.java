package com.siweisoft.base.ui.ope;

import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class BaseNurseOpes<A extends BaseNurseUIOpe, B extends BaseNetOpe, C extends BaseDBOpe, D extends BaseDAOpe> implements Serializable {

    A baseNurseUIOpe;

    B baseNetOpe;

    C baseDBOpe;

    D baseDAOpe;

    public BaseNurseOpes(A baseNurseUIOpe, B baseNetOpe, C baseDBOpe, D baseDAOpe) {
        this.baseNurseUIOpe = baseNurseUIOpe;
        this.baseNetOpe = baseNetOpe;
        this.baseDBOpe = baseDBOpe;
        this.baseDAOpe = baseDAOpe;
    }


    public D getBaseDAOpe() {
        return baseDAOpe;
    }

    public void setBaseDAOpe(D baseDAOpe) {
        this.baseDAOpe = baseDAOpe;
    }

    public C getBaseDBOpe() {
        return baseDBOpe;
    }

    public void setBaseDBOpe(C baseDBOpe) {
        this.baseDBOpe = baseDBOpe;
    }

    public B getBaseNetOpe() {
        return baseNetOpe;
    }

    public void setBaseNetOpe(B baseNetOpe) {
        this.baseNetOpe = baseNetOpe;
    }

    public A getBaseNurseUIOpe() {
        return baseNurseUIOpe;
    }

    public void setBaseNurseUIOpe(A baseNurseUIOpe) {
        this.baseNurseUIOpe = baseNurseUIOpe;
    }
}
