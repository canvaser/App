package com.summer.lib.ui.frag;

//by summer on 2017-03-28.

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.lib.R;
import com.summer.lib.ope.BaseDAOpe;
import com.summer.lib.ope.BaseOpes;
import com.summer.lib.ope.BaseUIOpe;
import com.summer.lib.value.ValueConstant;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseUIFrag<A extends BaseUIOpe, B extends BaseDAOpe> extends BaseFrag {

    private BaseOpes<A, B> opes;

    private Unbinder unbinder;

    protected int index;

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
        View group = inflater.inflate(R.layout.layout_base_ui, null);
        ViewGroup parent = (ViewGroup) group.findViewById(R.id.base_ui_root);
        parent.addView(getOpes().getUiope().getUiBean().getView());
        unbinder = ButterKnife.bind(this, group);
        return group;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public BaseOpes<A, B> getOpes() {
        if (opes == null) {
            opes = create();
        }
        return opes;
    }

    public abstract BaseOpes<A, B> create();
}
