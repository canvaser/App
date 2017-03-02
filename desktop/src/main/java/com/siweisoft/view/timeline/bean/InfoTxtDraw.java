package com.siweisoft.view.timeline.bean;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.siweisoft.constant.ValueConstant;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class InfoTxtDraw extends Position {


    Paint paint;

    private String txt;

    public static int default_gap = 10 * ValueConstant.DIMEN_1;

    public static int default_textsize = 13 * ValueConstant.DIMEN_1;

    public int direct = 0;

    public static final int direct_top = 0;

    public static final int direct_bottom = 1;

    public InfoTxtDraw(int x, int y) {
        super(x, y);
    }

    public Paint getPaint() {
        if (paint == null) {
            paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(default_textsize);
        }
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void draw(Canvas canvas) {
        canvas.drawText(getTxt(), getX(), getY(), getPaint());
    }


}
