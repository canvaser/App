package com.summer.base.ui.ope;

import android.content.Context;
import android.view.View;

import com.summer.app.R;
import com.summer.view.refreshlayout.MaterialRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-06-19.
 */
public class BaseWithRefreshUIOpe extends BaseOpe {

    protected View containerView;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    public BaseWithRefreshUIOpe(Context context, View containerView) {
        super(context);
        this.containerView = containerView;
        if (containerView == null) {
            return;
        }
        ButterKnife.bind(this, containerView);
    }

}
