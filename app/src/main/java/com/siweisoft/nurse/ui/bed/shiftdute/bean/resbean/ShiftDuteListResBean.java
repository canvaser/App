package com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class ShiftDuteListResBean extends BaseBean{

    private ArrayList<ShiftDuteResBean> data;

    public ArrayList<ShiftDuteResBean> getData() {
        return data;
    }

    public void setData(ArrayList<ShiftDuteResBean> data) {
        this.data = data;
    }
}
