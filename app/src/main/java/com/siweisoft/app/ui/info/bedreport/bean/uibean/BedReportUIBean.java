package com.siweisoft.app.ui.info.bedreport.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_old)
    TextView oldTV;

    @BindView(R.id.tv_now)
    TextView newTV;

    @BindView(R.id.tv_num)
    TextView numTV;

    public BedReportUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNewTV() {
        return newTV;
    }

    public void setNewTV(TextView newTV) {
        this.newTV = newTV;
    }

    public TextView getNumTV() {
        return numTV;
    }

    public void setNumTV(TextView numTV) {
        this.numTV = numTV;
    }

    public TextView getOldTV() {
        return oldTV;
    }

    public void setOldTV(TextView oldTV) {
        this.oldTV = oldTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public void setTimeTV(TextView timeTV) {
        this.timeTV = timeTV;
    }
}
