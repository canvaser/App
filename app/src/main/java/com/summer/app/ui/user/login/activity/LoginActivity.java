package com.summer.app.ui.user.login.activity;

import android.os.Bundle;

import com.summer.app.R;
import com.summer.app.ui.user.login.fragment.LoginFrag2;
import com.summer.lib.base.ui.activity.BaseUIWithOutTitleActivity;
import com.summer.lib.util.FragmentUtil;

/**
 * Created by ${viwmox} on 2016-10-21.
 */
public class LoginActivity extends BaseUIWithOutTitleActivity {


    static {
        //System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtil.getInstance().addToContaier(activity, new LoginFrag2(), R.id.root);
        //LogUtil.E(test());
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

    public int getStatusColor() {
        return R.color.color_base_nurse;
    }
}
