package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class UserResBean extends BaseBean{

    private String id;

    private String email;

    private String displayname;

    private String status;

    private String status_name;

    private String avatar;

    private String avatar_data;

    private String gender;

    private String create_at;

    ArrayList<String> regions;

    private String deviceid;

    public UserResBean() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_data() {
        return avatar_data;
    }

    public void setAvatar_data(String avatar_data) {
        this.avatar_data = avatar_data;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<String> regions) {
        this.regions = regions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
