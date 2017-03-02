package com.siweisoft.view.timeline.bean;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class RedCricleDraw extends CircleDraw {

    public RedCricleDraw(int x, int y, Paint circlePaint) {
        super(x, y, circlePaint);
        init();
    }

    public RedCricleDraw(int x, int y, int radious, Paint circlePaint) {
        super(x, y, radious, circlePaint);
        init();
    }

    private void init() {
        Paint lastpaint = new Paint();
        lastpaint.setColor(Color.RED);
        setRadious(CircleDraw.default_radious * 2 / 3);
        setCirclePaint(lastpaint);
    }


    public void draw(Canvas canvas) {
        canvas.drawCircle(getX(), getY(), getRadious(), getCirclePaint());
    }
}
