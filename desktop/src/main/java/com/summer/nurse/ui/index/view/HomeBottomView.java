package com.summer.nurse.ui.index.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.base.ui.interf.view.OnAppItemLongClickListener;
import com.summer.base.ui.interf.view.OnAppItemSelectListener;
import com.summer.util.ScreenUtil;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class HomeBottomView extends LinearLayout {

    private Context context;


    ArrayList<View> tabViews = new ArrayList<>();

    ArrayList<TextView> txtViews = new ArrayList<>();


    OnAppItemSelectListener onAppItemSelectListener;

    OnAppItemLongClickListener onAppItemLongClickListener;

    private int index = -1;


    public HomeBottomView(Context context) {
        super(context);
        init(context, null);
    }

    public HomeBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_home_bottom, null);
        tabViews.add(view.findViewById(R.id.ll_bed));
        tabViews.add(view.findViewById(R.id.ll_mission));
        tabViews.add(view.findViewById(R.id.ll_check));
        tabViews.add(view.findViewById(R.id.ll_info));
        tabViews.add(view.findViewById(R.id.ll_setting));
        txtViews.add((TextView) view.findViewById(R.id.tv_bed));
        txtViews.add((TextView) view.findViewById(R.id.tv_mission));
        txtViews.add((TextView) view.findViewById(R.id.tv_check));
        txtViews.add((TextView) view.findViewById(R.id.tv_info));
        txtViews.add((TextView) view.findViewById(R.id.tv_setting));
        addView(view, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ButterKnife.bind(this, this);
    }


    public void setOnAppItemSelectListener(OnAppItemSelectListener onAppItemSelectListener) {
        this.onAppItemSelectListener = onAppItemSelectListener;
    }

    public void select(int index) {
        for (int i = 0; i < tabViews.size(); i++) {
            if (index == i) {
                tabViews.get(i).setSelected(true);
                txtViews.get(i).setTextColor(context.getResources().getColor(R.color.color_text_select));
            } else {
                tabViews.get(i).setSelected(false);
                txtViews.get(i).setTextColor(context.getResources().getColor(R.color.color_text_notsel));
            }
        }
    }

    public void setOnAppItemLongClickListener(OnAppItemLongClickListener onAppItemLongClickListener) {
        this.onAppItemLongClickListener = onAppItemLongClickListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = 0, x = 0, y = 0, sx = 0, sy = 0, ex = 0, ey = 0, num = 0;
        if (x == 0) {
            x = (int) event.getRawX();
            y = (int) event.getRawY();

            sx = 0;
            sy = (int) (ScreenUtil.getInstance().getScreenSize(context)[1] - 43 * getResources().getDimension(R.dimen.dimen_1));

            ex = ScreenUtil.getInstance().getScreenSize(context)[0];
            ey = ScreenUtil.getInstance().getScreenSize(context)[1];

            num = 5;
        }
        i = ScreenUtil.getInstance().getIndex(x, y, sx, sy, ex, ey, num);
        if (getIndex() != i && i != -1) {
            select(i);
            if (onAppItemSelectListener != null) {
                onAppItemSelectListener.onAppItemSelect(this, tabViews.get(i), i);
            }
        }
        index = i;
        return true;
    }

    public int getIndex() {
        return index;
    }
}
