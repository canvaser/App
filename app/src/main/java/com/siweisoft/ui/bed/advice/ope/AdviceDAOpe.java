package com.siweisoft.ui.bed.advice.ope;

import com.siweisoft.lib.base.ui.bean.databean.BaseDABean;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.ui.bed.advice.bean.resbean.AdviceResBean;
import com.siweisoft.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-02.
 */
public class AdviceDAOpe extends BaseDABean {

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


    public void cutTime(ArrayList<AdviceResBean> data) {
        if (data == null) {
            return;
        }
        for (int i = 0; i < data.size(); i++) {
            if (NullUtil.isStrEmpty(data.get(i).get结束时间s())) {
                continue;
            }
            try {
                data.get(i).set结束时间s(DateFormatUtil.convent_MMddHHMM(DateFormatUtil.convent_yyyyMMddHHmmss(data.get(i).get结束时间s())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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
}
