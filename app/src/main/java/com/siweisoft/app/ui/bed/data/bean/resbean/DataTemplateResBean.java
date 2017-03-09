package com.siweisoft.app.ui.bed.data.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class DataTemplateResBean extends ResultResBean {

    private ArrayList<DataTemplateDataResBean> data;

    private String groupid;

    private String groupname;

    public ArrayList<DataTemplateDataResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataTemplateDataResBean> data) {
        this.data = data;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
