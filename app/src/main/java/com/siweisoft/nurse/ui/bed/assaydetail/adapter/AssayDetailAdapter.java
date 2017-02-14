package com.siweisoft.nurse.ui.bed.assaydetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.nurse.ui.bed.assay.bean.adapterbean.AssayAdapterBean;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayResBean;
import com.siweisoft.nurse.ui.bed.assay.bean.uibean.AssayUIBean;
import com.siweisoft.nurse.ui.bed.assaydetail.bean.uibean.AssayDetailUIBean;
import com.siweisoft.util.StringUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayDetailAdapter extends AppRecycleAdapter{

    ArrayList<AssayResBean>  data;

    OnAppItemClickListener onAppItemClickListener;


    public AssayDetailAdapter(Context context, ArrayList<AssayResBean>  data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_assaydetail,parent,false);
        AssayDetailUIBean assayUIBean = new AssayDetailUIBean(context,view);
        return assayUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AssayDetailUIBean assayUIBean = (AssayDetailUIBean) holder;
        assayUIBean.getRootV().setTag(R.id.position,position);
        assayUIBean.getNameTV().setText(StringUtil.getStr(data.get(position).getItemname()));
        assayUIBean.getValueTV().setText(StringUtil.getStr(data.get(position).getResult()));
        assayUIBean.getAreaTV().setText(StringUtil.getStr(data.get(position).getReferencerange()));

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
}
