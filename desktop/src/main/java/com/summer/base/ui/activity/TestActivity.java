package com.summer.base.ui.activity;

import android.os.Bundle;

import com.summer.app.R;
import com.summer.view.timeline.view.TimeLineView;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class TestActivity extends BaseUIActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimeLineView timelineView = (TimeLineView) findViewById(R.id.time);
        timelineView.setTxt(new String[]{"12:12 出厂", "12:12 出厂", "12:12 出厂", "12:12 出厂", "12:12 出厂", "你妈嗨你妈嗨你妈嗨你妈嗨你妈嗨"});
        timelineView.setNowTime(0);
//        String s=TestBase64.getJsonData(MethodValue.getRecordFile("1"));
//
//        TestBase64.byte2File(s.getBytes(),MethodValue.getRecordFile("2"));
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.layout_test;
    }
}
