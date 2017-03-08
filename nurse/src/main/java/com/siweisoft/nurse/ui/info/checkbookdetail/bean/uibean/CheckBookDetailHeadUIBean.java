package com.siweisoft.nurse.ui.info.checkbookdetail.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class CheckBookDetailHeadUIBean extends BaseUIBean {


    @BindView(R.id.tv_time)
    TextView timeTV;


    @BindView(R.id.tv_dute)
    TextView duteTV;


    @BindView(R.id.tv_name)
    TextView nameTV;

    public CheckBookDetailHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getDuteTV() {
        return duteTV;
    }

    public void setDuteTV(TextView duteTV) {
        this.duteTV = duteTV;
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
