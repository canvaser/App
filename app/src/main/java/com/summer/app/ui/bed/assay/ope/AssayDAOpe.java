package com.summer.app.ui.bed.assay.ope;

import android.content.Context;

import com.summer.lib.base.ui.ope.BaseDAOpe;

/**
 * Created by ${viwmox} on 2017-02-24.
 */

public class AssayDAOpe extends BaseDAOpe {

    String beginTime;

    public static final int HIGH = 0;
    public static final int LOW = 1;
    public static final int NORMAL = 2;

    public AssayDAOpe(Context context) {
        super(context);
        // beginTime = DateFormatUtil.convent_YYYYMMDD(new Date());
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public int isHigH(String flag) {
        if (flag.toLowerCase().equals("h")) {
            return HIGH;
        } else if (flag.toLowerCase().equals("l")) {
            return LOW;
        } else {
            return NORMAL;
        }
    }
}
