package com.siweisoft.nurse.ui.user.login.activity;

import android.os.Bundle;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.activity.BaseUIWithOutTitleActivity;
import com.siweisoft.lib.util.FragmentUtil;
import com.siweisoft.nurse.ui.user.login.fragment.LoginFrag2;

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
}
