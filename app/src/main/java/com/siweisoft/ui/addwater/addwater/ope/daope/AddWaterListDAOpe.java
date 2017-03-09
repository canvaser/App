package com.siweisoft.ui.addwater.addwater.ope.daope;

import android.content.Context;

import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.ui.bed.patient.ope.PatientAdditionDAOpe;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterListDAOpe<A extends CommonUIFrag2> extends BaseDAOpe<A> {

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
        return !(getFrag().getArguments() == null || getFrag().getArguments().getSerializable(ValueConstant.DATA_DATA) == null);
    }

    public PatientAdditionDAOpe getPatientAdditionDAOpe() {
        return patientAdditionDAOpe;
    }

    public void setPatientAdditionDAOpe(PatientAdditionDAOpe patientAdditionDAOpe) {
        this.patientAdditionDAOpe = patientAdditionDAOpe;
    }
}
