package com.siweisoft.nurse.ui.calendar.ope.daope;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.siweisoft.base.ui.ope.BaseDAOpe;

import java.util.Calendar;

/**
 * Created by ${viwmox} on 2017-01-23.
 */
public class CalendarDAOpe extends BaseDAOpe {

    long nowtime = 0;

    Integer year;

    Integer month;

    Integer day;

    public CalendarDAOpe(Context context) {
        super(context);
        setYear(Calendar.getInstance().get(Calendar.YEAR));
        setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
        setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }

    public long getNowtime() {
        return nowtime;
    }

    public void setNowtime(long nowtime) {
        this.nowtime = nowtime;
    }

    public boolean doubleClick(long time) {
        if ((time - nowtime) <= 500) {
            return true;
        }
        nowtime = time;
        return false;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
