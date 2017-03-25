package com.summer.app.ui.mission.missionlist.bean.req;

import com.summer.lib.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMissionReqBean extends BaseNurseReqBean {


    /**
     * 开始时间；可忽略，忽略时默认为当前时间减7天
     */
    private String begin;

    /**
     * 结束时间；可忽略，忽略时默认为当前时间加8小时
     */
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
}
