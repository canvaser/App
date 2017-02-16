package com.siweisoft.nurse.ui.info.checkbook.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookResBean extends ResultResBean {

    private ArrayList<CheckItemResBean> items;

    private String filetype;

    private String fileid;

    private String filename;

    private String showtype;

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public ArrayList<CheckItemResBean> getItems() {
        return items;
    }

    public void setItems(ArrayList<CheckItemResBean> items) {
        this.items = items;
    }

    public String getShowtype() {
        return showtype;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }
}
