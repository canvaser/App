package com.summer.nurse.ui.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.base.ui.fragment.BaseUIWithRefreshFragment;
import com.summer.constant.ValueConstant;
import com.summer.nurse.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public abstract class BaseRefreshNurseFrag extends BaseUIWithRefreshFragment {

    protected int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            index = getArguments().getInt(ValueConstant.DATA_POSITION);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Optional
    @OnClick({R.id.ftv_back})
    public void onBackClick(View v) {
        switch (v.getId()) {
            case R.id.ftv_back:
                FragManager.getInstance().finish(getFragmentManager(), index);
                break;
        }
    }

    public void onResult(int req, Bundle bundle) {

    }


}
