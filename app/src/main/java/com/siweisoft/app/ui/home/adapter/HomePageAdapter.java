package com.siweisoft.app.ui.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import com.siweisoft.lib.base.ui.interf.OnFinishListener;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-21.
 */
public class HomePageAdapter extends PagerAdapter {


    Context context;

    ArrayList<View> views;

    OnFinishListener onFinishListener;

    public HomePageAdapter(Context context, ArrayList<View> views, OnFinishListener onFinishListener) {
        this.context = context;
        this.views = views;
        this.onFinishListener = onFinishListener;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        if (position == views.size() - 1 && onFinishListener != null) {
            onFinishListener.onFinish(null);
        }
        return views.get(position);
    }


}
