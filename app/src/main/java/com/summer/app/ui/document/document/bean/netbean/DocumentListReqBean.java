package com.summer.app.ui.document.document.bean.netbean;

import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class DocumentListReqBean extends BaseReqBean {

    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
