package com.summer.nurse.ui.setting.welcome.activity;

import android.content.Intent;
import android.os.Bundle;

import com.summer.app.R;
import com.summer.base.ui.activity.BaseUIWithOutTitleActivity;
import com.summer.nurse.ui.index.activity.IndexActivity;

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
