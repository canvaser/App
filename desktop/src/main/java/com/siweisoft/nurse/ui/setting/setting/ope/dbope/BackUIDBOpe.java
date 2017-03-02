package com.siweisoft.nurse.ui.setting.setting.ope.dbope;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.nurse.ui.setting.setting.bean.dbbean.BackUIDBBean;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by summer on 2016/12/31 14:09.
 */

public class BackUIDBOpe extends BaseDBOpe {


    public BackUIDBOpe(Context context, Object o) {
        super(context, o);
    }

    public void addOrUpdate(String fragName, String backUrl) {
        BackUIDBBean backUIDBBean = new BackUIDBBean(fragName, backUrl);
        if (get(fragName) == null) {
            try {
                daoOpe.create(backUIDBBean);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String fragName, String backUrl) {
        BackUIDBBean backUIDBBean = new BackUIDBBean(fragName, backUrl);
        if (get(fragName) != null) {
            UpdateBuilder updateBuilder = daoOpe.updateBuilder();
            Where where = updateBuilder.where();
            try {
                where.eq(BackUIDBBean.FRAG_NAME, fragName);
                updateBuilder.updateColumnValue(BackUIDBBean.BACK_URL, backUrl);
                updateBuilder.update();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public BackUIDBBean get(String fragName) {
        BackUIDBBean backUIDBBean = null;
        QueryBuilder queryBuilder = daoOpe.queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.eq(BackUIDBBean.FRAG_NAME, fragName);
            backUIDBBean = (BackUIDBBean) where.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return backUIDBBean;
    }

    public ArrayList<BackUIDBBean> get() {
        ArrayList<BackUIDBBean> list = new ArrayList<>();
        try {
            ArrayList<BackUIDBBean> ll = (ArrayList<BackUIDBBean>) daoOpe.queryForAll();
            if (ll != null && ll.size() != 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
