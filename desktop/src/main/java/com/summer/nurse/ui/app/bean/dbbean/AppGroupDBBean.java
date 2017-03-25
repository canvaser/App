package com.summer.nurse.ui.app.bean.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.summer.base.ui.bean.dbbean.BaseDbBean;

/**
 * Created by ${viwmox} on 2016-12-26.
 */
@DatabaseTable(tableName = "table_appgroups")
public class AppGroupDBBean extends BaseDbBean {


    public static String APP_SYSTEM = "APP_SYSTEM";

    public static String APP_USER = "APP_USER";

    public static final String NAME = "name";
    @DatabaseField(columnName = NAME)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
