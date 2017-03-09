package com.siweisoft.ui.mission.missiondetail.bean.reqbean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class MissisonDetailReqBean extends BaseReqBean {

    private String taskids;

    private String id;

    private String drugconfirm;

    private String status;

    private String region;

    public String getDrugconfirm() {
        return drugconfirm;
    }

    public void setDrugconfirm(String drugconfirm) {
        this.drugconfirm = drugconfirm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskids() {
        return taskids;
    }

    public void setTaskids(String taskids) {
        this.taskids = taskids;
    }
}
