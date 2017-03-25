package com.summer.lib.base.ui.ope;

import android.content.Context;
import android.view.View;

import com.summer.lib.R;
import com.summer.lib.view.base.BottomFinishView;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-06-19.
 */
public class BaseUIOpe extends BaseOpe {


    protected View containerView;

    BottomFinishView bottomFinishView;

    public BaseUIOpe(Context context, View containerView) {
        super(context);
        this.containerView = containerView;
        if (containerView == null) {
            return;
        }
        ButterKnife.bind(this, containerView);
        bottomFinishView = (BottomFinishView) containerView.findViewById(R.id.finishview);
    }

    public BottomFinishView getBottomFinishView() {
        return bottomFinishView;
    }
}
