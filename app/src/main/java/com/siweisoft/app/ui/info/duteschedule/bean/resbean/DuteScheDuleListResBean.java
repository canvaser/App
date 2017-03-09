package com.siweisoft.app.ui.info.duteschedule.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleListResBean extends ResultResBean {

    ArrayList<DuteScheDuleResBean> data;

    public ArrayList<DuteScheDuleResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DuteScheDuleResBean> data) {
        this.data = data;
    }
}
