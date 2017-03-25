package com.summer.lib.base.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by ${viwmox} on 2017-03-03.
 */

public class TesUIFrag extends CommonUIFrag<TesUIOpe, TesDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        opes.getUiOpe().sdfdsfsf();

    }

    @Override
    public int onCreateView(boolean create) {
        opes = new CommonOpes<>(new TesUIOpe(this, getView()), new TesDAOpe(this));
        return 0;
    }
}
