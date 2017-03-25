package com.summer.app.ui.mission.missiondetail.bean.uibean;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-21.
 */

public class MissionDetailUnclickUIBean extends BaseUIBean {


    @BindView(R.id.tv_txt)
    TextView tvTxt;
    @BindView(R.id.iv_status)
    ImageView ivStatus;

    public MissionDetailUnclickUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public ImageView getIvStatus() {
        return ivStatus;
    }

    public void setIvStatus(ImageView ivStatus) {
        this.ivStatus = ivStatus;
    }

    public TextView getTvTxt() {
        return tvTxt;
    }

    public void setTvTxt(TextView tvTxt) {
        this.tvTxt = tvTxt;
    }
}
