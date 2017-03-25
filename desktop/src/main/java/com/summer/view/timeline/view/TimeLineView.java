package com.summer.view.timeline.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.summer.constant.ValueConstant;
import com.summer.view.timeline.bean.CircleDraw;
import com.summer.view.timeline.bean.InfoTxtDraw;
import com.summer.view.timeline.bean.RedCricleDraw;
import com.summer.view.timeline.bean.TimeLineDataBean;

/**
 * Created by ${viwmox} on 2016-12-28.
 */

public class TimeLineView extends ImageView {

    Context context;

    public static int borderWidth_left = ValueConstant.DIMEN_1 * 50;

    public static int borderWidth_top = ValueConstant.DIMEN_1 * 30;

    public static int borderWidth_right = ValueConstant.DIMEN_1 * 50;

    public static int borderWidth_bottom = ValueConstant.DIMEN_1 * 30;

    TimeLineDataBean data;

    private int position = 5;

    public static final int max_circle = 5;

    String[] str = new String[]{"", "", "", "", "", ""};

    private int[][] values;

    public TimeLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (data == null) {

            values = new int[][]{{borderWidth_left, borderWidth_top},
                    {getWidth() / 2, borderWidth_top},
                    {getWidth() - borderWidth_right, borderWidth_top},
                    {getWidth() - borderWidth_right, getHeight() - borderWidth_bottom},
                    {borderWidth_left, getHeight() - borderWidth_bottom}
            };
            data = new TimeLineDataBean();
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.FILL);
            for (int i = 0; i < max_circle; i++) {
                data.getCircleXYs().add(new CircleDraw(values[i][0], values[i][1], paint));
            }
            data.setLastCircleDraw(new RedCricleDraw(values[position][0], values[position][1], paint));
            data.createLineDraw();
            Paint txtpaint = new Paint();
            txtpaint.setColor(Color.WHITE);
            for (int i = 0; i < data.getCircleXYs().size(); i++) {
                data.getCircleXYs().get(i).getInfoTxtDraw().setTxt(str[i]);
                if (i <= data.getCircleXYs().size() / 2) {
                    data.getCircleXYs().get(i).getInfoTxtDraw().setDirect(InfoTxtDraw.direct_top);
                } else {
                    data.getCircleXYs().get(i).getInfoTxtDraw().setDirect(InfoTxtDraw.direct_bottom);
                }
            }

            for (int i = 0; i < data.getCircleXYs().size(); i++) {
                switch (data.getCircleXYs().get(i).getInfoTxtDraw().getDirect()) {
                    case InfoTxtDraw.direct_bottom:
                        data.getCircleXYs().get(i).getInfoTxtDraw().setY(data.getCircleXYs().get(i).getInfoTxtDraw().getY() + InfoTxtDraw.default_textsize + InfoTxtDraw.default_gap);
                        break;
                    case InfoTxtDraw.direct_top:
                        data.getCircleXYs().get(i).getInfoTxtDraw().setY(data.getCircleXYs().get(i).getInfoTxtDraw().getY() - InfoTxtDraw.default_gap);
                        break;
                }
                data.getCircleXYs().get(i).getInfoTxtDraw().setX((int) (data.getCircleXYs().get(i).getInfoTxtDraw().getX() - (data.getCircleXYs().get(i).getInfoTxtDraw().getPaint().measureText(data.getCircleXYs().get(i).getInfoTxtDraw().getTxt())) / 2));

            }
            data.getCenterTxt().setTxt(str[str.length - 1]);
            data.getCenterTxt().setX((int) (getWidth() / 2 - data.getCenterTxt().getPaint().measureText(data.getCenterTxt().getTxt()) / 2));
            data.getCenterTxt().setY(getHeight() / 2 + InfoTxtDraw.default_textsize / 2);
            for (int i = 0; i < values.length - 1; i++) {
                if (i < position) {
                    data.getLineDraws().get(i).setIsgap(false);
                } else {
                    data.getLineDraws().get(i).setIsgap(true);
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
        for (int i = 0; i < data.getCircleXYs().size(); i++) {
            data.getCircleXYs().get(i).draw(canvas);
        }

        for (int i = 0; i < data.getLineDraws().size(); i++) {
            data.getLineDraws().get(i).draw(canvas);

        }
        data.getLastCircleDraw().draw(canvas);
        data.getCenterTxt().draw(canvas);
    }

    public void setNowTime(int position) {
        this.position = position;
        data = null;
        requestLayout();
    }

    public void setTxt(String[] str) {
        this.str = str;
        requestLayout();
    }
}
