package com.siweisoft.nurse.ui.setting.scanlist.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.db.bean.ScanDBBean;
import com.siweisoft.nurse.ui.setting.scanlist.bean.ScanUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-03-06.
 */

public class ScanListAdapter extends AppRecycleAdapter<ScanUIBean> {

    ArrayList<ScanDBBean> scanList;

    public ScanListAdapter(Context context, ArrayList<ScanDBBean> scanList) {
        super(context);
        this.scanList = scanList;
    }

    @Override
    public ScanUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScanUIBean(context, parent, R.layout.list_scan);
    }

    @Override
    public void onBindViewHolder(ScanUIBean holder, int position) {
        holder.getMsgTV().setText(StringUtil.getStr(scanList.get(position).getResult()));
        holder.getTimeTV().setText(StringUtil.getStr(scanList.get(position).getTime()));
    }

    @Override
    public int getItemCount() {
        return scanList.size();
    }

    @Override
    public void onClick(View v) {

    }
}
