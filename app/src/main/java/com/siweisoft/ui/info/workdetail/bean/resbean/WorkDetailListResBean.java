package com.siweisoft.ui.info.workdetail.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailListResBean extends ResultResBean {

    private ArrayList<WorkDetailResBean> data;

    public ArrayList<WorkDetailResBean> getData() {
        return data;
    }

    public void setData(ArrayList<WorkDetailResBean> data) {
        this.data = data;
    }
}
