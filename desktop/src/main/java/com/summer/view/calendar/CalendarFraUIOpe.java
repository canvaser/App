package com.summer.view.calendar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.ope.BaseUIOpe;
import com.summer.view.calendar.interf.OnDaySelectListener;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-09-12.
 */
public class CalendarFraUIOpe extends BaseUIOpe {


    @BindView(R.id.calendar)
    CalendarMonthView calendarMonthView;


    OnDaySelectListener onDaySelectListener;

    public CalendarFraUIOpe(Context context, View convertView) {
        super(context, convertView);
    }

    public CalendarMonthView getCalendarMonthView() {
        return calendarMonthView;
    }

    public void refresh(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        calendarMonthView.refreshDate(bundle.getInt("year"), bundle.getInt("month"));
    }

    public void setOnDaySelectListener(OnDaySelectListener onDaySelectListener) {
        this.onDaySelectListener = onDaySelectListener;
        calendarMonthView.setOnDaySelectListener(onDaySelectListener);
    }
}
