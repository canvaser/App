package com.summer.lib.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.lib.R;
import com.summer.lib.R2;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public abstract class BaseNurseTestFrag extends BaseUIFragment {

    protected int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            index = getArguments().getInt(ValueConstant.FRAG_POSITION);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Optional
    @OnClick({R2.id.ftv_back})
    public void onBackClick(View v) {
        switch (v.getId()) {
            case R2.id.ftv_back:
                FragManager.getInstance().finish(getFragmentManager(), index);
                break;
        }
    }

    public void onResult(int req, Bundle bundle) {

    }

    public int getLayoutID() {
        return R.layout.layout_baseui;
    }

}
