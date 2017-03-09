package com.siweisoft.ui.bed.inputhandoverreport.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.siweisoft.lib.util.LogUtil;


/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class RecordView extends View {


    RecordListener recordListener;

    long[] times = new long[]{0l, 0l};

    public RecordView(Context context) {
        super(context);
    }

    public RecordView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.E("ACTION_DOWN");
                times[0] = System.currentTimeMillis();
                if (recordListener != null && isEnabled()) {
                    recordListener.start(this);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.E("ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                LogUtil.E("ACTION_UP");
                times[1] = System.currentTimeMillis();
                if (recordListener != null && isEnabled()) {
                    recordListener.stop(this, times[1] - times[0]);
                }
                break;
        }

        return true;
    }


    public interface RecordListener {

        void start(RecordView recordView);

        void stop(RecordView recordView, long time);
    }

    public void setRecordListener(RecordListener recordListener) {
        this.recordListener = recordListener;
    }
}
