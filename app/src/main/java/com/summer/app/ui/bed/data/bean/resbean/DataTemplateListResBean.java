package com.summer.app.ui.bed.data.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class DataTemplateListResBean extends ResultResBean {

    private ArrayList<DataTemplateResBean> data;

    public ArrayList<DataTemplateResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataTemplateResBean> data) {
        this.data = data;
    }
}
