package com.siweisoft.nurse.ui.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppGroupDBBean;
import com.siweisoft.nurse.ui.app.bean.uibean.AppUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppGroupAdapter extends AppRecycleAdapter {

    ArrayList<AppGroupDBBean> data;

    public AppGroupAdapter(Context context, ArrayList<AppGroupDBBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_app, parent, false);
        AppUIBean appUIBean = new AppUIBean(context, view);
        return appUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AppUIBean appUIBean = (AppUIBean) holder;
        appUIBean.getAppIV().setImageResource(R.drawable.icon);
        appUIBean.getAppTV().setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
