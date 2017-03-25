package com.summer.app.ui.bed.assaydetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.bed.assay.ope.AssayDAOpe;
import com.summer.app.ui.bed.assaydetail.bean.uibean.AssayDetailUIBean;
import com.summer.lib.base.ui.adapter.AppRecycleAdapter;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.util.StringUtil;
import com.summer.app.ui.bed.assay.bean.resbean.AssayListResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayDetailAdapter extends AppRecycleAdapter {

    ArrayList<AssayListResBean.AssayDataBean> data;

    OnAppItemClickListener onAppItemClickListener;

    AssayDAOpe assayDAOpe;


    public AssayDetailAdapter(Context context, ArrayList<AssayListResBean.AssayDataBean> data) {
        super(context);
        this.data = data;
        assayDAOpe = new AssayDAOpe(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_assaydetail, parent, false);
        AssayDetailUIBean assayUIBean = new AssayDetailUIBean(context, view);
        return assayUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AssayDetailUIBean assayUIBean = (AssayDetailUIBean) holder;
        assayUIBean.getRootV().setTag(R.id.position, position);
        assayUIBean.getNameTV().setText(StringUtil.getStr(data.get(position).getItemname()));
        assayUIBean.getValueTV().setText(StringUtil.getStr(data.get(position).getResult()));
        assayUIBean.getAreaTV().setText(StringUtil.getStr(data.get(position).getReferencerange()));
        assayUIBean.getUpdownIV().setVisibility(View.INVISIBLE);
        switch (assayDAOpe.isHigH(StringUtil.getStr(data.get(position).getHighlowflag()))) {
            case AssayDAOpe.HIGH:
                assayUIBean.getUpdownIV().setVisibility(View.VISIBLE);
                assayUIBean.getUpdownIV().setSelected(false);
                break;
            case AssayDAOpe.LOW:
                assayUIBean.getUpdownIV().setVisibility(View.VISIBLE);
                assayUIBean.getUpdownIV().setSelected(true);
                break;
            case AssayDAOpe.NORMAL:
                assayUIBean.getUpdownIV().setVisibility(View.INVISIBLE);
                break;
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
        int p = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, p);
        }
    }
}
