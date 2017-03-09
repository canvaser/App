package com.siweisoft.app.ui.mission.missiondetail.bean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MissionDetailListUIBean extends BaseUIBean {

    @BindView(R.id.tv_txt)
    TextView txtTV;


    @BindView(R.id.ll_menu)
    View menuView;

    @BindView(R.id.rl_done)
    View doneView;


    @BindView(R.id.rl_absent)
    View absentView;


    @BindView(R.id.rl_refuse)
    View refuseView;


    @BindView(R.id.rl_delete)
    View deleteView;

    public MissionDetailListUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getTxtTV() {
        return txtTV;
    }

    public View getAbsentView() {
        return absentView;
    }

    public View getDeleteView() {
        return deleteView;
    }

    public View getDoneView() {
        return doneView;
    }

    public View getMenuView() {
        return menuView;
    }

    public View getRefuseView() {
        return refuseView;
    }
}
