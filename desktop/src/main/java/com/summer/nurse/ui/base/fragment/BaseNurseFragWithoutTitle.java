package com.summer.nurse.ui.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public abstract class BaseNurseFragWithoutTitle<A extends BaseNurseUIOpe, B extends BaseNetOpe, C extends BaseDBOpe, D extends BaseDAOpe> extends BaseNurseFrag {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View v = getView().findViewById(R.id.rl_base_titlecontainer);
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.removeView(v);
        view.requestLayout();
    }

}
