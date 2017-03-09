package com.siweisoft.app.ui.info.bedreport.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.app.ui.info.bedreport.bean.resbean.BedReportResBean;
import com.siweisoft.app.ui.info.bedreport.bean.uibean.BedReportUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportListAdapter extends AppRecycleAdapter {


    ArrayList<BedReportResBean> data;

    public BedReportListAdapter(Context context, ArrayList<BedReportResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_bedreport, parent, false);
        BedReportUIBean bedReportUIBean = new BedReportUIBean(context, view);
        return bedReportUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BedReportUIBean bedReportUIBean = (BedReportUIBean) holder;
        bedReportUIBean.getNumTV().setText(StringUtil.getStr(data.get(position).getBednum()));
        bedReportUIBean.getTimeTV().setText(StringUtil.getStr(data.get(position).getDate()));
        bedReportUIBean.getOldTV().setText(StringUtil.getStr(data.get(position).getOld()));
        bedReportUIBean.getNewTV().setText(StringUtil.getStr(data.get(position).getNeww()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
