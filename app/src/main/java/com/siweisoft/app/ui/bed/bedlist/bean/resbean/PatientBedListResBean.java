package com.siweisoft.app.ui.bed.bedlist.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class PatientBedListResBean extends ResultResBean {

    ArrayList<PatientBedResBean> data;

    public ArrayList<PatientBedResBean> getData() {
        return data;
    }

    public void setData(ArrayList<PatientBedResBean> data) {
        this.data = data;
    }
}
