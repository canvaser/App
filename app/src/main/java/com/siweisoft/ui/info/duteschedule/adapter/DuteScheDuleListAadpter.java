package com.siweisoft.ui.info.duteschedule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.ui.info.duteschedule.bean.resbean.DuteScheDuleResBean;
import com.siweisoft.ui.info.duteschedule.bean.uibean.DuteScheDuleUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleListAadpter extends AppRecycleAdapter {


    private ArrayList<DuteScheDuleResBean> data;


    public DuteScheDuleListAadpter(Context context, ArrayList<DuteScheDuleResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_duteschedule, parent, false);
        DuteScheDuleUIBean duteScheDuleUIBean = new DuteScheDuleUIBean(context, view);
        return duteScheDuleUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DuteScheDuleUIBean duteScheDuleUIBean = (DuteScheDuleUIBean) holder;
        duteScheDuleUIBean.getTimeTV().setText(data.get(position).getDayofweek());
        duteScheDuleUIBean.getTxtTV().setText(data.get(position).getShiftname());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
