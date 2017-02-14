package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class DoLoginReqBean extends BaseReqBean{

    /**用户名*/
    private String username;

    /**密码*/
    private String password;


    private String deviceid;

    public DoLoginReqBean() {
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
