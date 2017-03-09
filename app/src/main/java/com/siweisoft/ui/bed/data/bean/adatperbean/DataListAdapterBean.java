package com.siweisoft.ui.bed.data.bean.adatperbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-24.
 */
public class DataListAdapterBean extends ResultResBean {

    ArrayList<DataAdapterBean> data;

    public ArrayList<DataAdapterBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataAdapterBean> data) {
        this.data = data;
    }
}
