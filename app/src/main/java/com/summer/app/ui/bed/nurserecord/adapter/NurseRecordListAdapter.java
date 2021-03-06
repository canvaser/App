package com.summer.app.ui.bed.nurserecord.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;
import com.summer.app.ui.bed.nurserecord.bean.uibean.NurseRecordUIBean;
import com.summer.lib.base.ui.adapter.AppRecycleAdapter;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.util.StringUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordListAdapter extends AppRecycleAdapter {

    ArrayList<NurseRecordResBean> data;

    OnAppItemClickListener onAppItemClickListener;


    public NurseRecordListAdapter(Context context, ArrayList<NurseRecordResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_nurserecord, parent, false);
        NurseRecordUIBean nurseRecordUIBean = new NurseRecordUIBean(context, view);
        return nurseRecordUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NurseRecordUIBean nurseRecordUIBean = (NurseRecordUIBean) holder;
        nurseRecordUIBean.getRootV().setTag(R.id.position, position);
        nurseRecordUIBean.getRootV().setOnClickListener(this);
        nurseRecordUIBean.getTimeTV().setText(StringUtil.getStr(data.get(position).getExecdate()));
        nurseRecordUIBean.getTypeTV().setText(StringUtil.getStr(data.get(position).get医嘱类别名称()));
        nurseRecordUIBean.getNumTV().setText(StringUtil.getStr(data.get(position).get次数()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, p);
        }
    }

    public ArrayList<NurseRecordResBean> getData() {
        return data;
    }
}
