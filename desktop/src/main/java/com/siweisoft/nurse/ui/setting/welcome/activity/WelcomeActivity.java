package com.siweisoft.nurse.ui.setting.welcome.activity;

import android.content.Intent;
import android.os.Bundle;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.activity.BaseUIWithOutTitleActivity;
import com.siweisoft.nurse.ui.index.activity.IndexActivity;

/**
 * Created by ${viwmox} on 2017-01-22.
 */

public class WelcomeActivity extends BaseUIWithOutTitleActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity, IndexActivity.class));
            }
        }, 500);
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_welcome;
    }

    @Override
    public boolean isFullScreen() {
        return true;
    }
}
