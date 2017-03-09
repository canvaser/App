package com.siweisoft.ui.bed.bedlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.BitmapUtil;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.ui.bed.bedlist.bean.uibean.BedUIBean;
import com.siweisoft.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.ui.bed.bedlist.ope.BedListDAOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListAdapter extends AppRecycleAdapter {

    OnAppItemClickListener onAppItemClickListener;

    ArrayList<PatientBedResBean> data;

    BedListDAOpe bedListDAOpe;

    public BedListAdapter(Context context, ArrayList<PatientBedResBean> data) {
        super(context);
        this.data = data;
        bedListDAOpe = new BedListDAOpe(context, null);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_bed, parent, false);
        BedUIBean bedUIBean = new BedUIBean(context, view);
        return bedUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BedUIBean bedUIBean = (BedUIBean) holder;
        if (bedListDAOpe.isEmptyBed(data.get(position).get状态())) {
            bedUIBean.getrV().setVisibility(View.INVISIBLE);
            bedUIBean.itemView.setOnClickListener(null);
            bedUIBean.getEmptyTV().setText(StringUtil.getStr(data.get(position).get病床名() + "." + "空床"));
        } else {
            bedUIBean.getNumAndNameTV().setText(StringUtil.getStr(data.get(position).get病床名() + "." + data.get(position).get姓名()));
            bedUIBean.itemView.setTag(R.id.position, position);
            bedUIBean.itemView.setOnClickListener(this);
            bedUIBean.getrV().setVisibility(View.VISIBLE);
            bedUIBean.getEmptyTV().setText("");

            int[] l = bedListDAOpe.getStatus(data.get(position).getAdditionCodes());
            for (int i = 0; i < l.length; i++) {
                bedUIBean.getStatus()[i].setVisibility(l[i]);
            }

            if (data.get(position).getResId() != 0) {
                BitmapUtil.getInstance().setBg(context, bedUIBean.getLevelIV(), data.get(position).getResId());
            }

            if (data.get(position).get性别().equals("男")) {
                BitmapUtil.getInstance().setBg(context, bedUIBean.getSexIV(), R.drawable.icon_sex_man);
            } else {
                BitmapUtil.getInstance().setBg(context, bedUIBean.getSexIV(), R.drawable.icon_sex_woman);
            }

            bedUIBean.getItemV().setSelected(bedListDAOpe.booleanICU(data.get(position).get状态()));
        }
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
        int position = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null && !NullUtil.isStrEmpty(data.get(position).get住院号())) {
            onAppItemClickListener.onAppItemClick(v, position);
        }
    }

    public ArrayList<PatientBedResBean> getData() {
        return data;
    }
}
