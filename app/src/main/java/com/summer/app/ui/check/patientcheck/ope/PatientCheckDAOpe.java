package com.summer.app.ui.check.patientcheck.ope;

import com.summer.app.ui.check.patientcheck.bean.PatAndTaskInfoResBean;
import com.summer.lib.base.ui.common.CommonDAOpe;
import com.summer.lib.base.ui.common.CommonUIFrag;
import com.summer.app.ui.scan.bean.DrugInfoResBean;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class PatientCheckDAOpe extends CommonDAOpe {

    DrugInfoResBean drugInfoResBean;

    PatAndTaskInfoResBean patAndTaskInfoResBean;

    public PatientCheckDAOpe(CommonUIFrag frag) {
        super(frag);
    }

    public DrugInfoResBean getDrugInfoResBean() {
        return drugInfoResBean;
    }

    public void setDrugInfoResBean(DrugInfoResBean drugInfoResBean) {
        this.drugInfoResBean = drugInfoResBean;
    }

    public PatAndTaskInfoResBean getPatAndTaskInfoResBean() {
        return patAndTaskInfoResBean;
    }

    public void setPatAndTaskInfoResBean(PatAndTaskInfoResBean patAndTaskInfoResBean) {
        this.patAndTaskInfoResBean = patAndTaskInfoResBean;
    }
}
