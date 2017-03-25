package com.summer.app.ui.user.login.bean;


import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class GetallregionbyuserReqBean extends BaseReqBean {

    private String uid;

    public GetallregionbyuserReqBean() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
