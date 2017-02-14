package com.siweisoft.nurse.ui.mission.missionlist.bean.res;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.util.data.DateFormatUtil;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMessionResBean extends BaseBean{

    private String zyh;

    private String start;

    private String end;

    private String regionId;

    private String roomId;

    private String bedId;

    private String name;

    private String codename;

    ArrayList<AreaMessionTitleResBean> titles;

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public ArrayList<AreaMessionTitleResBean> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<AreaMessionTitleResBean> titles) {
        this.titles = titles;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
