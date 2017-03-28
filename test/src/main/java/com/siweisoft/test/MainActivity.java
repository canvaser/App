package com.siweisoft.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.summer.lib.ui.activity.BaseUIActivity;

public class MainActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().add(R.id.activity_main, new MainFrag()).commit();
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_main;
    }
}
