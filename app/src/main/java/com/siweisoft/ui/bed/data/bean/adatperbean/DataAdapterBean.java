package com.siweisoft.ui.bed.data.bean.adatperbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;
import com.siweisoft.ui.bed.data.bean.resbean.BodyDataResBean;
import com.siweisoft.ui.bed.data.bean.resbean.TitleDataResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-24.
 */
public class DataAdapterBean extends ResultResBean {

    private ArrayList<TitleDataResBean> titleData;


    private ArrayList<String> title;

    private ArrayList<ArrayList<BodyDataResBean>> data;

    private int size;

    private String head;

    public ArrayList<ArrayList<BodyDataResBean>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<BodyDataResBean>> data) {
        this.data = data;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    public void setTitle(ArrayList<String> title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public ArrayList<TitleDataResBean> getTitleData() {
        return titleData;
    }

    public void setTitleData(ArrayList<TitleDataResBean> titleData) {
        this.titleData = titleData;
    }
}
