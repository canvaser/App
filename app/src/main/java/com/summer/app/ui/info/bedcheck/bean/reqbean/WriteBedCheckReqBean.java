package com.summer.app.ui.info.bedcheck.bean.reqbean;


import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-13.
 */
public class WriteBedCheckReqBean extends BaseReqBean {

    private String zyh;

    private String region;

    private String room;

    private String bed;

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
