package com.summer.app.ui.bed.data.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class TitleDataListResBean extends ResultResBean {

    private ArrayList<TitleDataResBean> data;

    public ArrayList<TitleDataResBean> getData() {
        return data;
    }

    public void setData(ArrayList<TitleDataResBean> data) {
        this.data = data;
    }
}
