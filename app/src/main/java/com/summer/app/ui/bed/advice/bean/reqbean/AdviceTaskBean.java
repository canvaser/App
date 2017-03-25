package com.summer.app.ui.bed.advice.bean.reqbean;

import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2017-03-21.
 */

public class AdviceTaskBean extends BaseReqBean {

    private String begin;

    private String end;

    private String adviceid;

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid;
    }

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
}
