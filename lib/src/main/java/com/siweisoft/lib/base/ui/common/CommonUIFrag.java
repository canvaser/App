package com.siweisoft.lib.base.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.lib.R;
import com.siweisoft.lib.base.ui.fragment.BaseFrg;
import com.siweisoft.lib.base.ui.interf.FragIntef;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseOpes;
import com.siweisoft.lib.base.ui.ope.BaseUIOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListener;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${viwmox} on 2017-02-27.
 */

public abstract class CommonUIFrag<A extends CommonUIOpe, B extends CommonDAOpe> extends BaseFrg implements View.OnClickListener, MaterialRefreshListener, FragIntef {

    private Unbinder unbinder;

    protected int index;

    protected CommonOpes<A, B> opes;

    View backView;

    private ViewGroup parent;

    protected CommonUIFrag fragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = this;
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

    public CommonOpes<A, B> getOpes() {
        return opes;
    }

    public int getIndex() {
        return index;
    }
}
