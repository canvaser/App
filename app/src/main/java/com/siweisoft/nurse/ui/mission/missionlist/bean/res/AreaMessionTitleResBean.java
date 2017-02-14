package com.siweisoft.nurse.ui.mission.missionlist.bean.res;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMessionTitleResBean extends BaseBean{

    private String id;

    private String title;

    private String 医嘱ID;

    private String taskname;

    private String key;

    private String status;

    private String displayname;

    private String nurse_type;

    private String view_type;

    private String exectime;

    private String creator;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getExectime() {
        return exectime;
    }

    public void setExectime(String exectime) {
        this.exectime = exectime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNurse_type() {
        return nurse_type;
    }

    public void setNurse_type(String nurse_type) {
        this.nurse_type = nurse_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getView_type() {
        return view_type;
    }

    public void setView_type(String view_type) {
        this.view_type = view_type;
    }

    public String get医嘱ID() {
        return 医嘱ID;
    }

    public void set医嘱ID(String 医嘱ID) {
        this.医嘱ID = 医嘱ID;
    }
}
