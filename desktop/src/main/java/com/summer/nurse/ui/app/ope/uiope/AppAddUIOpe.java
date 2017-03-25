package com.summer.nurse.ui.app.ope.uiope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.summer.app.R;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppAddUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.edt_input)
    EditText inputET;

    public AppAddUIOpe(Context context, View containerView) {
        super(context, containerView);
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("确定");
    }

    public EditText getInputET() {
        return inputET;
    }
}
