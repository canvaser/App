package com.siweisoft.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by summer on 2016/4/16 0016 16:03.
 */
public abstract class BaseUIFragment extends BaseFrg {


    private Unbinder unbinder;


    public BaseUIFragment(){

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View group = (ViewGroup) inflater.inflate(getLayoutID(),null);
        ViewGroup parent = (ViewGroup) group.findViewById(R.id.frag_base_container);
        View view = inflater.inflate(getContainView(), container, false);
        parent.addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        unbinder = ButterKnife.bind(this, group);
        return group;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public abstract int getContainView();

    public int getLayoutID(){
        return R.layout.layout_baseui;
    }



}
