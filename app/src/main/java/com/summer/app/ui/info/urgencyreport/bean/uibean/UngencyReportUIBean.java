package com.summer.app.ui.info.urgencyreport.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UngencyReportUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_numname)
    TextView numnameTV;

    @BindView(R.id.tv_level)
    TextView levelTV;

    @BindView(R.id.tv_status)
    TextView statusTV;

    @BindView(R.id.tv_detail)
    TextView detailTV;


    public UngencyReportUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getDetailTV() {
        return detailTV;
    }

    public TextView getLevelTV() {
        return levelTV;
    }

    public TextView getNumnameTV() {
        return numnameTV;
    }

    public TextView getStatusTV() {
        return statusTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }
}
