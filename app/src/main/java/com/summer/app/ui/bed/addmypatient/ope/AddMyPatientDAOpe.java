package com.summer.app.ui.bed.addmypatient.ope;

import android.content.Context;

import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.lib.base.ui.ope.BaseDAOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-03-09.
 */

public class AddMyPatientDAOpe extends BaseDAOpe {
    ArrayList<PatientBedResBean> validList = new ArrayList<>();

    public AddMyPatientDAOpe(Context context) {
        super(context);
    }

    public ArrayList<PatientBedResBean> getValidList() {
        return validList;
    }

    public void setValidList(ArrayList<PatientBedResBean> validList) {
        this.validList = validList;
    }
}
