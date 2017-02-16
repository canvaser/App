package com.siweisoft.nurse.ui.bed.assay.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayListResBean extends ResultResBean {

    private ArrayList<AssayResBean> data;

    public ArrayList<AssayResBean> getData() {
        return data;
    }

    public void setData(ArrayList<AssayResBean> data) {
        this.data = data;
    }
}
