package com.siweisoft.nurse.ui.app.ope.daope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppGroupDBBean;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsGroupDBOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppDAOpe extends BaseDAOpe {

    ArrayList<AppDBBean> data;

    AppDBBean item;

    public AppDAOpe(Context context) {
        super(context);
    }

    public ArrayList<AppDBBean> getData() {
        return data;
    }

    public void setData(ArrayList<AppDBBean> data) {
        this.data = data;
    }

    public ArrayList<String> getList(Context context) {
        ArrayList<AppGroupDBBean> list = new AppsGroupDBOpe(context, new AppGroupDBBean()).get();
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            str.add("添加到" + list.get(i).getName());
        }
        str.add("换图");
        str.add("卸载");
        str.add("删除");
        str.add("添加组");
        str.add("刷新");
        return str;
    }

    public AppDBBean getItem() {
        return item;
    }

    public void setItem(AppDBBean item) {
        this.item = item;
    }
}
