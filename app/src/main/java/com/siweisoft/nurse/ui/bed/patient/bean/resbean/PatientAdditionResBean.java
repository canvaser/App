package com.siweisoft.nurse.ui.bed.patient.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.network.bean.res.BaseResBean;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class PatientAdditionResBean extends BaseBean{

    private String syxh;

    private String user_id;

    private String type;

    private String value;

    private String create_time;

    private boolean select;

    public PatientAdditionResBean(String type, String value, boolean select) {
        this.type = type;
        this.value = value;
        this.select = select;
    }

    public PatientAdditionResBean() {
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSyxh() {
        return syxh;
    }

    public void setSyxh(String syxh) {
        this.syxh = syxh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
