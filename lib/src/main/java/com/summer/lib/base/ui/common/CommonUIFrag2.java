package com.summer.lib.base.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.lib.R;
import com.summer.lib.base.ui.fragment.BaseFrg;
import com.summer.lib.base.ui.interf.FragIntef;
import com.summer.lib.base.ui.ope.BaseDAOpe;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.base.BottomFinishView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.view.refreshlayout.MaterialRefreshListener;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${viwmox} on 2017-02-27.
 */

public abstract class CommonUIFrag2<A extends BaseNurseUIOpe, B extends BaseDAOpe> extends BaseFrg implements View.OnClickListener, MaterialRefreshListener, FragIntef, BottomFinishView.Finish {

    private Unbinder unbinder;

    protected int index;

    protected BaseOpes<A, B> baseOpes;

    View backView;

    private ViewGroup parent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            index = getArguments().getInt(ValueConstant.FRAG_POSITION);
        }
        View group = inflater.inflate(getLayoutID(), null);
        parent = (ViewGroup) group.findViewById(R.id.common_container);
        View view = inflater.inflate(onCreateView(false), container, false);
        parent.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        unbinder = ButterKnife.bind(this, group);
        return group;
    }

    protected void setDisEnable() {
        parent.setEnabled(false);
        getView().findViewById(R.id.iv_info).setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onCreateView(true);
        backView = getView().findViewById(R.id.ftv_back);
        backView.setOnClickListener(this);
        unbinder = ButterKnife.bind(this, view);
        onCmd(getArguments());
        if (baseOpes != null && baseOpes.getUiOpe() != null && baseOpes.getUiOpe().getBottomFinishView() != null) {
            baseOpes.getUiOpe().getBottomFinishView().setFinish(this);
        }
    }

    public void onResult(int req, Bundle bundle) {

    }

    public void onCmd(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        if (v == backView) {
            FragManager.getInstance().finish(getFragmentManager(), index);
        }
    }

    public int getLayoutID() {
        return R.layout.layout_commonui;
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

    public BaseOpes<A, B> getBaseOpes() {
        return baseOpes;
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
