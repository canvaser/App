package com.summer.app.ui.home.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditionListResBean extends ResultResBean {

    ArrayList<AdditionResbean> data;

    public ArrayList<AdditionResbean> getData() {
        return data;
    }

    public void setData(ArrayList<AdditionResbean> data) {
        this.data = data;
    }
}
