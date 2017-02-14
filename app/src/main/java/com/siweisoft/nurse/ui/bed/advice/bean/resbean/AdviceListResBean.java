package com.siweisoft.nurse.ui.bed.advice.bean.resbean;

import com.siweisoft.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AdviceListResBean extends BaseBean{
    ArrayList<AdviceResBean> data;

    public ArrayList<AdviceResBean> getData() {
        return data;
    }

    public void setData(ArrayList<AdviceResBean> data) {
        this.data = data;
    }
}
