package com.summer.nurse.ui.home.ope;

import android.content.Context;
import android.view.View;

import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;

/**
 * Created by ${viwmox} on 2017-01-22.
 */

public class HomeUIOpe extends BaseNurseUIOpe {


    public HomeUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getMidTV().setText("家庭");
    }
}
