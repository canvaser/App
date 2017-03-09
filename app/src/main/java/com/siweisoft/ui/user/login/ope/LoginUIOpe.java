package com.siweisoft.ui.user.login.ope;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-10-21.
 */
public class LoginUIOpe<A extends CommonUIFrag2> extends BaseNurseUIOpe<A> {

    @BindView(R.id.et_account)
    EditText accountEt;

    @BindView(R.id.et_pwd)
    EditText pwdEt;

    @BindView(R.id.btn_login)
    Button loginBtn;

    @BindView(R.id.tv_area)
    TextView areaTV;

    public LoginUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("护士工作站");
        getRightTV().setSelected(true);
        getRightTV().setText("设置");
        getBackTV().setVisibility(View.GONE);
        getRightTV().setVisibility(View.VISIBLE);
    }

    public EditText getAccountEt() {
        return accountEt;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public EditText getPwdEt() {
        return pwdEt;
    }

    public TextView getAreaTV() {
        return areaTV;
    }
}
