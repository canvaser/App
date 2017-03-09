package com.siweisoft.ui.bed.nurserecorddetail.bean.reqbean;

import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordReqBean extends BaseNurseReqBean {

    private String type;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
