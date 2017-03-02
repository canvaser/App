package com.siweisoft.nurse.ui.setting.backsetting.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.nurse.ui.setting.setting.bean.dbbean.BackUIDBBean;
import com.siweisoft.nurse.ui.setting.setting.bean.uibean.BackUIUIBean;
import com.siweisoft.util.StringUtil;

import java.util.ArrayList;

/**
 * Created by summer on 2016/12/31 14:14.
 */

public class Backsettingadapter extends AppRecycleAdapter {


    ArrayList<BackUIDBBean> data;

    OnAppItemClickListener itemClickListener;

    public Backsettingadapter(Context context, ArrayList<BackUIDBBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_backsetting, parent, false);
        BackUIUIBean backUIUIBean = new BackUIUIBean(context, view);
        return backUIUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BackUIUIBean backUIUIBean = (BackUIUIBean) holder;
        backUIUIBean.getFragNameTV().setText(StringUtil.getStr(data.get(position).getFragName()));
        backUIUIBean.getRootV().setOnClickListener(this);
        backUIUIBean.getRootV().setTag(R.id.position, position);
        backUIUIBean.getRootV().setTag(R.id.data, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            int p = (int) v.getTag(R.id.position);
            itemClickListener.onAppItemClick(v, p);
        }
    }

    public ArrayList<BackUIDBBean> getData() {
        return data;
    }

    public void setItemClickListener(OnAppItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
