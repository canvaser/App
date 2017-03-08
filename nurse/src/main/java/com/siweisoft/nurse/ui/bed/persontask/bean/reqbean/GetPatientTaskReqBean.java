package com.siweisoft.nurse.ui.bed.persontask.bean.reqbean;


import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class GetPatientTaskReqBean extends BaseReqBean {

    private String begin;

    private String end;

    private String zyh;

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
