package com.summer.nurse.ui.index.activity;

import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.base.ui.activity.BaseUIActivity;
import com.summer.base.ui.interf.view.OnAppItemLongClickListener;
import com.summer.base.ui.interf.view.OnAppItemSelectListener;
import com.summer.constant.ValueConstant;
import com.summer.network.netadapter.OnNetWorkReqAdapter;
import com.summer.nurse.ui.index.ope.HomeDataOpe;
import com.summer.nurse.ui.index.ope.HomeNetOpe;
import com.summer.nurse.ui.index.ope.HomeUIOpe;
import com.summer.nurse.util.fragment.FragManager;
import com.summer.util.SPUtil;
import com.summer.util.ScreenUtil;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class IndexActivity extends BaseUIActivity implements OnAppItemSelectListener, OnAppItemLongClickListener {


    HomeUIOpe homeUIOpe;

    HomeDataOpe homeDataOpe;

    HomeNetOpe homeNetOpe;

    @Override
    public boolean haveTitle() {
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (homeUIOpe == null) {
            homeUIOpe = new HomeUIOpe(activity, getRootVG());
            homeDataOpe = new HomeDataOpe(activity);
            homeNetOpe = new HomeNetOpe(activity);

            homeUIOpe.getHomeBottomView().setOnAppItemSelectListener(this);
            homeUIOpe.getHomeBottomView().setOnAppItemLongClickListener(this);
            homeNetOpe.getAdditionList(new OnNetWorkReqAdapter(activity) {
                @Override
                public void onNetWorkResult(boolean success, Object o) {
                    if (success) {
                        SPUtil.getInstance().saveStr(ValueConstant.ADDITION_INFO, o.toString());
                    }
                }
            });
            ScreenUtil.getInstance().getScreenSize(activity);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_home;
    }

    @Override
    public void onAppItemSelect(ViewGroup viewGroup, View view, int position) {
        homeDataOpe.setIndex(position);
        homeUIOpe.getViewPager().setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        if (FragManager.getInstance().getFragMaps().get(homeDataOpe.getIndex()).size() > 1) {
            FragManager.getInstance().finish(getSupportFragmentManager(), homeDataOpe.getIndex());
        }
    }

    public HomeUIOpe getHomeUIOpe() {
        return homeUIOpe;
    }

    @Override
    public void onAppItemLongClick(View view, int position) {
        FragManager.getInstance().clearTop(getSupportFragmentManager(), position);
    }
}
