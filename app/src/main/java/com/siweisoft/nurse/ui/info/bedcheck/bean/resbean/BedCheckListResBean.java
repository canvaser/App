package com.siweisoft.nurse.ui.info.bedcheck.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class BedCheckListResBean extends BaseBean{


    ArrayList<BedCheckResBean> data;

    public ArrayList<BedCheckResBean> getData() {
        return data;
    }

    public void setData(ArrayList<BedCheckResBean> data) {
        this.data = data;
    }
}
