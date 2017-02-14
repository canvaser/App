package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.network.bean.res.BaseResBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class VoipResBean extends BaseResBean{

    private String server;

    private String number;

    private String pwd;

    public VoipResBean() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
