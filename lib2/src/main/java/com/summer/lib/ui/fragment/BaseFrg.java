package com.summer.lib.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import com.summer.lib.ui.activity.BaseActivity;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BaseFrg extends Fragment {

    protected BaseActivity activity;

    protected LayoutInflater layoutInflater;

    protected Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = this;
        layoutInflater = LayoutInflater.from(getActivity());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            activity = (BaseActivity) context;
        }
    }
}
