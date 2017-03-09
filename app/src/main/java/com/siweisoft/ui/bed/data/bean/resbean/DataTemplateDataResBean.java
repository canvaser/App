package com.siweisoft.ui.bed.data.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class DataTemplateDataResBean extends ResultResBean {

    private String nid;

    private String groupid;

    private String groupname;

    private String signid;

    private String parentsignid;

    private String type;

    private String signname;

    private String initstring;

    private String upper;

    private String lower;

    private String value;

    private String valuetype;

    private String textalign;

    private String prefix;

    private String suffix;

    private String coeff;

    private String FS26;

    private String FS27;

    ArrayList<ArrayList<String>> items;

    public String getCoeff() {
        return coeff;
    }

    public void setCoeff(String coeff) {
        this.coeff = coeff;
    }

    public String getFS26() {
        return FS26;
    }

    public void setFS26(String FS26) {
        this.FS26 = FS26;
    }

    public String getFS27() {
        return FS27;
    }

    public void setFS27(String FS27) {
        this.FS27 = FS27;
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

    public String getInitstring() {
        return initstring;
    }

    public void setInitstring(String initstring) {
        this.initstring = initstring;
    }


    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getParentsignid() {
        return parentsignid;
    }

    public void setParentsignid(String parentsignid) {
        this.parentsignid = parentsignid;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

    public String getTextalign() {
        return textalign;
    }

    public void setTextalign(String textalign) {
        this.textalign = textalign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    public ArrayList<ArrayList<String>> getItems() {
        return items;
    }

    public void setItems(ArrayList<ArrayList<String>> items) {
        this.items = items;
    }
}
