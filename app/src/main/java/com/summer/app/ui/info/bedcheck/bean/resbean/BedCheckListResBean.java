package com.summer.app.ui.info.bedcheck.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class BedCheckListResBean extends ResultResBean {


    ArrayList<BedCheckResBean> data;

    public ArrayList<BedCheckResBean> getData() {
        return data;
    }

    public void setData(ArrayList<BedCheckResBean> data) {
        this.data = data;
    }
}
