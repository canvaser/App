package com.siweisoft.nurse.ui.bed.additionlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.nurse.ui.bed.additionlist.bean.uibean.AdditonUIBean;
import com.siweisoft.nurse.ui.home.bean.resbean.AdditionResbean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditionListAdapter extends AppRecycleAdapter {

    ArrayList<AdditionResbean> data;

    OnAppItemClickListener onAppItemClickListener;

    public AdditionListAdapter(Context context,ArrayList<AdditionResbean> data) {
        super(context);
        this.data =data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_addition,parent,false);
        AdditonUIBean additonUIBean = new AdditonUIBean(context,view);
        return additonUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdditonUIBean additonUIBean= (AdditonUIBean) holder;
        additonUIBean.getTxtTV().setText(data.get(position).getName());
        additonUIBean.getGouIV().setSelected(data.get(position).isSelect());
        additonUIBean.getRootV().setOnClickListener(this);
        additonUIBean.getRootV().setTag(R.id.position,position);
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if(onAppItemClickListener!=null){
            onAppItemClickListener.onAppItemClick(v,p);
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    public ArrayList<AdditionResbean> getData() {
        return data;
    }
}
