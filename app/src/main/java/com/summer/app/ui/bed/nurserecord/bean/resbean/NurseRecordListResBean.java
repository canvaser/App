package com.summer.app.ui.bed.nurserecord.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordListResBean extends ResultResBean {

    ArrayList<NurseRecordResBean> data;

    public ArrayList<NurseRecordResBean> getData() {
        return data;
    }

    public void setData(ArrayList<NurseRecordResBean> data) {
        this.data = data;
    }
}
