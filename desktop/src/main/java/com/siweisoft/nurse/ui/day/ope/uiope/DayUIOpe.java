package com.siweisoft.nurse.ui.day.ope.uiope;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.activity.BaseActivity;
import com.siweisoft.base.ui.fragment.BaseFrg;
import com.siweisoft.base.ui.interf.view.OnAppItemSelectListener;
import com.siweisoft.base.ui.listener.BaseOnPagerChangeListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.day.adapter.DayAdapter;
import com.siweisoft.nurse.ui.day.fragment.LeftDayFrag;
import com.siweisoft.nurse.ui.day.fragment.MidDayFrag;
import com.siweisoft.nurse.ui.day.fragment.RightDayFrag;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class DayUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    public DayUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void init(Fragment fragment) {
        ArrayList<BaseFrg> fragments = new ArrayList<>();
        BaseFrg left = new LeftDayFrag();
        Bundle leftb = new Bundle();
        leftb.putString(ValueConstant.DATA_TITLE, "已完成");
        left.setArguments(leftb);
        BaseFrg mid = new MidDayFrag();
        Bundle midb = new Bundle();
        midb.putString(ValueConstant.DATA_TITLE, "进行中");
        mid.setArguments(midb);
        BaseFrg right = new RightDayFrag();
        Bundle rightb = new Bundle();
        rightb.putString(ValueConstant.DATA_TITLE, "未完成");
        right.setArguments(rightb);
        fragments.add(left);
        fragments.add(mid);
        fragments.add(right);
        viewPager.setOffscreenPageLimit(fragments.size());
        viewPager.setAdapter(new DayAdapter(fragment.getChildFragmentManager(), context, fragments));
    }

    public void setViewPagerListener(final OnAppItemSelectListener onAppItemSelectListener) {
        getViewPager().addOnPageChangeListener(new BaseOnPagerChangeListener() {
            @Override
            public void onPageSelected(int position) {
                onAppItemSelectListener.onAppItemSelect(getViewPager(), null, position);
            }
        });
    }


    public ViewPager getViewPager() {
        return viewPager;
    }
}
