package com.siweisoft.nurse.ui.info.urgencyreport.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.nurse.ui.info.infolist.bean.InfoListUIBean;
import com.siweisoft.nurse.ui.info.urgencyreport.bean.resbean.UrgencyReportResBean;
import com.siweisoft.nurse.ui.info.urgencyreport.bean.uibean.UngencyReportUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class UngencyReportListAdapter extends AppRecycleAdapter {


    OnAppItemClickListener onAppItemClickListener;

    ArrayList<UrgencyReportResBean> data;


    public UngencyReportListAdapter(Context context, ArrayList<UrgencyReportResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_urgencyreport, parent, false);
        UngencyReportUIBean uiBean = new UngencyReportUIBean(context, view);
        return uiBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UngencyReportUIBean uiBean = (UngencyReportUIBean) holder;
        uiBean.getRootV().setTag(R.id.position, position);
        uiBean.getRootV().setOnClickListener(this);
        uiBean.getTimeTV().setText(data.get(position).getCreate_time());
        uiBean.getDetailTV().setText("详情:" + data.get(position).getContent());
        uiBean.getLevelTV().setText("等级:" + data.get(position).getLevel());
        uiBean.getNumnameTV().setText(data.get(position).getPatname());
        uiBean.getStatusTV().setText(data.get(position).getUpdate_value());
        if (data.get(position).getUpdate_value().equals("0")) {
            uiBean.getStatusTV().setText("状态:未取消");
            uiBean.getRootV().setBackgroundColor(Color.parseColor("#FFA07A"));
        } else {
            uiBean.getStatusTV().setText("状态:已取消");
            uiBean.getRootV().setBackgroundColor(Color.parseColor("#E0FFFF"));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, p);
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }
}
