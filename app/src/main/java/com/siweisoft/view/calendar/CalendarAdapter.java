package com.siweisoft.view.calendar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.siweisoft.base.ui.adapter.AppBasePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-09-12.
 */
public class CalendarAdapter extends AppBasePagerAdapter{

    private Bundle bundle;


    ArrayList<CalendarUIFragment> calendarFragments = new ArrayList<>();

    public CalendarAdapter(FragmentManager fm, Context context,Bundle bundle) {
        super(fm, context);
        this.bundle = bundle;

        for(int i=0;i<getCount();i++){
            CalendarUIFragment calendarFragment = new CalendarUIFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putInt("year",bundle.getInt("year"));
            bundle1.putInt("month",i+1);
            calendarFragment.setArguments(bundle1);
            calendarFragments.add(calendarFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return calendarFragments.get(position);
    }

    @Override
    public int getCount() {
        return 12;
    }

    public ArrayList<CalendarUIFragment> getCalendarFragments() {
        return calendarFragments;
    }
}
