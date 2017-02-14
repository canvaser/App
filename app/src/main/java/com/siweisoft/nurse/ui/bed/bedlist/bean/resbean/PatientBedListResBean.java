package com.siweisoft.nurse.ui.bed.bedlist.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class PatientBedListResBean extends BaseBean{

    ArrayList<PatientBedResBean> data;

    public ArrayList<PatientBedResBean> getData() {
        return data;
    }

    public void setData(ArrayList<PatientBedResBean> data) {
        this.data = data;
    }
}
