package com.siweisoft.nurse.ui.bed.additionlist.bean.reqbean;


import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class UpdateAdditionReqBean extends BaseReqBean {

    private String type;

    private String zyh;

    private String value;

    public UpdateAdditionReqBean(String zyh, String type, String value) {
        this.zyh = zyh;
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
