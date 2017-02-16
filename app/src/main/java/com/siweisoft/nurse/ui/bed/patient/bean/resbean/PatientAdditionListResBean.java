package com.siweisoft.nurse.ui.bed.patient.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class PatientAdditionListResBean extends ResultResBean {

    private ArrayList<PatientAdditionResBean> data;

    public ArrayList<PatientAdditionResBean> getData() {
        return data;
    }

    public void setData(ArrayList<PatientAdditionResBean> data) {
        this.data = data;
    }
}
