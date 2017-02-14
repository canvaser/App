package com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordListResBean extends BaseBean{

    ArrayList<NurseRecordResBean> data;

    public ArrayList<NurseRecordResBean> getData() {
        return data;
    }

    public void setData(ArrayList<NurseRecordResBean> data) {
        this.data = data;
    }
}
