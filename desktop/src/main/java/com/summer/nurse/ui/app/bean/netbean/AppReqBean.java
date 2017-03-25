package com.summer.nurse.ui.app.bean.netbean;

import com.summer.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppReqBean extends BaseReqBean {

    private String IdentityType;

    private String Identifier;

    private String Credential;

    private String UPhone;

    private String UUserType;

    private String UName;

    public String getCredential() {
        return Credential;
    }

    public void setCredential(String credential) {
        Credential = credential;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getIdentityType() {
        return IdentityType;
    }

    public void setIdentityType(String identityType) {
        IdentityType = identityType;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPhone() {
        return UPhone;
    }

    public void setUPhone(String UPhone) {
        this.UPhone = UPhone;
    }

    public String getUUserType() {
        return UUserType;
    }

    public void setUUserType(String UUserType) {
        this.UUserType = UUserType;
    }
}
