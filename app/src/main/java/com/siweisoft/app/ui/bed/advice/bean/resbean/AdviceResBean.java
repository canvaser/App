package com.siweisoft.app.ui.bed.advice.bean.resbean;


import com.siweisoft.lib.network.bean.res.BaseResBean;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AdviceResBean extends BaseResBean {

    private String 医嘱详情s;

    private String 医嘱IDs;

    private String AdvType;

    private String 医嘱类别代码s;

    private String codename;

    private String 开始时间s;

    private String 结束时间s;

    private String key;

    public String getAdvType() {
        return AdvType;
    }

    public void setAdvType(String advType) {
        AdvType = advType;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String get医嘱IDs() {
        return 医嘱IDs;
    }

    public void set医嘱IDs(String 医嘱IDs) {
        this.医嘱IDs = 医嘱IDs;
    }

    public String get医嘱类别代码s() {
        return 医嘱类别代码s;
    }

    public void set医嘱类别代码s(String 医嘱类别代码s) {
        this.医嘱类别代码s = 医嘱类别代码s;
    }

    public String get医嘱详情s() {
        return 医嘱详情s;
    }

    public void set医嘱详情s(String 医嘱详情s) {
        this.医嘱详情s = 医嘱详情s;
    }

    public String get开始时间s() {
        return 开始时间s;
    }

    public void set开始时间s(String 开始时间s) {
        this.开始时间s = 开始时间s;
    }

    public String get结束时间s() {
        return 结束时间s;
    }

    public void set结束时间s(String 结束时间s) {
        this.结束时间s = 结束时间s;
    }
}
