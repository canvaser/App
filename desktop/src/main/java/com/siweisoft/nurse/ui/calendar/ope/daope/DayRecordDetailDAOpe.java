package com.siweisoft.nurse.ui.calendar.ope.daope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.calendar.bean.netbean.DayBean;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class DayRecordDetailDAOpe extends BaseDAOpe {


    DayBean dayBean;

    public DayRecordDetailDAOpe(Context context) {
        super(context);
    }


    public DayBean getDayBean() {
        return dayBean;
    }

    public void setDayBean(DayBean dayBean) {
        this.dayBean = dayBean;
    }
}
