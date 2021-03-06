package com.summer.app.ui.bed.shiftdute.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;
import com.summer.app.ui.bed.shiftdute.bean.uibean.ShiftDuteUIBean;
import com.summer.lib.base.ui.adapter.AppRecycleAdapter;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class ShiftDuteListAdpter extends AppRecycleAdapter {

    private ArrayList<ShiftDuteResBean> data;

    OnAppItemClickListener onAppItemClickListener;

    public ShiftDuteListAdpter(Context context, ArrayList<ShiftDuteResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_shiftdute, parent, false);
        ShiftDuteUIBean shiftDuteUIBean = new ShiftDuteUIBean(context, view);
        return shiftDuteUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShiftDuteUIBean shiftDuteUIBean = (ShiftDuteUIBean) holder;
        shiftDuteUIBean.getTimeTV().setText("时间： " + data.get(position).getCreate_time());
        shiftDuteUIBean.getNameTV().setText("护士:  " + data.get(position).getDisplayname());
        shiftDuteUIBean.getContentTV().setText(data.get(position).get内容());
        shiftDuteUIBean.getRootV().setOnClickListener(this);
        shiftDuteUIBean.getRootV().setTag(R.id.position, position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, p);
        }
    }

    public void setData(ArrayList<ShiftDuteResBean> data) {
        this.data = data;
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }
}
