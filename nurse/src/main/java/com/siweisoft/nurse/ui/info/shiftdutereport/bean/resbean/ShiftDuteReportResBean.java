package com.siweisoft.nurse.ui.info.shiftdutereport.bean.resbean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteReportResBean {

    private String nid;

    private String create_time;

    private String user_id;

    private String displayname;

    private String 总数;

    private String 入院;

    private String 转出;

    private String 出院;

    private String 转入;

    private String 死亡;

    private String 割症;

    private String 接生;

    private String 病危;

    private String 内容;

    private String 班次;

    private String bcTitle;

    private ArrayList<String> allBC;

    public ArrayList<String> getAllBC() {
        return allBC;
    }

    public void setAllBC(ArrayList<String> allBC) {
        this.allBC = allBC;
    }

    public String getBcTitle() {
        return bcTitle;
    }

    public void setBcTitle(String bcTitle) {
        this.bcTitle = bcTitle;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String get入院() {
        return 入院;
    }

    public void set入院(String 入院) {
        this.入院 = 入院;
    }

    public String get内容() {
        return 内容;
    }

    public void set内容(String 内容) {
        this.内容 = 内容;
    }

    public String get出院() {
        return 出院;
    }

    public void set出院(String 出院) {
        this.出院 = 出院;
    }

    public String get割症() {
        return 割症;
    }

    public void set割症(String 割症) {
        this.割症 = 割症;
    }

    public String get总数() {
        return 总数;
    }

    public void set总数(String 总数) {
        this.总数 = 总数;
    }

    public String get接生() {
        return 接生;
    }

    public void set接生(String 接生) {
        this.接生 = 接生;
    }

    public String get死亡() {
        return 死亡;
    }

    public void set死亡(String 死亡) {
        this.死亡 = 死亡;
    }

    public String get班次() {
        return 班次;
    }

    public void set班次(String 班次) {
        this.班次 = 班次;
    }

    public String get病危() {
        return 病危;
    }

    public void set病危(String 病危) {
        this.病危 = 病危;
    }

    public String get转入() {
        return 转入;
    }

    public void set转入(String 转入) {
        this.转入 = 转入;
    }

    public String get转出() {
        return 转出;
    }

    public void set转出(String 转出) {
        this.转出 = 转出;
    }
}
