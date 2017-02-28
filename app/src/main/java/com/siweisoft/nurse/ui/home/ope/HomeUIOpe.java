package com.siweisoft.nurse.ui.home.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.listener.BaseOnPagerChangeListener;
import com.siweisoft.lib.base.ui.ope.BaseUIOpe;
import com.siweisoft.lib.util.FragmentUtil;
import com.siweisoft.nurse.ui.bed.bedlist.fragment.BedListFGM;
import com.siweisoft.nurse.ui.check.checklist.fragment.CheckListFGM;
import com.siweisoft.nurse.ui.home.adapter.HomePageAdapter;
import com.siweisoft.nurse.ui.home.fragment.DrawerLayoutFrag;
import com.siweisoft.nurse.ui.home.view.HomeBottomView;
import com.siweisoft.nurse.ui.info.infolist.fragment.InfoListFGM;
import com.siweisoft.nurse.ui.mission.missionlist.fragment.MissionListFGM;
import com.siweisoft.nurse.ui.setting.setting.fragment.SettingFGM;
import com.siweisoft.lib.util.fragment.FragManager;

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

    @BindView(R.id.drawerlayout)
    DrawerLayout drawerLayout;

    private boolean load = false;


    public HomeUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {

        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BedListFGM());
        fragments.add(new MissionListFGM());
        fragments.add(new CheckListFGM());
        fragments.add(new InfoListFGM());
        fragments.add(new SettingFGM());

        final ArrayList<View> views = new ArrayList<>();
        final FragmentActivity fragmentActivity = (FragmentActivity) context;
        int[] ints = new int[]{R.layout.item_bed, R.layout.item_mission, R.layout.item_check, R.layout.item_info, R.layout.item_setting};
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


        FragmentUtil.getInstance().addToContaier(fragmentActivity, new DrawerLayoutFrag(), R.id.content_frame);

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

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }
}
