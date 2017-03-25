package com.summer.app.ui.bed.addmypatient.bean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientListAdapterBean extends ResultResBean {

    ArrayList<AddMyPatientAdapterBean> data;

    public ArrayList<AddMyPatientAdapterBean> getData() {
        return data;
    }

    public void setData(ArrayList<AddMyPatientAdapterBean> data) {
        this.data = data;
    }
}
