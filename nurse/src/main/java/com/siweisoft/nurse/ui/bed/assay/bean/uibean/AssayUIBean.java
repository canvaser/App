package com.siweisoft.nurse.ui.bed.assay.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayUIBean extends BaseUIBean {

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.tv_title)
    TextView titleTV;

    @BindView(R.id.iv_select)
    ImageView selectIV;

    public AssayUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public ImageView getSelectIV() {
        return selectIV;
    }

    public void setSelectIV(ImageView selectIV) {
        this.selectIV = selectIV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public void setTimeTV(TextView timeTV) {
        this.timeTV = timeTV;
    }

    public TextView getTitleTV() {
        return titleTV;
    }

    public void setTitleTV(TextView titleTV) {
        this.titleTV = titleTV;
    }
}
