package com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class ShiftDuteListResBean extends ResultResBean {

    private ArrayList<ShiftDuteResBean> data;

    public ArrayList<ShiftDuteResBean> getData() {
        return data;
    }

    public void setData(ArrayList<ShiftDuteResBean> data) {
        this.data = data;
    }
}
