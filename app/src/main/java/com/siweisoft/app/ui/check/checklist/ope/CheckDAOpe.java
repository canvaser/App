package com.siweisoft.app.ui.check.checklist.ope;

import com.siweisoft.app.nursevalue.MethodValue;
import com.siweisoft.app.ui.check.checklist.bean.bean.TitleBean;
import com.siweisoft.app.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.app.ui.check.checklist.bean.resbean.CheckResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class CheckDAOpe {

    private int position = 0;

    ArrayList<TitleBean> titles = new ArrayList<>();

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<TitleBean> getTitles() {
        return titles;
    }

    public ArrayList<CheckResBean> initData(ArrayList<CheckResBean> res) {
        GetallregionbyuserResBean.Data data = MethodValue.getArea();
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).getData().size(); j++) {
                String bedid = res.get(i).getData().get(j).getBedId();
                res.get(i).getData().get(j).setBedId(data.getWardname() + bedid.substring(2, bedid.length()) + "床");
            }
        }
        return res;
    }
}
