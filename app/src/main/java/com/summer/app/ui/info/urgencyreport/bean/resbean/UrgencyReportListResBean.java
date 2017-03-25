package com.summer.app.ui.info.urgencyreport.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UrgencyReportListResBean extends ResultResBean {

    ArrayList<UrgencyReportResBean> data;

    public ArrayList<UrgencyReportResBean> getData() {
        return data;
    }

    public void setData(ArrayList<UrgencyReportResBean> data) {
        this.data = data;
    }
}
