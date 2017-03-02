package com.siweisoft.nurse.ui.calendar.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.siweisoft.base.ui.adapter.AppPagerAdapter;
import com.siweisoft.base.ui.fragment.BaseFrg;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-01-24.
 */

public class DayRecordPagerAdapter extends AppPagerAdapter {
    public DayRecordPagerAdapter(FragmentManager fm, Context context, ArrayList<BaseFrg> fragments) {
        super(fm, context, fragments);
    }
}
