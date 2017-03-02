package com.siweisoft.nurse.ui.app.ope.uiope;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.activity.BaseActivity;
import com.siweisoft.base.ui.fragment.BaseFrg;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.app.adapter.AppsAdapter;
import com.siweisoft.nurse.ui.app.bean.dabean.AppDABean;
import com.siweisoft.nurse.ui.app.fragment.AppFrag;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;

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
