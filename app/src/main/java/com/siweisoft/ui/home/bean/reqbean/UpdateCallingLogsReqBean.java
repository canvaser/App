package com.siweisoft.ui.home.bean.reqbean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class UpdateCallingLogsReqBean extends BaseReqBean {

    //呼叫记录的ID
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
