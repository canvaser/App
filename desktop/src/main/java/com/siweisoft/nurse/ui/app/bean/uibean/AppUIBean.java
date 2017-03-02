package com.siweisoft.nurse.ui.app.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.util.ScreenUtil;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

public class AppUIBean extends BaseUIBean {

    @BindView(R.id.tv_app)
    TextView appTV;

    @BindView(R.id.iv_icon)
    ImageView appIV;

    @BindView(R.id.rl_iv)
    RelativeLayout imageRL;


    public AppUIBean(Context context, View convertView) {
        super(context, convertView);
        imageRL.getLayoutParams().width = (int) (ScreenUtil.w / 5) - ValueConstant.DIMEN_1 * 4;
        imageRL.getLayoutParams().height = (int) (ScreenUtil.w / 5) - ValueConstant.DIMEN_1 * 4;
        imageRL.requestLayout();
    }

    public TextView getAppTV() {
        return appTV;
    }

    public ImageView getAppIV() {
        return appIV;
    }

    public RelativeLayout getImageRL() {
        return imageRL;
    }
}
