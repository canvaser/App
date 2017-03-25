package com.summer.nurse.ui.day.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-03.
 */

public class LeftDayUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_content)
    TextView contentTV;

    public LeftDayUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getContentTV() {
        return contentTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }
}
