package com.siweisoft.app.ui.bed.advice.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AdviceListResBean extends ResultResBean {
    ArrayList<AdviceResBean> data;

    public ArrayList<AdviceResBean> getData() {
        return data;
    }

    public void setData(ArrayList<AdviceResBean> data) {
        this.data = data;
    }
}
