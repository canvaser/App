package com.summer.app.ui.user.login.bean;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2017-03-16.
 */

public class UserInfo implements Serializable {

    private String account;

    private String pwd;

    private String regionname;

    private String regioncode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }
}
