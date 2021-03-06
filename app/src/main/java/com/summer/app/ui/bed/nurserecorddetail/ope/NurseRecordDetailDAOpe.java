package com.summer.app.ui.bed.nurserecorddetail.ope;

import android.content.Context;

import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.app.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.ope.BaseDAOpe;

/**
 * Created by ${viwmox} on 2017-03-03.
 */

public class NurseRecordDetailDAOpe<A extends CommonUIFrag2> extends BaseDAOpe<A> {

    NurseRecordResBean nurseRecordResBean;

    PatientBedResBean patientBedResBean;

    public NurseRecordDetailDAOpe(Context context, A a) {
        super(context);
        frag = a;
    }

    public NurseRecordResBean getNurseRecordResBean() {
        return nurseRecordResBean;
    }

    public PatientBedResBean getPatientBedResBean() {
        return patientBedResBean;
    }

    public void setNurseRecordResBean(NurseRecordResBean nurseRecordResBean) {
        this.nurseRecordResBean = nurseRecordResBean;
    }

    public void setPatientBedResBean(PatientBedResBean patientBedResBean) {
        this.patientBedResBean = patientBedResBean;
    }
}
