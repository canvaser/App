package com.siweisoft.ui.check.patientcheck.bean;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-08.
 */

public class PatientCheckUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_taskname)
    TextView taskNameTV;

    @BindView(R.id.tv_check)
    TextView checkIV;

    @BindView(R.id.iv_gou)
    ImageView gouIV;

    public PatientCheckUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public TextView getTaskNameTV() {
        return taskNameTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public TextView getCheckIV() {
        return checkIV;
    }

    public ImageView getGouIV() {
        return gouIV;
    }
}
