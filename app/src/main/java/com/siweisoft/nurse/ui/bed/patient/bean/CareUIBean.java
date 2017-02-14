package com.siweisoft.nurse.ui.bed.patient.bean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class CareUIBean extends BaseUIBean{

    @BindView(R.id.tv_name)
    TextView nameTV;


    @BindView(R.id.iv_icon)
    ImageView iconIV;

    public CareUIBean(Context context, View convertView) {
        super(context, convertView);
    }


    public ImageView getIconIV() {
        return iconIV;
    }

    public TextView getNameTV() {
        return nameTV;
    }
}
