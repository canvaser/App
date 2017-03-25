package com.summer.app.ui.check.checklist.bean.bean;


import com.summer.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class TitleBean extends ResultResBean {

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
