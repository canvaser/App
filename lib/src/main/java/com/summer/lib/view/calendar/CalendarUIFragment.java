package com.summer.lib.view.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.lib.R;
import com.summer.lib.base.ui.fragment.BaseUIFragment;
import com.summer.lib.view.calendar.interf.OnDaySelectListener;

/**
 * Created by ${viwmox} on 2016-09-12.
 */
public class CalendarUIFragment extends BaseUIFragment {

    private CalendarFraUIOpe calendarFraUIOpe;

    OnDaySelectListener onDaySelectListener;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calendarFraUIOpe = new CalendarFraUIOpe(getActivity(), getView());
        calendarFraUIOpe.refresh(getArguments());
        calendarFraUIOpe.setOnDaySelectListener(onDaySelectListener);
    }

    @Override
    public int getContainView() {
        return R.layout.fragment_month;
    }


    public CalendarFraUIOpe getCalendarFraUIOpe() {
        return calendarFraUIOpe;
    }

    public void setOnDaySelectListener(OnDaySelectListener onDaySelectListener) {
        this.onDaySelectListener = onDaySelectListener;
    }
}
