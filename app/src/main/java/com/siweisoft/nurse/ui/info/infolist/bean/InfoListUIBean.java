package com.siweisoft.nurse.ui.info.infolist.bean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class InfoListUIBean extends BaseUIBean{


    @BindView(R.id.iv_icon)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView titleView;

    public InfoListUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTitleView() {
        return titleView;
    }
}
