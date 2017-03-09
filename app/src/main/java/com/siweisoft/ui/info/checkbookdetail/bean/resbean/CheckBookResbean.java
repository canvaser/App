package com.siweisoft.ui.info.checkbookdetail.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookResbean extends ResultResBean {

    ArrayList<CheckBookDetailItemsListResBean> data;

    public ArrayList<CheckBookDetailItemsListResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckBookDetailItemsListResBean> data) {
        this.data = data;
    }
}
