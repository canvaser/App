package com.siweisoft.nurse.ui.home.bean.reqbean;

import com.siweisoft.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class WriteAlarmReqBean extends BaseReqBean{

    private String zyh;

    private String content;

    private String patname;

    private String level;

    private String update_value;

    private String mode;

    private String id;

    private String logid;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUpdate_value() {
        return update_value;
    }

    public void setUpdate_value(String update_value) {
        this.update_value = update_value;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }
}
