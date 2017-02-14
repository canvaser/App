package com.siweisoft.nurse.ui.bed.data.bean.adatperbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-24.
 */
public class DataListAdapterBean extends BaseBean{

    ArrayList<DataAdapterBean> data;

    public ArrayList<DataAdapterBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataAdapterBean> data) {
        this.data = data;
    }
}
