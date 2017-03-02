package com.siweisoft.nurse.ui.index.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.listener.BaseOnPagerChangeListener;
import com.siweisoft.base.ui.ope.BaseUIOpe;
import com.siweisoft.nurse.ui.app.fragment.AppsFrag;
import com.siweisoft.nurse.ui.calendar.fragment.CalendarFrag;
import com.siweisoft.nurse.ui.calendar.fragment.DayRecordFrag;
import com.siweisoft.nurse.ui.day.fragment.DayFrag;
import com.siweisoft.nurse.ui.home.fragment.HomeFrag;
import com.siweisoft.nurse.ui.index.adapter.HomePageAdapter;
import com.siweisoft.nurse.ui.index.view.HomeBottomView;
import com.siweisoft.nurse.ui.setting.setting.fragment.SettingFrag;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class HomeUIOpe extends BaseUIOpe {


    @Nullable
    @BindView(R.id.hbv_hbv)
    HomeBottomView homeBottomView;

    @BindView(R.id.vp_vp)
    ViewPager viewPager;

    HomePageAdapter homePageAdapter;

    private boolean load = false;


    public HomeUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {

        int[] ints = new int[]{R.layout.home_item_home, R.layout.home_item_day, R.layout.home_item_app, R.layout.home_item_calendar, R.layout.home_item_setting};


        final ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HomeFrag());
        fragments.add(new DayFrag());
        fragments.add(new AppsFrag());
        fragments.add(new DayRecordFrag());
        fragments.add(new SettingFrag());


        final ArrayList<View> views = new ArrayList<>();
        final FragmentActivity fragmentActivity = (FragmentActivity) context;

        for (int i = 0; i < ints.length; i++) {
            View view = LayoutInflater.from(context).inflate(ints[i], null);
            views.add(view);

        }

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < views.size(); i++) {
            integers.add(views.get(i).getId());
        }

        FragManager.getInstance().init(integers);


        homePageAdapter = new HomePageAdapter(context, views, new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                if (!load) {
                    for (int i = 0; i < views.size(); i++) {
                        FragManager.getInstance().startFragment(fragmentActivity.getSupportFragmentManager(), i, fragments.get(i));
                    }
                    load = true;
                }
            }
        });
        viewPager.setOffscreenPageLimit(views.size());
        viewPager.setAdapter(homePageAdapter);
        viewPager.addOnPageChangeListener(new BaseOnPagerChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getHomeBottomView().select(position);
            }
        });


    }

    public HomeBottomView getHomeBottomView() {
        return homeBottomView;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public HomePageAdapter getHomePageAdapter() {
        return homePageAdapter;
    }
}
