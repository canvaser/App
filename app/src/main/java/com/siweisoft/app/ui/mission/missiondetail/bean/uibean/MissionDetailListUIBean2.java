package com.siweisoft.app.ui.mission.missiondetail.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MissionDetailListUIBean2 extends BaseUIBean {

    @BindView(R.id.tv_title)
    TextView titleTV;


    @BindView(R.id.tv_name)
    TextView nameView;

    @BindView(R.id.tv_press)
    TextView pressView;

    @BindView(R.id.ll_content)
    View cotainV;

    @BindView(R.id.iv_status)
    ImageView statusIV;


    public MissionDetailListUIBean2(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNameView() {
        return nameView;
    }

    public TextView getPressView() {
        return pressView;
    }

    public TextView getTitleTV() {
        return titleTV;
    }

    public View getCotainV() {
        return cotainV;
    }

    public ImageView getStatusIV() {
        return statusIV;
    }
}
