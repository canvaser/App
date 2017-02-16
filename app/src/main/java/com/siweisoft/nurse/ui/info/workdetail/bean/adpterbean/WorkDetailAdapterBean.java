package com.siweisoft.nurse.ui.info.workdetail.bean.adpterbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;
import com.siweisoft.nurse.ui.info.workdetail.bean.resbean.WorkDetailResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailAdapterBean extends ResultResBean {
    private String date;

    private String num;

    private String works;

    private ArrayList<WorkDetailResBean> list;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<WorkDetailResBean> getList() {
        return list;
    }

    public void setList(ArrayList<WorkDetailResBean> list) {
        this.list = list;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }
}
