package com.siweisoft.ui.bed.datachart.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-09.
 */
public class DataChartListResBean extends ResultResBean {

    private ArrayList<DataChartResBean> data;

    public ArrayList<DataChartResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataChartResBean> data) {
        this.data = data;
    }
}
