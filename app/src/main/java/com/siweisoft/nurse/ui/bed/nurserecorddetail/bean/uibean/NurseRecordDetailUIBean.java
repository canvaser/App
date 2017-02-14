package com.siweisoft.nurse.ui.bed.nurserecorddetail.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class NurseRecordDetailUIBean extends BaseUIBean{

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_type)
    TextView txtTV;

    public NurseRecordDetailUIBean(Context context, View convertView) {
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
