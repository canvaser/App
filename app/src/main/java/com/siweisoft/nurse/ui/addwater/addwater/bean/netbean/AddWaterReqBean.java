package com.siweisoft.nurse.ui.addwater.addwater.bean.netbean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterReqBean extends BaseReqBean{

    private String zyh;

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
}
