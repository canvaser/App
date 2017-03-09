package com.siweisoft.ui.check.checklist.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class CheckListResBean extends ResultResBean {

    ArrayList<CheckResBean> data;

    public ArrayList<CheckResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckResBean> data) {
        this.data = data;
    }
}
