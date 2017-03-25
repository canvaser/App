package com.summer.nurse.ui.setting.setting.bean.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.summer.base.ui.bean.dbbean.BaseDbBean;

/**
 * Created by summer on 2016/12/31 14:06.
 */
@DatabaseTable(tableName = "table_backui")
public class BackUIDBBean extends BaseDbBean {

    public static final String FRAG_NAME = "fragName";
    @DatabaseField(columnName = FRAG_NAME)
    private String fragName;

    public static final String BACK_URL = "backUrl";
    @DatabaseField(columnName = BACK_URL)
    private String backUrl;

    public BackUIDBBean() {
    }

    public BackUIDBBean(String fragName, String backUrl) {
        this.fragName = fragName;
        this.backUrl = backUrl;
    }

    public String getFragName() {
        return fragName;
    }

    public void setFragName(String fragName) {
        this.fragName = fragName;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }
}
