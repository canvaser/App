package com.siweisoft.app.ui.setting.updatepwd.bean.reqbean;


import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class UpdatePwdReqBean extends BaseReqBean {

    private String new_password;


    private String old_password;

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }
}
