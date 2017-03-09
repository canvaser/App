package com.siweisoft.ui.bed.assay.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.util.data.DateFormatUtil;

import java.util.Date;

/**
 * Created by ${viwmox} on 2017-02-24.
 */

public class AssayDAOpe extends BaseDAOpe {

    String beginTime;

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
}
