package com.siweisoft.nurse.ui.mission.missionlist.bean.res;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMessionListResBean extends ResultResBean {

    private ArrayList<AreaMessionResBean> data;

    public AreaMessionListResBean(ArrayList<AreaMessionResBean> data) {
        this.data = data;
    }

    public AreaMessionListResBean() {
    }

    public ArrayList<AreaMessionResBean> getData() {
        return data;
    }

    public void setData(ArrayList<AreaMessionResBean> data) {
        this.data = data;
    }
}
