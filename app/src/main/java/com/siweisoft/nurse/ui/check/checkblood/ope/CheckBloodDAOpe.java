package com.siweisoft.nurse.ui.check.checkblood.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.fragment.CommonUIFrag;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class CheckBloodDAOpe<A extends CommonUIFrag> extends BaseDAOpe<A> {

    String result;

    public CheckBloodDAOpe(Context context) {
        super(context);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
