package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class NurseTypeResBean extends BaseBean{

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
