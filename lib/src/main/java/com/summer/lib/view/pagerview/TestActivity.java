package com.summer.lib.view.pagerview;

import android.os.Bundle;

import com.summer.lib.base.ui.activity.BaseUIActivity;

/**
 * Created by ${viwmox} on 2017-03-21.
 */

public class TestActivity extends BaseUIActivity {

    TestUIOpe testUIOpe;

    @Override
    protected int onCreateContainerView() {
        return -1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testUIOpe = new TestUIOpe(activity, getRootVG());
    }
}
