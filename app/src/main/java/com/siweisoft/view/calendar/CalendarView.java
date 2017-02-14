package com.siweisoft.view.calendar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.siweisoft.base.ui.activity.BaseUIActivity;
import com.siweisoft.base.ui.fragment.BaseUIFragment;
import com.siweisoft.view.calendar.interf.OnDaySelectListener;

/**
 * Created by ${viwmox} on 2016-09-12.
 */
public class CalendarView extends ViewPager{

    private CalendarAdapter calendarAdapter;

    private Context context;

    BaseUIFragment baseUIFragment;

    OnDaySelectListener onDaySelectListener;

    boolean refresh = false;

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if(!refresh){
            refresh = refreh(2016,9, baseUIFragment);
        }
    }

    public boolean refreh(int year , int month,BaseUIFragment baseUIFragment){
        BaseUIActivity baseUIActivity = (BaseUIActivity) context;
        Bundle bundle = new Bundle();
        bundle.putInt("year",year);
        bundle.putInt("month",month);
        calendarAdapter= new CalendarAdapter(baseUIFragment.getChildFragmentManager(),context,bundle);
        setAdapter(calendarAdapter);
        setOffscreenPageLimit(3);
        setCurrentItem(month-1);
        if(onDaySelectListener!=null){
            for(int i=0;i<calendarAdapter.getCalendarFragments().size();i++){
                calendarAdapter.getCalendarFragments().get(i).setOnDaySelectListener(onDaySelectListener);
            }
        }
    return true;
    }


    public void refreh(int year , int month){
        BaseUIActivity baseUIActivity = (BaseUIActivity) context;
        Bundle bundle = new Bundle();
        bundle.putInt("year",year);
        bundle.putInt("month",month);
        calendarAdapter= new CalendarAdapter(baseUIActivity.getSupportFragmentManager(),context,bundle);
        setAdapter(calendarAdapter);
        setOffscreenPageLimit(3);
        setCurrentItem(month-1);

    }

    public void setBaseUIFragment(BaseUIFragment baseUIFragment) {
        this.baseUIFragment = baseUIFragment;
    }

    public void setOnDaySelectListener(OnDaySelectListener onDaySelectListener) {
        this.onDaySelectListener = onDaySelectListener;
    }
}
