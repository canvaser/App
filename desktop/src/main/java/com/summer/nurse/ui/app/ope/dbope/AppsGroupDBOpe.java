package com.summer.nurse.ui.app.ope.dbope;

import android.content.Context;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.nurse.ui.app.bean.dbbean.AppGroupDBBean;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

public class AppsGroupDBOpe extends BaseDBOpe<AppGroupDBBean> {


    public AppsGroupDBOpe(Context context, AppGroupDBBean appGroupDBBean) {
        super(context, appGroupDBBean);
    }

    public void add(String name) {
        AppGroupDBBean appGroupDBBean = new AppGroupDBBean();
        appGroupDBBean.setName(name);
        try {
            daoOpe.create(appGroupDBBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<AppGroupDBBean> get() {
        ArrayList<AppGroupDBBean> list = new ArrayList<>();
        try {
            ArrayList<AppGroupDBBean> ll = (ArrayList<AppGroupDBBean>) daoOpe.queryForAll();
            if (ll != null && ll.size() > 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void delete(String name) {
        DeleteBuilder deleteBuilder = daoOpe.deleteBuilder();
        Where where = deleteBuilder.where();
        try {
            where.eq(AppGroupDBBean.NAME, name);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
