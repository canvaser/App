package com.siweisoft.app.ui.bed.assaydetail.bean.uibean;

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
public class AssayDetailUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;


    @BindView(R.id.tv_updown)
    ImageView updownIV;

    @BindView(R.id.tv_value)
    TextView valueTV;


    @BindView(R.id.tv_area)
    TextView areaTV;

    public AssayDetailUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getAreaTV() {
        return areaTV;
    }

    public void setAreaTV(TextView areaTV) {
        this.areaTV = areaTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public void setNameTV(TextView nameTV) {
        this.nameTV = nameTV;
    }


    public TextView getValueTV() {
        return valueTV;
    }

    public void setValueTV(TextView valueTV) {
        this.valueTV = valueTV;
    }

    public ImageView getUpdownIV() {
        return updownIV;
    }

    public void setUpdownIV(ImageView updownIV) {
        this.updownIV = updownIV;
    }
}
