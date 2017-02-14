package com.siweisoft.nurse.ui.info.bedreport.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportListResBean extends BaseBean{

    ArrayList<BedReportResBean> data;

    public ArrayList<BedReportResBean> getData() {
        return data;
    }

    public void setData(ArrayList<BedReportResBean> data) {
        this.data = data;
    }
}
