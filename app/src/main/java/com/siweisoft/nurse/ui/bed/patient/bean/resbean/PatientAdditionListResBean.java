package com.siweisoft.nurse.ui.bed.patient.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.network.bean.res.BaseResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class PatientAdditionListResBean extends BaseBean{

    private ArrayList<PatientAdditionResBean> data;

    public ArrayList<PatientAdditionResBean> getData() {
        return data;
    }

    public void setData(ArrayList<PatientAdditionResBean> data) {
        this.data = data;
    }
}
