package com.siweisoft.nurse.ui.base.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.base.ui.ope.BaseUIWithTitleOpe;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;

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
