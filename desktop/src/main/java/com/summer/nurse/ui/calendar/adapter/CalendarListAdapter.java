package com.summer.nurse.ui.calendar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.base.ui.adapter.AppRecycleAdapter;
import com.summer.base.ui.interf.view.OnAppItemClickListener;
import com.summer.nurse.ui.calendar.bean.netbean.DayBean;
import com.summer.nurse.ui.calendar.bean.uibean.CanlendarUIBean;
import com.summer.util.BitmapUtil;
import com.summer.util.ScreenUtil;
import com.summer.util.StringUtil;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-01-23.
 */

public class CalendarListAdapter extends AppRecycleAdapter {

    List<DayBean> data;

    OnAppItemClickListener onAppItemClickListener;


    public CalendarListAdapter(Context context, List<DayBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_calendar, parent, false);
        CanlendarUIBean canlendarUIBean = new CanlendarUIBean(context, view);
        return canlendarUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CanlendarUIBean canlendarUIBean = (CanlendarUIBean) holder;
        ((CanlendarUIBean) holder).getTxtTV().setText(StringUtil.getStr(data.get(position).getContent()));
        if (data.get(position).getImage() == null) {

        } else {
            BitmapUtil.getInstance().setFitBg(context, ScreenUtil.w, canlendarUIBean.getImageIV(), data.get(position).getImage().getFileUrl());
        }
        canlendarUIBean.getRootV().setTag(R.id.position, position);
        canlendarUIBean.getRootV().setTag(R.id.data, data.get(position));
        canlendarUIBean.getRootV().setOnClickListener(this);
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
}
