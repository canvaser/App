package com.summer.app.ui.mission.missionlist.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class MissionHeadUIBean extends BaseUIBean {


    @BindView(R.id.tv_starttime)
    TextView startTimeTV;

    @BindView(R.id.tv_endtime)
    TextView endTimeTV;


    @BindView(R.id.tv_title)
    TextView titleTV;

    public MissionHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getEndTimeTV() {
        return endTimeTV;
    }

    public TextView getStartTimeTV() {
        return startTimeTV;
    }

    public TextView getTitleTV() {
        return titleTV;
    }
}
