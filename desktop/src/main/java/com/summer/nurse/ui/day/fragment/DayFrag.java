package com.summer.nurse.ui.day.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.base.ui.id.BaseID;
import com.summer.base.ui.interf.view.OnAppItemSelectListener;
import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.ui.day.bean.dbbean.DayDBBean;
import com.summer.nurse.ui.day.ope.dbope.DayAddDBOpe;
import com.summer.nurse.ui.day.ope.uiope.DayUIOpe;
import com.summer.nurse.util.fragment.FragManager;
import com.summer.util.LogUtil;
import com.summer.util.NullUtil;
import com.summer.util.VibratorUtil;
import com.summer.util.data.FormatUtil;
import com.summer.util.media.VoiceUtil;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class DayFrag extends BaseNurseFrag<DayUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> implements OnAppItemSelectListener {


    MidDayReceiver midDayReceiver;


    @Override
    public int getContainView() {
        return R.layout.frag_day;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().init(fragment);
        getOpe().getBaseNurseUIOpe().setViewPagerListener(this);
        midDayReceiver = new MidDayReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(activity.getPackageName() + ValueConstant.ACITON_GLOB_CAST);
        activity.registerReceiver(midDayReceiver, intentFilter);
    }

    @Override
    public void onDestroy() {
        activity.unregisterReceiver(midDayReceiver);
        super.onDestroy();
    }

    @Override
    public BaseNurseOpes<DayUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new DayUIOpe(activity, getView()), new BaseNetOpe(activity), new DayAddDBOpe(activity, new DayDBBean()), null);
        }
        return baseNurseOpes;
    }

    @Override
    public void onAppItemSelect(ViewGroup viewGroup, View view, int position) {
        getOpe().getBaseNurseUIOpe().getMidTV().setText(getOpe().getBaseNurseUIOpe().getViewPager().getAdapter().getPageTitle(position));
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new DayAddFrag(), new Bundle(), ValueConstant.CODE_REQUSET);
                break;

        }
    }

    @OnLongClick({BaseID.ID_MID})
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                LogUtil.E("longclick");
                VoiceUtil.getInstance().stop();
                break;
        }
        return true;
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        getOpe().getBaseNurseUIOpe().init(fragment);
    }


    class MidDayReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ArrayList<DayDBBean> ll = getOpe().getBaseDBOpe().getRightNow(FormatUtil.getInstance().getNowHHMMTime());
            if (ll.size() > 0) {
                VibratorUtil.getInstance().call(activity);
                LogUtil.E(ll.get(0).toString());
                if (ll.get(0).isPlayMusic() && !NullUtil.isStrEmpty(ll.get(0).getMusicUrl())) {
                    VoiceUtil.getInstance().play(ll.get(0).getMusicUrl());
                }
                getOpe().getBaseNurseUIOpe().init(fragment);
            }
        }
    }
}
