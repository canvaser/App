package com.siweisoft.lib.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.lib.R;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseUIOpe;
import com.siweisoft.lib.base.ui.ope.CommonOpes;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListener;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${viwmox} on 2017-02-27.
 */

public abstract class CommonUIFrag<A extends BaseUIOpe, B extends BaseDAOpe> extends BaseFrg implements View.OnClickListener, MaterialRefreshListener {

    private Unbinder unbinder;

    protected int index;

    protected CommonOpes<A, B> commonOpes;

    View backView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            index = getArguments().getInt(ValueConstant.FRAG_POSITION);
        }
        View group = (ViewGroup) inflater.inflate(getLayoutID(), null);
        ViewGroup parent = (ViewGroup) group.findViewById(R.id.frag_base_container);
        View view = inflater.inflate(getContainView(), container, false);
        parent.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        unbinder = ButterKnife.bind(this, group);
        return group;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        commonOpes = getOpe();
        backView = getView().findViewById(R.id.ftv_back);
        backView.setOnClickListener(this);
        unbinder = ButterKnife.bind(this, view);
    }

    public abstract int getContainView();

    public void onResult(int req, Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        if (v == backView) {
            FragManager.getInstance().finish(getFragmentManager(), index);
        }
    }

    public void onCmd(Bundle bundle) {

    }

    public abstract CommonOpes<A, B> getOpe();

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


}