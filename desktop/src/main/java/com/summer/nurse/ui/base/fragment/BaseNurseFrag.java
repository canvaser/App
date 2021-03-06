package com.summer.nurse.ui.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.base.ui.fragment.BaseUIFrag;
import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;
import com.summer.nurse.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public abstract class BaseNurseFrag<A extends BaseNurseUIOpe, B extends BaseNetOpe, C extends BaseDBOpe, D extends BaseDAOpe> extends BaseUIFrag {

    protected int index;

    protected BaseNurseOpes baseNurseOpes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            index = getArguments().getInt(ValueConstant.FRAG_POSITION);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseNurseOpes = getOpe();
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

    public void onCmd(Bundle bundle) {

    }

    public int getLayoutID() {
        return R.layout.layout_baseui;
    }

    public abstract BaseNurseOpes<A, B, C, D> getOpe();

}
