package com.summer.lib.ui.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.summer.lib.ui.activity.BaseActivity;
import com.summer.lib.util.log.LogUtil;

public class BaseFrag extends Fragment {

    protected BaseActivity activity;

    protected Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = this;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.E("onAttach" + context);
        if (context instanceof BaseActivity) {
            activity = (BaseActivity) context;
            LogUtil.E(context);
        }
    }
}