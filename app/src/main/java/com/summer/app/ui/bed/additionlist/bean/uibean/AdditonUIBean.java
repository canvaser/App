package com.summer.app.ui.bed.additionlist.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditonUIBean extends BaseUIBean {

    @BindView(R.id.tv_txt)
    TextView txtTV;

    @BindView(R.id.iv_gou)
    ImageView gouIV;

    public AdditonUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getTxtTV() {
        return txtTV;
    }

    public ImageView getGouIV() {
        return gouIV;
    }
}
