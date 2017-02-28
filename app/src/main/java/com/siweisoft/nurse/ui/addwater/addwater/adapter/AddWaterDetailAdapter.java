package com.siweisoft.nurse.ui.addwater.addwater.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.nurse.ui.addwater.addwater.bean.uibean.AddWaterDetailUIBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterDetailAdapter extends AppRecycleAdapter<AddWaterDetailUIBean> {

    List<AddWaterListResBean.DataBean.FilesBean> data;

    public AddWaterDetailAdapter(Context context, List<AddWaterListResBean.DataBean.FilesBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public AddWaterDetailUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        AddWaterDetailUIBean uiBean = new AddWaterDetailUIBean(context, parent, R.layout.list_item_addwater_detail);
        return uiBean;
    }

    @Override
    public void onBindViewHolder(AddWaterDetailUIBean holder, int position) {
        holder.getNameTV().setText(StringUtil.getStr(data.get(position).getTermname()));
        holder.getValueTV().setText(StringUtil.getStr(data.get(position).getValue()) + StringUtil.getStr(data.get(position).getSuffix()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
