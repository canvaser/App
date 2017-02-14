package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class GetallregionbyuserNetBean extends BaseReqBean{

    private String uid;

    public GetallregionbyuserNetBean() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
