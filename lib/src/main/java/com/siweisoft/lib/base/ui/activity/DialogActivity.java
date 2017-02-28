package com.siweisoft.lib.base.ui.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.siweisoft.lib.R;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public abstract class DialogActivity extends BaseUIWithOutTitleActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams windowParams = getWindow().getAttributes();
        windowParams.alpha = 0;
        getWindow().setAttributes(windowParams);

    }
}
