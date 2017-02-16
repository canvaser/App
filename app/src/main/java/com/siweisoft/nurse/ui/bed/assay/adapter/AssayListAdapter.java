package com.siweisoft.nurse.ui.bed.assay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.bed.assay.bean.adapterbean.AssayAdapterBean;
import com.siweisoft.nurse.ui.bed.assay.bean.uibean.AssayUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayListAdapter extends AppRecycleAdapter {

    ArrayList<AssayAdapterBean> data;

    OnAppItemClickListener onAppItemClickListener;


    public AssayListAdapter(Context context,ArrayList<AssayAdapterBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_assay,parent,false);
        AssayUIBean assayUIBean = new AssayUIBean(context,view);
        return assayUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AssayUIBean assayUIBean = (AssayUIBean) holder;
        assayUIBean.getRootV().setTag(R.id.position,position);
        assayUIBean.getRootV().setOnClickListener(this);
        assayUIBean.getTimeTV().setText(StringUtil.getStr(data.get(position).getTime()));
        assayUIBean.getTitleTV().setText(StringUtil.getStr(data.get(position).getTitle()));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if(onAppItemClickListener!=null){
            onAppItemClickListener.onAppItemClick(v,p);
        }
    }

    public ArrayList<AssayAdapterBean> getData() {
        return data;
    }
}
