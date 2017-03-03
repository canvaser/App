package com.siweisoft.nurse.ui.user.login.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;


/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class LoginDAOpe<A extends CommonUIFrag2> extends BaseDAOpe<A> {


    private String suffix;

    private String areaName;

    public LoginDAOpe(Context context) {
        super(context);
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
