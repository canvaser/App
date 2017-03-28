package com.summer.lib.ui.activity;

//by summer on 2017-03-28.

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

import com.summer.lib.app.LibAplication;

public class BaseActivity extends FragmentActivity {

    protected Handler handler = new Handler();

    protected FragmentActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        LibAplication application = (LibAplication) getApplication();
        application.getActivityHashMap().put(getClass().getSimpleName(), activity);
        application.getActivities().add(activity);
    }
}
