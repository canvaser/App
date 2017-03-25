package com.summer.lib.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.lib.R;
import com.summer.lib.base.ui.ope.BaseDAOpe;
import com.summer.lib.base.ui.ope.BaseDBOpe;
import com.summer.lib.base.ui.ope.BaseNetOpe;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.base.BottomFinishView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.view.refreshlayout.MaterialRefreshListener;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public abstract class BaseNurseFrag<A extends BaseNurseUIOpe, B extends BaseNetOpe, C extends BaseDBOpe, D extends BaseDAOpe> extends BaseUIFragment implements MaterialRefreshListener, BottomFinishView.Finish {

    protected int index;

    protected BaseNurseOpes<A, B, C, D> baseNurseOpes;

    View backView;

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
        backView = getView().findViewById(R.id.ftv_back);
        backView.setOnClickListener(this);
        unbinder = ButterKnife.bind(this, view);
        if (getOpe() != null && getOpe().getUiOpe() != null && getOpe().getUiOpe().getBottomFinishView() != null) {
            getOpe().getUiOpe().getBottomFinishView().setFinish(this);
        }
    }


    public void onResult(int req, Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == backView) {
            FragManager.getInstance().finish(getFragmentManager(), index);
        }
    }

    public void onCmd(Bundle bundle) {

    }

    public abstract BaseNurseOpes<A, B, C, D> getOpe();

    public int getLayoutID() {
        return R.layout.layout_baseui;
    }

    @Override
    public void onfinish() {

    }

    @Override
    public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

    }

    @Override
    public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {

    }

    public int getIndex() {
        return index;
    }

    @Override
    public void finishUI() {
        if (FragManager.getInstance().getFragMaps().get(index).size() > 1) {
            FragManager.getInstance().finish(getFragmentManager(), index);
        }
    }
}
