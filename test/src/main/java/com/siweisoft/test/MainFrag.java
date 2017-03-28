package com.siweisoft.test;

//by summer on 2017-03-25.


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.lib.ope.BaseOpes;
import com.summer.lib.ui.frag.BaseUIFrag;

public class MainFrag extends BaseUIFrag<MainUIOpe, MainDAOpe> {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public BaseOpes<MainUIOpe, MainDAOpe> create() {
        return new BaseOpes<>(new MainUIOpe(activity, new MainUIBean(activity)), new MainDAOpe());
    }
}
