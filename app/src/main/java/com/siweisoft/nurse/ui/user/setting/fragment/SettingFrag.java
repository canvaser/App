package com.siweisoft.nurse.ui.user.setting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.fragment.BaseUIFragment;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.constant.UrlConstant;
import com.siweisoft.nurse.ui.user.login.fragment.LoginFrag;
import com.siweisoft.nurse.ui.user.setting.ope.SettingUIOpe;
import com.siweisoft.util.FragmentUtil;
import com.siweisoft.util.NullUtil;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class SettingFrag extends BaseUIFragment {


    SettingUIOpe settingUIOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settingUIOpe= new SettingUIOpe(activity,getView());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_loginsetting;
    }

    @OnClick({BaseID.ID_BACK,R.id.btn_submit})
    public void onClickEvent(View v){
        switch (v.getId()){
            case BaseID.ID_BACK:
                FragmentUtil.getInstance().removeFrag(activity,this, LoginFrag.class.getSimpleName());
                break;
            case R.id.btn_submit:
                if(!NullUtil.isStrEmpty(settingUIOpe.getNewET().getText().toString())){
                    UrlConstant.URI = settingUIOpe.getNewET().getText().toString()+"/api.cshtml?key=";
                    FragmentUtil.getInstance().removeFrag(activity,this, LoginFrag.class.getSimpleName());
                }
                break;
        }
    }
}
