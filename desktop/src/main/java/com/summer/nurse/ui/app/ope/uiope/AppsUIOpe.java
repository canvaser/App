package com.summer.nurse.ui.app.ope.uiope;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.fragment.BaseFrg;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.app.adapter.AppsAdapter;
import com.summer.nurse.ui.app.bean.dabean.AppDABean;
import com.summer.nurse.ui.app.fragment.AppFrag;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;
import com.summer.nurse.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class AppsUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.viewpager)
    ViewPager viewPager;

    AppsAdapter appsAdapter;

    ArrayList<View> views = new ArrayList<>();

    public AppsUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getMidTV().setText("应用");
    }


    public void initList(AppDABean appDABean, Fragment frag) {
        int current = viewPager.getCurrentItem();
        FragManager.getInstance().getFragMaps();
        ArrayList<BaseFrg> fragments = new ArrayList<>();
        String[] keys = new String[appDABean.getData().keySet().size()];
        keys = appDABean.getData().keySet().toArray(keys);
        for (int i = 0; i < appDABean.getData().size(); i++) {
            AppFrag appFrag = new AppFrag();
            Bundle bundle = new Bundle();
            bundle.putString(ValueConstant.DATA_DATA, keys[i]);
            appFrag.setArguments(bundle);
            fragments.add(appFrag);
        }
        viewPager.setOffscreenPageLimit(appDABean.getData().size());
        viewPager.setAdapter(new AppsAdapter(frag.getChildFragmentManager(), context, fragments));
        viewPager.setCurrentItem(current);
    }

    public AppsAdapter getAppsAdapter() {
        return appsAdapter;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }
}
