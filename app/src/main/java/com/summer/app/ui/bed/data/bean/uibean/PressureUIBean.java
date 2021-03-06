package com.summer.app.ui.bed.data.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class PressureUIBean extends BaseUIBean {

    @BindView(R.id.tv_head_pressure)
    TextView headTV;

    @BindView(R.id.ll_content)
    View contentView;

    public PressureUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getHeadTV() {
        return headTV;
    }

    public View getContentView() {
        return contentView;
    }
}
