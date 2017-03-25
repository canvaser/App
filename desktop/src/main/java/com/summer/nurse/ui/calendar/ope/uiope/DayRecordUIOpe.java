package com.summer.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.fragment.BaseFrg;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;
import com.summer.nurse.ui.calendar.adapter.DayRecordPagerAdapter;
import com.summer.nurse.ui.calendar.fragment.AddDayRecordFrag;
import com.summer.nurse.ui.calendar.fragment.CalendarFrag;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class DayRecordUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.vp_vp)
    ViewPager viewPager;

    public DayRecordUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {

    }

    public void initPager(Fragment f, int index) {
        ArrayList<BaseFrg> frags = new ArrayList<>();
        BaseFrg addDayRecordFrag = new AddDayRecordFrag();
        Bundle bundle = new Bundle();
        bundle.putInt(ValueConstant.FRAG_POSITION, index);
        addDayRecordFrag.setArguments(bundle);
        Bundle bundle1 = new Bundle();
        bundle1.putInt(ValueConstant.FRAG_POSITION, index);
        BaseFrg calendarFrag = new CalendarFrag();
        calendarFrag.setArguments(bundle1);
        frags.add(addDayRecordFrag);
        frags.add(calendarFrag);
        viewPager.setAdapter(new DayRecordPagerAdapter(f.getChildFragmentManager(), context, frags));
    }


    public ViewPager getViewPager() {
        return viewPager;
    }

}
