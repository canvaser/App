package com.siweisoft.lib.base.ui.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.lib.R;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-06-19.
 */
public class BaseUIOpe extends BaseOpe{



    protected View containerView;

    public BaseUIOpe(Context context,View containerView) {
        super(context);
        this.containerView=containerView;
        if(containerView==null){
            return;
        }
        ButterKnife.bind(this,containerView);
    }

}
