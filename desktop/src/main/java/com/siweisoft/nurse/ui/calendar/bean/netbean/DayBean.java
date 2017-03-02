package com.siweisoft.nurse.ui.calendar.bean.netbean;

import com.siweisoft.base.ui.bean.BaseBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by ${viwmox} on 2017-01-23.
 */

public class DayBean extends BmobObject {

    private Integer ID;

    private String content;

    private BmobFile image;

    private Integer year;

    private Integer month;

    private Integer day;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }


    public BmobFile getImage() {
        return image;
    }

    public void setImage(BmobFile image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "DayBean{" +
                "content='" + content + '\'' +
                ", ID=" + ID +
                ", image=" + image +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
