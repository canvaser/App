package com.siweisoft.nurse.ui.bed.addmypatient.bean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientListAdapterBean extends BaseBean{

    ArrayList<AddMyPatientAdapterBean> data;

    public ArrayList<AddMyPatientAdapterBean> getData() {
        return data;
    }

    public void setData(ArrayList<AddMyPatientAdapterBean> data) {
        this.data = data;
    }
}
