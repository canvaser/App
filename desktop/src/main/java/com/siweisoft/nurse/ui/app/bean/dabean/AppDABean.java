package com.siweisoft.nurse.ui.app.bean.dabean;

import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.base.bean.databean.BaseDABean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

public class AppDABean extends BaseDABean {


    HashMap<String, ArrayList<AppDBBean>> data = new HashMap<>();

    public HashMap<String, ArrayList<AppDBBean>> getData() {
        return data;
    }

    public void setData(HashMap<String, ArrayList<AppDBBean>> data) {
        this.data = data;
    }
}
