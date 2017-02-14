package com.siweisoft.nurse.ui.user.login.ope;

import android.content.Context;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.base.ui.ope.BaseOpe;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class LoginDAOpe extends BaseOpe{


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
