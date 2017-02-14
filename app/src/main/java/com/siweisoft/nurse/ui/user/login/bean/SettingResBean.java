package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class SettingResBean extends BaseBean{

    private String dataUpdateTimer;

    private String notifyTasks;

    private String scanBeep;

    private String scanVibration;

    private String showInSignDay;

    private String showOutSignDay;

    private String assayNotifyDays;

    private String earlierExecTaskTime;

    private String laterExecTaskTime;

    private String changeTaskExecTimeEarly;

    private String changeTaskExecTimeLate;

    private String canAddTask;

    private String nowDateTime;

    public SettingResBean() {
    }

    public String getAssayNotifyDays() {
        return assayNotifyDays;
    }

    public void setAssayNotifyDays(String assayNotifyDays) {
        this.assayNotifyDays = assayNotifyDays;
    }

    public String getCanAddTask() {
        return canAddTask;
    }

    public void setCanAddTask(String canAddTask) {
        this.canAddTask = canAddTask;
    }

    public String getChangeTaskExecTimeEarly() {
        return changeTaskExecTimeEarly;
    }

    public void setChangeTaskExecTimeEarly(String changeTaskExecTimeEarly) {
        this.changeTaskExecTimeEarly = changeTaskExecTimeEarly;
    }

    public String getChangeTaskExecTimeLate() {
        return changeTaskExecTimeLate;
    }

    public void setChangeTaskExecTimeLate(String changeTaskExecTimeLate) {
        this.changeTaskExecTimeLate = changeTaskExecTimeLate;
    }

    public String getDataUpdateTimer() {
        return dataUpdateTimer;
    }

    public void setDataUpdateTimer(String dataUpdateTimer) {
        this.dataUpdateTimer = dataUpdateTimer;
    }

    public String getEarlierExecTaskTime() {
        return earlierExecTaskTime;
    }

    public void setEarlierExecTaskTime(String earlierExecTaskTime) {
        this.earlierExecTaskTime = earlierExecTaskTime;
    }

    public String getLaterExecTaskTime() {
        return laterExecTaskTime;
    }

    public void setLaterExecTaskTime(String laterExecTaskTime) {
        this.laterExecTaskTime = laterExecTaskTime;
    }

    public String getNotifyTasks() {
        return notifyTasks;
    }

    public void setNotifyTasks(String notifyTasks) {
        this.notifyTasks = notifyTasks;
    }

    public String getNowDateTime() {
        return nowDateTime;
    }

    public void setNowDateTime(String nowDateTime) {
        this.nowDateTime = nowDateTime;
    }

    public String getScanBeep() {
        return scanBeep;
    }

    public void setScanBeep(String scanBeep) {
        this.scanBeep = scanBeep;
    }

    public String getScanVibration() {
        return scanVibration;
    }

    public void setScanVibration(String scanVibration) {
        this.scanVibration = scanVibration;
    }

    public String getShowInSignDay() {
        return showInSignDay;
    }

    public void setShowInSignDay(String showInSignDay) {
        this.showInSignDay = showInSignDay;
    }

    public String getShowOutSignDay() {
        return showOutSignDay;
    }

    public void setShowOutSignDay(String showOutSignDay) {
        this.showOutSignDay = showOutSignDay;
    }
}
