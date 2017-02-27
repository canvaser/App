package com.siweisoft.nurse.ui.addwater.addwater.ope.daope;

import android.content.Context;

import com.siweisoft.lib.base.ui.fragment.CommonUIFrag;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterListDAOpe<A extends CommonUIFrag> extends BaseDAOpe<A> {

    AddWaterListResBean addWaterListResBean;

    private String startTime;

    private String endtime;

    PatientAdditionDAOpe patientAdditionDAOpe;

    public AddWaterListDAOpe(Context context, A a) {
        super(context);
        this.frag = a;
    }

    public AddWaterListResBean getAddWaterListResBean() {
        return addWaterListResBean;
    }

    public void setAddWaterListResBean(AddWaterListResBean addWaterListResBean) {
        this.addWaterListResBean = addWaterListResBean;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public boolean canGoOn() {
        if (getFrag().getArguments() == null || getFrag().getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return false;
        }
        return true;
    }

    public PatientAdditionDAOpe getPatientAdditionDAOpe() {
        return patientAdditionDAOpe;
    }

    public void setPatientAdditionDAOpe(PatientAdditionDAOpe patientAdditionDAOpe) {
        this.patientAdditionDAOpe = patientAdditionDAOpe;
    }
}
