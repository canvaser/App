package com.siweisoft.nurse.ui.bed.datachart.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-09.
 */
public class DataChartListResBean extends BaseBean{

    private ArrayList<DataChartResBean> data;

    public ArrayList<DataChartResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataChartResBean> data) {
        this.data = data;
    }
}
