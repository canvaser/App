package com.siweisoft.app.ui.mission.missionlist.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.siweisoft.app.R;
import com.siweisoft.lib.util.LogUtil;

/**
 * Created by ${viwmox} on 2017-03-10.
 */

public class MissionView extends LinearLayout {


    public MissionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(R.color.white);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.E("down");
                getChildAt(0).setSelected(true);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                LogUtil.E("up");
                getChildAt(0).setSelected(false);
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
