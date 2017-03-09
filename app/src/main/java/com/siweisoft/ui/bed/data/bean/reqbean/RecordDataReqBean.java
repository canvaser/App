package com.siweisoft.ui.bed.data.bean.reqbean;

import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-24.
 */
public class RecordDataReqBean extends BaseNurseReqBean {

    private String groupid;

    private String signid;

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getSignid() {
        return signid;
    }

    public void setSignid(String signid) {
        this.signid = signid;
    }
}
