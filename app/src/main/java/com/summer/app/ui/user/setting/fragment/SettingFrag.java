package com.summer.app.ui.user.setting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.user.setting.ope.SettingUIOpe;
import com.summer.lib.base.ui.fragment.BaseUIFragment;
import com.summer.app.nursevalue.BaseID;
import com.summer.lib.constant.UrlConstant;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.util.NullUtil;
import com.summer.app.ui.user.login.fragment.LoginFrag2;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class SettingFrag extends BaseUIFragment {


    SettingUIOpe settingUIOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settingUIOpe = new SettingUIOpe(activity, getView());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_loginsetting;
    }

    @OnClick({BaseID.ID_BACK, R.id.btn_submit})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_BACK:
                FragmentUtil.getInstance().removeFrag(activity, this, LoginFrag2.class.getSimpleName());
                break;
            case R.id.btn_submit:
                if (!NullUtil.isStrEmpty(settingUIOpe.getNewET().getText().toString())) {
                    UrlConstant.URI = settingUIOpe.getNewET().getText().toString() + "/api.cshtml?key=";
                    FragmentUtil.getInstance().removeFrag(activity, this, LoginFrag2.class.getSimpleName());
                }
                break;
        }
    }
}
