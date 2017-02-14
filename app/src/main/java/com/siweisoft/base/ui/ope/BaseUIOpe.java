package com.siweisoft.base.ui.ope;

import android.content.Context;
import android.view.View;

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
