package com.summer.app.ui.bed.patient.ope;

import com.summer.lib.bean.databean.BaseDABean;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-02.
 */
public class PatientAdditionDAOpe extends BaseDABean {

    private int position;


    ArrayList<PatientBedResBean> patientBedResBeen;


    PatientBedResBean patientBedResBean;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<PatientBedResBean> getPatientBedResBeen() {
        return patientBedResBeen;
    }

    public void setPatientBedResBeen(ArrayList<PatientBedResBean> patientBedResBeen) {
        this.patientBedResBeen = patientBedResBeen;
    }

    public PatientBedResBean getPatientBedResBean() {
        if (position != -1) {
            return patientBedResBeen.get(position);
        }
        return patientBedResBean;
    }


    public ArrayList<String> getNames() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < getPatientBedResBeen().size(); i++) {
            strings.add(getPatientBedResBeen().get(i).get病床号() + " " + getPatientBedResBeen().get(i).get姓名());
        }
        return strings;
    }

    public void setPatientBedResBean(PatientBedResBean patientBedResBean) {
        this.patientBedResBean = patientBedResBean;
    }


    public String getMidTitle() {
        return getPatientBedResBean().get病床号() + "" + getPatientBedResBean().get姓名();
    }
}
