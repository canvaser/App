package com.siweisoft.ui.bed.inputdata.bean.reqbean;

import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class InputDataListReqBean extends BaseNurseReqBean {

    private String groupid;

    private String json_data;

    public String getJson_data() {
        return json_data;
    }

    public void setJson_data(String json_data) {
        this.json_data = json_data;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
}
