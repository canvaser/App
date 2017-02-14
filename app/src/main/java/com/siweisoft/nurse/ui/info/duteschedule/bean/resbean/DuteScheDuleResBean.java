package com.siweisoft.nurse.ui.info.duteschedule.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleResBean extends BaseBean{


    private String Name;

    private String dayofweek;

    private String shiftname;

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }
}
