package com.siweisoft.nurse.ui.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.siweisoft.app.R;
import com.siweisoft.util.LogUtil;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class NurseScrollView extends ScrollView{


    public interface  OnScrollChangedListener{
        public void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    OnScrollChangedListener  onScrollChangedListener;

    public NurseScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NurseScrollView(Context context) {
        super(context);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(onScrollChangedListener!=null){
            onScrollChangedListener.onScrollChanged(l,t,oldl,oldt);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }
}
