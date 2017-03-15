package com.siweisoft.app.ui.info.bedcheck.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.info.bedcheck.bean.resbean.BedCheckResBean;
import com.siweisoft.app.ui.info.bedcheck.bean.uibean.BedCheckUIBean;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class BedCheckListAdapter extends AppRecycleAdapter {

    ArrayList<BedCheckResBean> data;

    public BedCheckListAdapter(Context context, ArrayList<BedCheckResBean> data) {
        super(context);
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BedCheckUIBean bedCheckUIBean = null;
        View view = layoutInflater.inflate(R.layout.list_bedcheck, parent, false);
        bedCheckUIBean = new BedCheckUIBean(context, view);
        return bedCheckUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BedCheckUIBean bedCheckUIBean = (BedCheckUIBean) holder;
        bedCheckUIBean.getDateTV().setText(StringUtil.getStr(DateFormatUtil.getMMDDHHMM(data.get(position).getTimestamp())));
        bedCheckUIBean.getAreaTV().setText(StringUtil.getStr(data.get(position).getRegion()));
        bedCheckUIBean.getRoomTV().setText(StringUtil.getStr(data.get(position).getRoom()));
        bedCheckUIBean.getNameTV().setText(StringUtil.getStr(data.get(position).getDisplayname()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
