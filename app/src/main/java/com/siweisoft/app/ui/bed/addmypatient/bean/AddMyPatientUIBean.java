package com.siweisoft.app.ui.bed.addmypatient.bean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.iv_select)
    ImageView selectIV;

    public AddMyPatientUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public ImageView getSelectIV() {
        return selectIV;
    }
}
