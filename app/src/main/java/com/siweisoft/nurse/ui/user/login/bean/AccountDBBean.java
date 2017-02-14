package com.siweisoft.nurse.ui.user.login.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.siweisoft.base.ui.bean.dbbean.BaseDbBean;

/**
 * Created by ${viwmox} on 2016-10-24.
 */

@DatabaseTable(tableName = "table_account")
public class AccountDBBean extends BaseDbBean{


    public static final int TYPE_NURSE= 0;

    public static final int TYPE_PATIENT= 1;

    public static final int TYPE_DOCTOR= 2;


    public static final String ACCOUNT= "account";
    @DatabaseField(columnName = ACCOUNT)
    private String account;


    public static final String TYPE= "type";
    @DatabaseField(columnName = TYPE)
    private int type;

    public AccountDBBean(String account, int type) {
        this.account = account;
        this.type = type;
    }

    public AccountDBBean() {
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
