package com.summer.nurse.ui.day.ope.dbope;

import android.content.Context;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.nurse.ui.day.bean.dbbean.DayDBBean;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-01-06.
 */

public class DayAddDBOpe extends BaseDBOpe<DayDBBean> {


    public DayAddDBOpe(Context context, DayDBBean dayDBBean) {
        super(context, dayDBBean);
    }

    public void add(long start, long end, String content) {
        DayDBBean dayDBBean = new DayDBBean(start, end, content);
        try {
            daoOpe.create(dayDBBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(long start, long end, String content, String musicUrl, boolean playMusic) {
        DayDBBean dayDBBean = new DayDBBean(start, end, content, musicUrl, playMusic);
        try {
            daoOpe.create(dayDBBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        DeleteBuilder deleteBuilder = daoOpe.deleteBuilder();
        Where where = deleteBuilder.where();
        try {
            where.eq(DayDBBean.ID, id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(long id, long start, long end, String content) {
        UpdateBuilder updateBuilder = daoOpe.updateBuilder();
        Where where = updateBuilder.where();
        try {
            where.eq(DayDBBean.ID, id);
            updateBuilder.updateColumnValue(DayDBBean.START_TIME, start);
            updateBuilder.updateColumnValue(DayDBBean.END_TIME, end);
            updateBuilder.updateColumnValue(DayDBBean.CENTENT_TXT, content);
            updateBuilder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DayDBBean> get() {
        ArrayList<DayDBBean> list = new ArrayList<>();
        try {
            ArrayList<DayDBBean> ll = (ArrayList<DayDBBean>) daoOpe.queryForAll();
            if (ll != null && ll.size() != 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<DayDBBean> getBefore(long time) {
        ArrayList<DayDBBean> list = new ArrayList<>();
        ArrayList<DayDBBean> ll;
        QueryBuilder queryBuilder = daoOpe.queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.lt(DayDBBean.END_TIME, time);
            queryBuilder.orderBy(DayDBBean.START_TIME, true);
            ll = (ArrayList<DayDBBean>) queryBuilder.query();
            if (ll != null && ll.size() > 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<DayDBBean> getNow(long time) {
        ArrayList<DayDBBean> list = new ArrayList<>();
        ArrayList<DayDBBean> ll;
        QueryBuilder queryBuilder = daoOpe.queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.and(where.lt(DayDBBean.START_TIME, time), where.gt(DayDBBean.END_TIME, time));
            queryBuilder.orderBy(DayDBBean.START_TIME, true);
            ll = (ArrayList<DayDBBean>) queryBuilder.query();
            if (ll != null && ll.size() > 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<DayDBBean> getRightNow(long time) {
        ArrayList<DayDBBean> list = new ArrayList<>();
        ArrayList<DayDBBean> ll;
        QueryBuilder queryBuilder = daoOpe.queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.or(where.eq(DayDBBean.START_TIME, time), where.eq(DayDBBean.END_TIME, time));
            queryBuilder.orderBy(DayDBBean.START_TIME, true);
            ll = (ArrayList<DayDBBean>) queryBuilder.query();
            if (ll != null && ll.size() > 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<DayDBBean> getAfter(long time) {
        ArrayList<DayDBBean> list = new ArrayList<>();
        ArrayList<DayDBBean> ll;
        QueryBuilder queryBuilder = daoOpe.queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.gt(DayDBBean.START_TIME, time);
            queryBuilder.orderBy(DayDBBean.START_TIME, true);
            ll = (ArrayList<DayDBBean>) queryBuilder.query();
            if (ll != null && ll.size() > 0) {
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
