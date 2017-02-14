package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class AppResBean extends BaseBean{

    private String max_ver;

    private String min_ver;

    private String ver;

    private String appurl;

    public AppResBean() {
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }

    public String getMax_ver() {
        return max_ver;
    }

    public void setMax_ver(String max_ver) {
        this.max_ver = max_ver;
    }

    public String getMin_ver() {
        return min_ver;
    }

    public void setMin_ver(String min_ver) {
        this.min_ver = min_ver;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }
}
