package com.siweisoft.nurse.ui.home.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-12-02.
 */
public class KeepAliveResBean extends ResultResBean {




    //1：无新数据；3：有新床位呼叫；5：有新紧急报告；7：有新床位呼叫和新紧急报告
    private int data;


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
