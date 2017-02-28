package com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean;

import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMissionListAdapterBean extends AreaMessionListResBean {

    private int year;

    private int month;

    private int day;

    private int hour;


    public AreaMissionListAdapterBean(int year, int month, int day, int hour, ArrayList<DataBean> data) {
        setData(data);
        this.day = day;
        this.hour = hour;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getYYYYMMDD() {
        String y = year + "";
        String m = (month + 1) + "";
        String d = day + "";

        if (month < 10) {
            m = "0" + month;
        }
        if (day < 10) {
            d = "0" + day;
        }
        return y + "-" + m + "-" + d;
    }

    public long getYYYYMMDD_INT() {

        return year * 1000000 +
                month * 10000 +
                day * 100 +
                hour;
    }


}
