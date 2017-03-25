package com.summer.app.ui.bed.shiftdute.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class ShiftDuteUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_content)
    TextView contentTV;

    public ShiftDuteUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getContentTV() {
        return contentTV;
    }

    public void setContentTV(TextView contentTV) {
        this.contentTV = contentTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public void setNameTV(TextView nameTV) {
        this.nameTV = nameTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public void setTimeTV(TextView timeTV) {
        this.timeTV = timeTV;
    }
}
