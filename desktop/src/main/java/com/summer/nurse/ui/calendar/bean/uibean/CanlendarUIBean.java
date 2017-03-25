package com.summer.nurse.ui.calendar.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-23.
 */

public class CanlendarUIBean extends BaseUIBean {

    @BindView(R.id.tv_txt)
    TextView txtTV;

    @BindView(R.id.iv_image)
    ImageView imageIV;

    public CanlendarUIBean(Context context, View convertView) {
        super(context, convertView);
    }


    public TextView getTxtTV() {
        return txtTV;
    }

    public ImageView getImageIV() {
        return imageIV;
    }
}
