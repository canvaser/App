package com.summer.app.ui.user.login.bean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class NurseTypeResBean extends ResultResBean {

    private ArrayList<String> nurseType;

    public NurseTypeResBean() {
    }

    public ArrayList<String> getNurseType() {
        return nurseType;
    }

    public void setNurseType(ArrayList<String> nurseType) {
        this.nurseType = nurseType;
    }
}
