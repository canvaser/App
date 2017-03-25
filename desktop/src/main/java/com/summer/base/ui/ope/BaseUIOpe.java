package com.summer.base.ui.ope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-06-19.
 */
public class BaseUIOpe extends BaseOpe {

    protected View rootView;

    protected LayoutInflater inflater;

    public BaseUIOpe(Context context, View rootView) {
        super(context);
        inflater = LayoutInflater.from(context);
        this.rootView = rootView;
        if (rootView == null) {
            return;
        }
        ButterKnife.bind(this, rootView);
    }

    /**
     * 设置界面布局
     *
     * @return 界面布局id
     */
    protected int onCreateContainerView() {
        return -1;
    }

    public View getRootView() {
        return rootView;
    }
}
