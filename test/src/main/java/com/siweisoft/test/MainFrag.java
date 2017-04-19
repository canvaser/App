package com.siweisoft.test;

//by summer on 2017-03-25.


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.lib.ope.BaseOpes;
import com.summer.lib.ui.frag.BaseUIFrag;

public class MainFrag extends BaseUIFrag<MainUIOpe<RecycleUIBean>, MainDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpes().getUiope().setTxt(getOpes().getUiope().getUiBean().text);
    }

    @Override
    public BaseOpes<MainUIOpe<RecycleUIBean>, MainDAOpe> create() {
        return new BaseOpes<>(new MainUIOpe<>(activity, new RecycleUIBean(activity)), new MainDAOpe());
    }
}
