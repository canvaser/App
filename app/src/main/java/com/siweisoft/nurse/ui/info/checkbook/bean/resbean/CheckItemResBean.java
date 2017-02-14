package com.siweisoft.nurse.ui.info.checkbook.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckItemResBean extends BaseBean{

    private String fileid;

    private String itemid;

    private String itemname;

    private String value;

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
