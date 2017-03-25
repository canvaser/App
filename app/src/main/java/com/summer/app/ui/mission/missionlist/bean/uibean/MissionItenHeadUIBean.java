package com.summer.app.ui.mission.missionlist.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;
import com.summer.lib.util.ToastUtil;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class MissionItenHeadUIBean extends BaseUIBean {


    @BindView(R.id.tv_all)
    TextView allTV;

    @BindView(R.id.tv_lin)
    TextView linTV;


    @BindView(R.id.tv_long)
    TextView longTV;

    @BindView(R.id.ll_all)
    View allV;

    @BindView(R.id.ll_lin)
    View linV;

    @BindView(R.id.ll_long)
    View longV;

    TextView[] textViews = new TextView[]{allTV, linTV, longTV};

    public MissionItenHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getAllTV() {
        return allTV;
    }

    public TextView getLinTV() {
        return linTV;
    }

    public TextView getLongTV() {
        return longTV;
    }

    public View getAllV() {
        return allV;
    }

    public View getLinV() {
        return linV;
    }

    public View getLongV() {
        return longV;
    }

    public void select(int index) {
        for (int i = 0; i < textViews.length; i++) {
            if (i == index) {
                textViews[i].setSelected(true);
            } else {
                textViews[i].setSelected(false);
            }
        }
    }

    public void setOnClick(View.OnClickListener onClick) {
        getAllV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.getInstance().show(context, "3232323232");
            }
        });
        getLinV().setOnClickListener(onClick);
        getLongV().setOnClickListener(onClick);
    }
}
