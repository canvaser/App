package com.siweisoft.nurse.ui.image.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;


/**
 * Created by ${viwmox} on 2016-08-01.
 */
public class ImageUIBean extends BaseUIBean {

    @BindView(R.id.iv_pic)
    ImageView imageView;

    @BindView(R.id.iv_check)
    ImageView checkIV;

    public ImageUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public ImageView getCheckIV() {
        return checkIV;
    }
}
