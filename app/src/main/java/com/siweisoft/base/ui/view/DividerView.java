package com.siweisoft.base.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.siweisoft.app.R;

/**
 * Created by ${viwmox} on 2016-06-22.
 */
public class DividerView extends View{


    Paint paint=new Paint();


    public DividerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setShadowLayer(0f,0f,getHeight()/2, getResources().getColor(R.color.color_base_graybg));
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
    }
}
