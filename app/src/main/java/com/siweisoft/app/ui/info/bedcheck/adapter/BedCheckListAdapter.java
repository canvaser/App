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
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BedCheckUIBean bedCheckUIBean = null;
        switch (viewType) {
            case 0:
                View view0 = layoutInflater.inflate(R.layout.item_head_bedcheck, parent, false);
                bedCheckUIBean = new BedCheckUIBean(context, view0);
                break;
            case 1:
                View view = layoutInflater.inflate(R.layout.list_bedcheck, parent, false);
                bedCheckUIBean = new BedCheckUIBean(context, view);
                break;
        }
        return bedCheckUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                break;
            case 1:
                position = position - 1;
                BedCheckUIBean bedCheckUIBean = (BedCheckUIBean) holder;
                bedCheckUIBean.getDateTV().setText(StringUtil.getStr(DateFormatUtil.getMMDDHHMM(data.get(position).getTimestamp())));
                bedCheckUIBean.getAreaTV().setText(StringUtil.getStr(data.get(position).getRegion()));
                bedCheckUIBean.getRoomTV().setText(StringUtil.getStr(data.get(position).getRoom()));
                bedCheckUIBean.getNameTV().setText(StringUtil.getStr(data.get(position).getDisplayname()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 1 : data.size() + 1;
    }

    @Override
    public void onClick(View v) {

    }
}
