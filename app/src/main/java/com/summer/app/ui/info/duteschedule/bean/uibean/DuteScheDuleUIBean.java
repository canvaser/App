package com.summer.app.ui.info.duteschedule.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;


    @BindView(R.id.tv_txt)
    TextView txtTV;

    public DuteScheDuleUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public void setTimeTV(TextView timeTV) {
        this.timeTV = timeTV;
    }

    public TextView getTxtTV() {
        return txtTV;
    }

    public void setTxtTV(TextView txtTV) {
        this.txtTV = txtTV;
    }
}
