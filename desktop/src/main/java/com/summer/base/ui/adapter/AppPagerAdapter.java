package com.summer.base.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.summer.base.ui.fragment.BaseFrg;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-10-18.
 */
public class AppPagerAdapter extends AppBasePagerAdapter {

    protected ArrayList<BaseFrg> fragments;

    public AppPagerAdapter(FragmentManager fm, Context context, ArrayList<BaseFrg> fragments) {
        super(fm, context);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
