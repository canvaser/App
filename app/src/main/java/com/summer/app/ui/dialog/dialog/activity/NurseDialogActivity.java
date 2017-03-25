package com.summer.app.ui.dialog.dialog.activity;

import android.os.Bundle;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.base.ui.activity.DialogActivity;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.app.ui.dialog.dialog.ope.uiope.NurseDialogUIOpe;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class NurseDialogActivity extends DialogActivity implements OnAppItemClickListener {

    NurseDialogUIOpe uiOpe;

    private String[] strings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiOpe = new NurseDialogUIOpe(activity, getRootVG());
        strings = getIntent().getStringArrayExtra(ValueConstant.DATA_DATA);
        uiOpe.showList(strings, this);
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_dialog_list;
    }

    @Override
    public void onAppItemClick(View view, int position) {

    }
}
