package com.siweisoft.nurse.ui.day.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.nurse.ui.day.bean.dbbean.DayDBBean;
import com.siweisoft.nurse.ui.day.bean.uibean.LeftDayUIBean;
import com.siweisoft.util.data.FormatUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-01-03.
 */

public class LeftDayAdapter extends AppRecycleAdapter implements View.OnLongClickListener {


    ArrayList<DayDBBean> data;

    OnAppItemLongClickListener longClickListener;

    public LeftDayAdapter(Context context, ArrayList<DayDBBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.list_left_day, parent, false);
        LeftDayUIBean uiBean = new LeftDayUIBean(context, v);
        return uiBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LeftDayUIBean uiBean = (LeftDayUIBean) holder;
        uiBean.getTimeTV().setText(FormatUtil.getInstance().toNowHHMMTime(data.get(position).getStartTime()) + "--" + FormatUtil.getInstance().toNowHHMMTime(data.get(position).getEndTime()));
        uiBean.getContentTV().setText(data.get(position).getContentTxt() + "");
        uiBean.getRootV().setOnLongClickListener(this);
        uiBean.getRootV().setTag(R.id.position, position);
        uiBean.getRootV().setTag(R.id.data, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

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
