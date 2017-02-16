package com.siweisoft.nurse.ui.info.bedreport.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportResBean extends ResultResBean {

    private String date;

    private String neww;

    private String bednum;

    private String old;

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNeww() {
        return neww;
    }

    public void setNeww(String neww) {
        this.neww = neww;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }
}
