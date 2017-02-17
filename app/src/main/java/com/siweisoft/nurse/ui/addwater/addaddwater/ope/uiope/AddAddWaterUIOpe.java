package com.siweisoft.nurse.ui.addwater.addaddwater.ope.uiope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddAddWaterUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.tv_time)
    TextView titleTV;

    @BindView(R.id.et_time)
    EditText timeET;

    @BindView(R.id.et_txt)
    EditText txtET;

    @BindView(R.id.et_msg)
    EditText msgET;

    @BindView(R.id.et_speed)
    EditText speedET;

    @BindView(R.id.et_left)
    EditText leftET;

    public AddAddWaterUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public EditText getLeftET() {
        return leftET;
    }

    public EditText getMsgET() {
        return msgET;
    }

    public EditText getSpeedET() {
        return speedET;
    }

    public EditText getTimeET() {
        return timeET;
    }

    public TextView getTitleTV() {
        return titleTV;
    }

    public EditText getTxtET() {
        return txtET;
    }
}
