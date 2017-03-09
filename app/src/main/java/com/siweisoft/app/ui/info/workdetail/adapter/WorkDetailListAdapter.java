package com.siweisoft.app.ui.info.workdetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.app.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;
import com.siweisoft.app.ui.info.workdetail.bean.uibean.WorkDetailUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailListAdapter extends AppRecycleAdapter {


    private ArrayList<WorkDetailAdapterBean> data;

    OnAppItemClickListener onAppItemClickListener;

    public WorkDetailListAdapter(Context context, ArrayList<WorkDetailAdapterBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_workdetail, parent, false);
        WorkDetailUIBean workDetailUIBean = new WorkDetailUIBean(context, view);
        return workDetailUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WorkDetailUIBean workDetailUIBean = (WorkDetailUIBean) holder;
        workDetailUIBean.getDateTV().setText(data.get(position).getDate());
        workDetailUIBean.getNumTV().setText(data.get(position).getNum());
        workDetailUIBean.getWorksTV().setText(data.get(position).getWorks());
        workDetailUIBean.getRootV().setOnClickListener(this);
        workDetailUIBean.getRootV().setTag(R.id.position, position);
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

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    public ArrayList<WorkDetailAdapterBean> getData() {
        return data;
    }
}
