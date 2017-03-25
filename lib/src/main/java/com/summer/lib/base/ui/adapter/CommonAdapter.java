package com.summer.lib.base.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.lib.R;
import com.summer.lib.bean.uibean.CommonUIBean;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;

import java.util.ArrayList;


/**
 * Created by ${viwmox} on 2017-02-27.
 */

public class CommonAdapter<A> extends RecyclerView.Adapter<CommonUIBean> implements View.OnClickListener {

    protected ArrayList<A> data;

    protected Context context;

    protected LayoutInflater inflater;

    protected int layoutId;

    protected OnAppItemClickListener onAppItemClickListener;

    public CommonAdapter(Context context, int layoutId, ArrayList<A> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.layoutId = layoutId;
    }


    @Override
    public CommonUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonUIBean.createViewHolder(context, parent, layoutId);
    }

    @Override
    public void onBindViewHolder(CommonUIBean holder, int position) {
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(R.id.position, position);
        holder.itemView.setTag(R.id.data, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    /**
     * do not super
     */
    @Override
    public void onClick(View v) {
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, (Integer) v.getTag(R.id.position));
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    public ArrayList<A> getData() {
        return data;
    }
}
