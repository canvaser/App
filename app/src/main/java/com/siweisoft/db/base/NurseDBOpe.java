package com.siweisoft.db.base;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.siweisoft.lib.base.ui.bean.dbbean.BaseDbBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-05-19.
 */
public class NurseDBOpe<T> {

    protected Context context;
    protected Dao<T, Integer> daoOpe;
    protected NurseDBHelper helper;
    private NurseDBOpe instance;

    public NurseDBOpe(Context context, T t) {
        this.context = context;
        try {
            helper = NurseDBHelper.getHelper(context);
            daoOpe = helper.getDao(t.getClass());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(T t) {
        try {
            daoOpe.create(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<T> getList() {
        try {
            return daoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

    public void clear() {
        DeleteBuilder deleteBuilder = daoOpe.deleteBuilder();
        try {
            deleteBuilder.where().isNotNull(BaseDbBean.ID);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
