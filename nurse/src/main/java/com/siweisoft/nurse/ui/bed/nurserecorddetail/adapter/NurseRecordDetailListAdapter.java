package com.siweisoft.nurse.ui.bed.nurserecorddetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.bean.uibean.NurseRecordDetailUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class NurseRecordDetailListAdapter extends AppRecycleAdapter {


    ArrayList<NurseRecordResBean> data;

    public NurseRecordDetailListAdapter(Context context, ArrayList<NurseRecordResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_nurserecorddetail, parent, false);
        NurseRecordDetailUIBean uiBean = new NurseRecordDetailUIBean(context, view);
        return uiBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NurseRecordDetailUIBean uiBean = (NurseRecordDetailUIBean) holder;
        uiBean.getTimeTV().setText(data.get(position).getExecdate());
        uiBean.getTxtTV().setText(data.get(position).get医嘱详情());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
