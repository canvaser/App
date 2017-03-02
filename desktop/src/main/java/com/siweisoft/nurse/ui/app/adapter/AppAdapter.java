package com.siweisoft.nurse.ui.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.bean.uibean.AppUIBean;
import com.siweisoft.util.BitmapUtil;
import com.siweisoft.util.NullUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppAdapter extends AppRecycleAdapter implements View.OnLongClickListener {

    ArrayList<AppDBBean> data;

    OnAppItemClickListener onAppItemClickListener;

    OnAppItemLongClickListener longClickListener;

    public AppAdapter(Context context, ArrayList<AppDBBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        AppUIBean appUIBean = new AppUIBean(context, view);
        return appUIBean;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AppUIBean appUIBean = (AppUIBean) holder;
        appUIBean.getAppTV().setText(data.get(position).getAppName());
        if (!NullUtil.isStrEmpty(data.get(position).getIconPath())) {
            appUIBean.getImageRL().setBackgroundColor(Color.BLACK);
            BitmapUtil.getInstance().setBgXY(context, appUIBean.getAppIV(), data.get(position).getIconPath());
        } else {
            appUIBean.getImageRL().setBackgroundColor(Color.TRANSPARENT);
            appUIBean.getAppIV().setImageDrawable(data.get(position).getIcon());
        }
        appUIBean.getRootV().setOnClickListener(this);
        appUIBean.getRootV().setTag(R.id.position, position);
        appUIBean.getRootV().setTag(R.id.data, data.get(position));
        appUIBean.getRootV().setOnLongClickListener(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, (Integer) v.getTag(R.id.position));
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    public ArrayList<AppDBBean> getData() {
        return data;
    }

    public void setData(ArrayList<AppDBBean> data) {
        this.data = data;
    }

    @Override
    public boolean onLongClick(View v) {
        if (longClickListener != null) {
            longClickListener.onAppItemLongClick(v, (Integer) v.getTag(R.id.position));
        }
        return true;
    }

    public void setLongClickListener(OnAppItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
}
