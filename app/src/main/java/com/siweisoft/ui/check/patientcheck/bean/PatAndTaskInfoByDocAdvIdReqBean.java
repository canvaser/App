package com.siweisoft.ui.check.patientcheck.bean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;

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
