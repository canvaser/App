package com.summer.app.ui.info.workdetail.bean.resbean;

import com.summer.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailResBean extends ResultResBean {

    private String user_id;

    private String id;

    private String taskname;

    private int 次数;

    private int workload;

    private String 医嘱类别代码;

    private String 医嘱类别名称;

    private String 医嘱详情;

    private String 审核状态;

    private String coeff;

    private String execdate;

    public String getCoeff() {
        return coeff;
    }

    public void setCoeff(String coeff) {
        this.coeff = coeff;
    }

    public String getExecdate() {
        return execdate;
    }

    public void setExecdate(String execdate) {
        this.execdate = execdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String get医嘱类别代码() {
        return 医嘱类别代码;
    }

    public void set医嘱类别代码(String 医嘱类别代码) {
        this.医嘱类别代码 = 医嘱类别代码;
    }

    public String get医嘱类别名称() {
        return 医嘱类别名称;
    }

    public void set医嘱类别名称(String 医嘱类别名称) {
        this.医嘱类别名称 = 医嘱类别名称;
    }

    public String get医嘱详情() {
        return 医嘱详情;
    }

    public void set医嘱详情(String 医嘱详情) {
        this.医嘱详情 = 医嘱详情;
    }

    public String get审核状态() {
        return 审核状态;
    }

    public void set审核状态(String 审核状态) {
        this.审核状态 = 审核状态;
    }

    public int get次数() {
        return 次数;
    }

    public void set次数(int 次数) {
        this.次数 = 次数;
    }
}
