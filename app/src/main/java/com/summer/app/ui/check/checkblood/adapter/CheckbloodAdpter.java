package com.summer.app.ui.check.checkblood.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.check.checkblood.bean.CheckBloodListUIBean;
import com.summer.app.ui.check.checkblood.bean.CheckPatAndPipeResBean;
import com.summer.lib.base.ui.adapter.AppRecycleAdapter;
import com.summer.lib.util.StringUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-03-15.
 */

public class CheckbloodAdpter extends AppRecycleAdapter<CheckBloodListUIBean> {


    ArrayList<CheckPatAndPipeResBean> data;

    public CheckbloodAdpter(Context context, ArrayList<CheckPatAndPipeResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public CheckBloodListUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CheckBloodListUIBean(context, parent, R.layout.list_checkblood);
    }

    @Override
    public void onBindViewHolder(CheckBloodListUIBean holder, int position) {
        holder.getTvMsg().setText(StringUtil.getStr(data.get(position).getData().getResMsg()));
        holder.getTvCode().setText("当前扫描试管条形码: " + StringUtil.getStr(data.get(position).getData().getCode()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
