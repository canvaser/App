package com.siweisoft.app.ui.info.bedreport.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportListResBean extends ResultResBean {

    ArrayList<BedReportResBean> data;

    public ArrayList<BedReportResBean> getData() {
        return data;
    }

    public void setData(ArrayList<BedReportResBean> data) {
        this.data = data;
    }
}
