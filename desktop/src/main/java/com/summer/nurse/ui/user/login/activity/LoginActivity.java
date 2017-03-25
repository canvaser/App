package com.summer.nurse.ui.user.login.activity;

import android.os.Bundle;

import com.summer.app.R;
import com.summer.base.ui.activity.BaseUIWithOutTitleActivity;
import com.summer.nurse.ui.user.login.fragment.LoginFrag;
import com.summer.util.FragmentUtil;
import com.summer.util.LogUtil;

/**
 * Created by ${viwmox} on 2016-10-21.
 */
public class LoginActivity extends BaseUIWithOutTitleActivity {


    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtil.getInstance().addToContaier(activity, new LoginFrag(), R.id.root);
        LogUtil.E(test());
    }


    public native String test();


    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_login;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getFragments().size() == 2) {
            FragmentUtil.getInstance().removeFrag(activity,
                    getSupportFragmentManager().getFragments().get(1),
                    getSupportFragmentManager().getFragments().get(0).getClass().getSimpleName());
        } else {
            super.onBackPressed();
        }
    }
}
