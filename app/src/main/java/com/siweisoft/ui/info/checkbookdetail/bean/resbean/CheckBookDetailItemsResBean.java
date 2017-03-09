package com.siweisoft.ui.info.checkbookdetail.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookDetailItemsResBean extends ResultResBean {

    private String itemname;


    private String value;

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
