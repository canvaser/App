package com.summer.nurse.ui.base.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.ope.BaseUIWithTitleOpe;
import com.summer.view.refreshlayout.MaterialRefreshLayout;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BaseNurseUIOpe extends BaseUIWithTitleOpe {

    @Nullable
    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    public BaseNurseUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    @Nullable
    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
