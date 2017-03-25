package com.summer.app.ui.check.patientcheck.bean;

import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-03-08.
 */

public class PatAndTaskInfoByDocAdvIdReqBean extends BaseReqBean {

    private String adviceid;

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid;
    }
}
