package com.siweisoft.nurse.ui.check.checklist.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class CheckResBean extends BaseBean{

    private String itemName;

    ArrayList<CheckDataResBean> data;

    public ArrayList<CheckDataResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckDataResBean> data) {
        this.data = data;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
