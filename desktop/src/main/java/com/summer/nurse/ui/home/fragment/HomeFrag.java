package com.summer.nurse.ui.home.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.summer.app.R;
import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.ui.home.ope.HomeUIOpe;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class HomeFrag extends BaseNurseFrag<HomeUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onStart() {
        super.onStart();
        View imageView = (ImageView) getView().findViewById(R.id.iv_info);
        imageView.setAlpha(1);
    }

    @Override
    public int getContainView() {
        return R.layout.index_home;
    }

    @Override
    public BaseNurseOpes<HomeUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new HomeUIOpe(activity, getView()), null, null, null);
        }
        return baseNurseOpes;
    }
}
