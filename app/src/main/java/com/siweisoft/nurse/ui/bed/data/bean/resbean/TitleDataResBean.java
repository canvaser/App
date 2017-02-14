package com.siweisoft.nurse.ui.bed.data.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class TitleDataResBean extends BaseBean{

    private String groupid;

    private String groupname;

    private String signid;

    private String signname;

    private String type;

    private String valuetype;

    private String suffix;

    ArrayList<BodyDataResBean> json_data;

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

    public ArrayList<BodyDataResBean> getJson_data() {
        return json_data;
    }

    public void setJson_data(ArrayList<BodyDataResBean> json_data) {
        this.json_data = json_data;
    }

    public String getSignid() {
        return signid;
    }

    public void setSignid(String signid) {
        this.signid = signid;
    }

    public String getSignname() {
        return signname;
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }
}
