package com.siweisoft.nurse.ui.info.urgencyreport.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UrgencyReportListResBean extends BaseBean{

    ArrayList<UrgencyReportResBean> data;

    public ArrayList<UrgencyReportResBean> getData() {
        return data;
    }

    public void setData(ArrayList<UrgencyReportResBean> data) {
        this.data = data;
    }
}
