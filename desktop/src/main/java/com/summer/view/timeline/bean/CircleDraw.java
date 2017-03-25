package com.summer.view.timeline.bean;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.summer.constant.ValueConstant;

/**
 * Created by ${viwmox} on 2016-12-28.
 */

public class CircleDraw extends CirclePosition {

    Paint circlePaint = new Paint();

    InfoTxtDraw infoTxtDraw;

    public static int default_radious = 8 * ValueConstant.DIMEN_1;

    public CircleDraw(int x, int y, int radious, Paint circlePaint) {
        super(x, y, radious);
        this.circlePaint = circlePaint;
    }

    public CircleDraw(int x, int y, Paint circlePaint) {
        super(x, y, default_radious);
        this.circlePaint = circlePaint;
    }

    public Paint getCirclePaint() {
        return circlePaint;
    }

    public void setCirclePaint(Paint circlePaint) {
        this.circlePaint = circlePaint;
    }

    public InfoTxtDraw getInfoTxtDraw() {
        if (infoTxtDraw == null) {
            infoTxtDraw = new InfoTxtDraw(getX(), getY());
        }
        return infoTxtDraw;
    }

    public void setInfoTxtDraw(InfoTxtDraw infoTxtDraw) {
        this.infoTxtDraw = infoTxtDraw;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(getX(), getY(), getRadious(), getCirclePaint());
        getInfoTxtDraw().draw(canvas);
        //canvas.drawText(getInfoTxtDraw().getTxt(),getInfoTxtDraw().getX(),getInfoTxtDraw().getY(),getInfoTxtDraw().getPaint());
    }


}
