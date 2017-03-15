package com.siweisoft.app.ui.check.checkblood.bean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-03-15.
 */

public class CheckPatAndPipeReqBean extends BaseReqBean {

    private String code;

    private String zyh;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
