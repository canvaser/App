package com.siweisoft.nurse.ui.info.duteschedule.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleListResBean extends BaseBean{

    ArrayList<DuteScheDuleResBean> data;

    public ArrayList<DuteScheDuleResBean> getData() {
        return data;
    }

    public void setData(ArrayList<DuteScheDuleResBean> data) {
        this.data = data;
    }
}
