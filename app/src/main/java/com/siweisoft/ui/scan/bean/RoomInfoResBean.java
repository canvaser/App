package com.siweisoft.ui.scan.bean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class RoomInfoResBean extends ResultResBean {

    /**
     * qrtype : room
     * region : 病区代码
     * room : 房间代码
     */

    private String qrtype;
    private String region;
    private String room;

    public String getQrtype() {
        return qrtype;
    }

    public void setQrtype(String qrtype) {
        this.qrtype = qrtype;
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
}
