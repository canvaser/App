package com.siweisoft.nurse.ui.info.workdetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;
import com.siweisoft.nurse.ui.info.workdetail.bean.uibean.WorkDetailUIBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailsListAdapter extends AppRecycleAdapter {


    WorkDetailAdapterBean data;

    public WorkDetailsListAdapter(Context context,WorkDetailAdapterBean data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_workdetails,parent,false);
        WorkDetailUIBean workDetailUIBean = new WorkDetailUIBean(context,view);
        return workDetailUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WorkDetailUIBean workDetailUIBean = (WorkDetailUIBean) holder;
        workDetailUIBean.getDateTV().setText(StringUtil.getStr(data.getList().get(position).getTaskname()));
        workDetailUIBean.getNumTV().setText(StringUtil.getStr(data.getList().get(position).get次数()));
        workDetailUIBean.getWorksTV().setText(StringUtil.getStr(data.getList().get(position).getWorkload()));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.getList().size();
    }

    @Override
    public void onClick(View v) {

    }
}
