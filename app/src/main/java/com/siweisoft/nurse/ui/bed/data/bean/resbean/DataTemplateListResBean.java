package com.siweisoft.nurse.ui.bed.data.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class DataTemplateListResBean extends BaseBean{

    private ArrayList<DataTemplateResBean> data;

    public ArrayList<DataTemplateResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataTemplateResBean> data) {
        this.data = data;
    }
}
