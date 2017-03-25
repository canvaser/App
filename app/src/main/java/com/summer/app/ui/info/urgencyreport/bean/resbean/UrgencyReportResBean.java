package com.summer.app.ui.info.urgencyreport.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UrgencyReportResBean extends ResultResBean {

    private String id;

    private String user_id;

    private String zyh;

    private String patname;

    private String content;

    private String source;

    private String level;

    private String update_user;

    private String update_time;

    private String update_value;

    private String create_time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public String getUpdate_value() {
        return update_value;
    }

    public void setUpdate_value(String update_value) {
        this.update_value = update_value;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
