package com.summer.app.ui.bed.persontask.bean.reqbean;


import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class GetPatientTaskOfTodayReqBean extends BaseReqBean {

    private String zyh;

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
