package com.summer.app.ui.user.setting.ope;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.base.ui.ope.BaseUIWithTitleOpe;
import com.summer.app.nursevalue.DataValue;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class SettingUIOpe extends BaseUIWithTitleOpe {

    @BindView(R.id.tv_before)
    TextView beforeTV;

    @BindView(R.id.et_new)
    EditText newET;


    @BindView(R.id.btn_submit)
    Button submitBtn;


    public SettingUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("服务器地址");
        getBeforeTV().setText("原服务器地址：" + DataValue.URL_NURSE);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }

    public TextView getBeforeTV() {
        return beforeTV;
    }

    public EditText getNewET() {
        return newET;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }
}
