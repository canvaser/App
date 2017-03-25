package com.summer.lib.view.testview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.summer.lib.util.LogUtil;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class LLB extends LinearLayout {


    public LLB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.E(getClass().getSimpleName() + ":dispatchTouchEvent--down");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.E(getClass().getSimpleName() + ":dispatchTouchEvent--move");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.E(getClass().getSimpleName() + ":dispatchTouchEvent--up");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.E(getClass().getSimpleName() + "--onInterceptTouchEvent--down");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.E(getClass().getSimpleName() + "--onInterceptTouchEvent--move");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.E(getClass().getSimpleName() + "--onInterceptTouchEvent--up");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.E(getClass().getSimpleName() + "--onTouchEvent--down");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.E(getClass().getSimpleName() + "--onTouchEvent--move");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.E(getClass().getSimpleName() + "--onTouchEvent--up");
                break;
        }
        return true;
    }
}
