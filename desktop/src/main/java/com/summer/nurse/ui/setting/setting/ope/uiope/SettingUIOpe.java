package com.summer.nurse.ui.setting.setting.ope.uiope;

import android.content.Context;
import android.view.View;

import butterknife.BindView;

import com.summer.app.R;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;

/**
 * Created by summer on 2016/12/31 13:33.
 */

public class SettingUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.ll_backsetting)
    View backSettingV;

    public SettingUIOpe(Context context, View containerView) {
        super(context, containerView);
    }


    public View getBackSettingV() {
        return backSettingV;
    }
}
