package com.siweisoft.view.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.siweisoft.util.CalendarUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.Lunar;
import com.siweisoft.view.calendar.interf.OnDaySelectListener;

import java.util.Calendar;

/**
 * Created by ${viwmox} on 2016-09-12.
 */
public class CalendarMonthView extends View{

    private Paint paint;

    private Paint weekPaint;

    private Paint txtPaint;

    private Paint chinaPaint;

    private int year = 2016;

    private int month = 1;

    private int strokeWidth = 5;

    String[] s ={"日","一","二","三","四","五","六"};


    private OnDaySelectListener onDaySelectListener;


    public CalendarMonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        paint=new Paint();
        weekPaint=new Paint();
        txtPaint = new Paint();
        txtPaint.setAntiAlias(true);
        chinaPaint=new Paint();
        weekPaint.setColor(Color.BLACK);
        weekPaint.setAntiAlias(true);
        txtPaint.setColor(Color.BLACK);
        chinaPaint.setColor(Color.BLACK);
        chinaPaint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(strokeWidth);
        weekPaint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void refreshDate(int year, int month){
        this.year =year;
        this.month = month;
        LogUtil.E(year+":"+month);
        invalidate();

    }

    int minWidth=1;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int w = getWidth()>getHeight()?getHeight():getWidth();
        minWidth = w/7;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
        int top = minWidth;
        int first = CalendarUtil.getInstance().getWeekDayInFristDayOfMonth(year,month);
        int max = CalendarUtil.getInstance().getActualMaximum(year,month);
        int num = 0;
       for(int i=0;i<6;i++){
           for(int j=0;j<7;j++){
               num++;
               paint.setColor(Color.WHITE);
               paint.setStyle(Paint.Style.STROKE);
               canvas.drawRect(j*minWidth,top+minWidth*i,j*minWidth+minWidth,top+minWidth*i+minWidth,paint);
               if(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)==(num-first+1)&&Calendar.getInstance().get(Calendar.YEAR)==year && Calendar.getInstance().get(Calendar.MONTH)==month-1){
                   paint.setStyle(Paint.Style.FILL);
                   paint.setColor(Color.RED);
                   canvas.drawRect(j*minWidth+strokeWidth,top+minWidth*i+strokeWidth,j*minWidth+minWidth-strokeWidth,top+minWidth*i+minWidth-strokeWidth,paint);
               }
               if((num-first+1)==downtxt&&downtxt!=-1){
                   paint.setStyle(Paint.Style.FILL);
                   paint.setColor(Color.BLUE);
                   canvas.drawRect(j*minWidth+strokeWidth,top+minWidth*i+strokeWidth,j*minWidth+minWidth-strokeWidth,top+minWidth*i+minWidth-strokeWidth,paint);
               }

               if(num<=7){
                   weekPaint.setTextSize(minWidth/2);
                   canvas.drawText(s[num-1],j*minWidth+(minWidth/4),(minWidth*5/8),weekPaint);
               }

               if(num<=(max+first-1)&&num>=first){
                   txtPaint.setTextSize(minWidth/2);
                   chinaPaint.setTextSize(minWidth*7/30);
                   Calendar cal = Calendar.getInstance();
                   cal.set(Calendar.YEAR,year);
                   cal.set(Calendar.MONTH,month);
                   cal.set(Calendar.DAY_OF_MONTH,(num-first+1));
                   Lunar lunar=new Lunar(cal);
                   //公历
                   if((num-first+1)>9){
                       canvas.drawText((num-first+1)+"",j*minWidth+(minWidth/4),top+minWidth*i+(minWidth*5/8),txtPaint);
                   }else{
                       canvas.drawText((num-first+1)+"",j*minWidth+(minWidth*3/8),top+minWidth*i+(minWidth*5/8),txtPaint);
                   }
                    //农历
                   if(lunar.day>9){
                       canvas.drawText(lunar.day+"",j*minWidth+(minWidth*3/8),top+minWidth*i+(minWidth*7/8),chinaPaint);
                   }else{
                       canvas.drawText(lunar.day+"",j*minWidth+(minWidth*49/112),top+minWidth*i+(minWidth*7/8),chinaPaint);
                   }
               }

           }
       }
    }

    float downx=0,downy=0;
    float upx=0,upy=0;
    float movex=0,movey=0;

    int downtxt = -1;
    int uptxt = -1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                downx=event.getX();
                downy=event.getY();
                downtxt = getIndex(event.getX(),event.getY(),0,minWidth,minWidth);
                break;
            case MotionEvent.ACTION_MOVE:
                movex=event.getX();
                movey=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                upx=event.getX();
                upy=event.getY();
                uptxt = getIndex(event.getX(),event.getY(),0,minWidth,minWidth);
                if(downtxt==uptxt && downtxt!=-1){
                  if(onDaySelectListener!=null){
                      onDaySelectListener.onDaySelect(year,month,downtxt,getNIndex(downtxt));
                  }
                }
                invalidate();
                break;
        }
        return true;
    }

    private int getIndex(float x,float y,int left,int top,float width){
        int first = CalendarUtil.getInstance().getWeekDayInFristDayOfMonth(year,month);
        int max = CalendarUtil.getInstance().getActualMaximum(year,month);
        int h = (((int)(x-left))/((int)width))+1;
        int v= (((int)(y-top))/((int)width))+1;
        int num = (v-1)*7+h;
        int txt = num - first+1;
        if(txt >max){
            txt = -1;
        }
        return txt;
    }

    private int getNIndex(int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);
        Lunar lunar=new Lunar(cal);
        return lunar.day;
    }



    public void setOnDaySelectListener(OnDaySelectListener onDaySelectListener) {
        this.onDaySelectListener = onDaySelectListener;
    }
}
