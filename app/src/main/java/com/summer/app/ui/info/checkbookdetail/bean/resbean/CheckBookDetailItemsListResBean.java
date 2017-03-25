package com.summer.app.ui.info.checkbookdetail.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookDetailItemsListResBean extends ResultResBean {

    ArrayList<CheckBookDetailItemsResBean> items;

    private String instruid;

    private String exectime;


    private String shift;

    private String username;

    public String getExectime() {
        return exectime;
    }

    public void setExectime(String exectime) {
        this.exectime = exectime;
    }

    public String getInstruid() {
        return instruid;
    }

    public void setInstruid(String instruid) {
        this.instruid = instruid;
    }

    public ArrayList<CheckBookDetailItemsResBean> getItems() {
        return items;
    }

    public void setItems(ArrayList<CheckBookDetailItemsResBean> items) {
        this.items = items;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
