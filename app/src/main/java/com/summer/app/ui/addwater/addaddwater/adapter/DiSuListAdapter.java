package com.summer.app.ui.addwater.addaddwater.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.addwater.addaddwater.bean.dabean.DishuDABean;
import com.summer.app.ui.addwater.addaddwater.bean.uibean.DiSuUIBean;
import com.summer.lib.base.ui.adapter.AppRecycleAdapter;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-03-17.
 */

public class DiSuListAdapter extends AppRecycleAdapter<DiSuUIBean> {

    ArrayList<DishuDABean> data;

    public DiSuListAdapter(Context context, ArrayList<DishuDABean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public DiSuUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiSuUIBean(context, parent, R.layout.list_disu);
    }

    @Override
    public void onBindViewHolder(DiSuUIBean holder, int position) {
        int p = position + 1;
        holder.getTimeTV().setText("第" + data.get(p).getDisu() + "滴用时：" + data.get(p).getTime() + "s");
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() <= 1 ? 0 : data.size() - 1;
    }

    @Override
    public void onClick(View v) {

    }
}
