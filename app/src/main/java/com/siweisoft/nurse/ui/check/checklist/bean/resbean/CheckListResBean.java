package com.siweisoft.nurse.ui.check.checklist.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class CheckListResBean extends BaseBean{

    ArrayList<CheckResBean> data;

    public ArrayList<CheckResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckResBean> data) {
        this.data = data;
    }
}
