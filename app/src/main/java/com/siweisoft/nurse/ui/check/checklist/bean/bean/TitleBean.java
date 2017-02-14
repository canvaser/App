package com.siweisoft.nurse.ui.check.checklist.bean.bean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class TitleBean extends BaseBean{

    private String title;

    private int num;

    public TitleBean(int num, String title) {
        this.num = num;
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
