package com.siweisoft.nurse.ui.bed.MyMission.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class MyMissionHeadUIBean extends BaseUIBean {

    @BindView(R.id.tv_title)
    TextView titleTV;

    @BindView(R.id.tv_num)
    TextView numTV;

    public MyMissionHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNumTV() {
        return numTV;
    }

    public TextView getTitleTV() {
        return titleTV;
    }
}
