package com.siweisoft.app.db.base;

/**
 * Created by summer on 2016/2/16 0016 20:26.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.siweisoft.app.db.bean.ScanDBBean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NurseDBHelper extends OrmLiteSqliteOpenHelper {
    protected static String TABLE_NAME = "sw_nurse_station.db";
    private static NurseDBHelper instance;
    private Map<String, Dao> daos = new HashMap<String, Dao>();


    private NurseDBHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static synchronized NurseDBHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (NurseDBHelper.class) {
                if (instance == null)
                    instance = new NurseDBHelper(context);
            }
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ScanDBBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
//        try{
//            LogUtil.E("onUpgrade");
//          //  TableUtils.dropTable(connectionSource,PlanTipBean.class,true);
//            TableUtils.createTable(connectionSource, PlanTipBean.class);
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();

        if (daos.containsKey(className)) {
            dao = daos.get(className);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }

}