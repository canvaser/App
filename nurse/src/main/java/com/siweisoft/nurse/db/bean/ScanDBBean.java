package com.siweisoft.nurse.db.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.siweisoft.lib.base.ui.bean.dbbean.BaseDbBean;

/**
 * Created by ${viwmox} on 2017-03-06.
 */

@DatabaseTable(tableName = "nurse_scan.db")
public class ScanDBBean extends BaseDbBean {


    public static final String RESULT = "result";
    @DatabaseField(columnName = RESULT)
    private String result;

    public static final String TIME = "time";
    @DatabaseField(columnName = TIME)
    private String time;

    public static String getRESULT() {
        return RESULT;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static String getTIME() {
        return TIME;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
