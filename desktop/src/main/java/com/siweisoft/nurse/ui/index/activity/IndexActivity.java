package com.siweisoft.nurse.ui.index.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.activity.BaseUIActivity;
import com.siweisoft.base.ui.activity.BaseUIWithOutTitleActivity;
import com.siweisoft.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.base.ui.interf.view.OnAppItemSelectListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.index.ope.HomeDataOpe;
import com.siweisoft.nurse.ui.index.ope.HomeNetOpe;
import com.siweisoft.nurse.ui.index.ope.HomeUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.SPUtil;
import com.siweisoft.util.ScreenUtil;
import com.siweisoft.util.uuzuche.lib_zxing.activity.CaptureActivity;

import butterknife.OnClick;

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
