package com.summer.app.ui.bed.datachart.bean.reqbean;


import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class DataChartReqBean extends BaseReqBean {

    private String groupid;

    private String signid;

    private String zyh;

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

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getSignid() {
        return signid;
    }

    public void setSignid(String signid) {
        this.signid = signid;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
