package com.summer.app.ui.addwater.addwater.bean.netbean;

import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterReqBean extends BaseReqBean {

    private String zyh;

    private String ward;

    private String fileid;

    private String begin;

    private String end;

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

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
