package com.siweisoft.base.ui.activity;

import android.os.Bundle;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.util.file.TestBase64;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class TestActivity extends BaseUIActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String s=TestBase64.getJsonData(MethodValue.getRecordFile("1"));

        TestBase64.byte2File(s.getBytes(),MethodValue.getRecordFile("2"));
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.layout_test;
    }
}
