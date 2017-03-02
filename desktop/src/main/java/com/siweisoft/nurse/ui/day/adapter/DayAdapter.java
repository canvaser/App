package com.siweisoft.nurse.ui.day.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.siweisoft.base.ui.adapter.AppPagerAdapter;
import com.siweisoft.base.ui.fragment.BaseFrg;
import com.siweisoft.constant.ValueConstant;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class DayAdapter extends AppPagerAdapter {

    public DayAdapter(FragmentManager fm, Context context, ArrayList<BaseFrg> fragments) {
        super(fm, context, fragments);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getArguments().getString(ValueConstant.DATA_TITLE);
    }
}
