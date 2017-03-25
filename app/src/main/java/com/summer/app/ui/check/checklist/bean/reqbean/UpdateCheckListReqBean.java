package com.summer.app.ui.check.checklist.bean.reqbean;


import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class UpdateCheckListReqBean extends BaseReqBean {
    private String taskids;

    private String id;

    private String checkWay;

    private String status;

    public String getCheckWay() {
        return checkWay;
    }

    public void setCheckWay(String checkWay) {
        this.checkWay = checkWay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
