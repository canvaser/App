package com.siweisoft.nurse.ui.bed.nurserecord.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_type)
    TextView typeTV;

    @BindView(R.id.tv_num)
    TextView numTV;

    public NurseRecordUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNumTV() {
        return numTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public TextView getTypeTV() {
        return typeTV;
    }
}
