package com.summer.nurse.ui.index.bean.resbean;

import com.summer.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditionResbean extends BaseBean {

    private String type;

    private String code;

    private String name;

    private String canSet;

    private boolean select;

    public String getCanSet() {
        return canSet;
    }

    public void setCanSet(String canSet) {
        this.canSet = canSet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
