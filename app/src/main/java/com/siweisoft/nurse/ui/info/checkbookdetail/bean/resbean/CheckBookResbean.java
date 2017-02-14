package com.siweisoft.nurse.ui.info.checkbookdetail.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookResbean extends BaseBean{

    ArrayList<CheckBookDetailItemsListResBean> data;

    public ArrayList<CheckBookDetailItemsListResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckBookDetailItemsListResBean> data) {
        this.data = data;
    }
}
