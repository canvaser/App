package com.siweisoft.nurse.ui.bed.persontask.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class MyMissionUIBean extends BaseUIBean {

    @BindView(R.id.tv_title)
    TextView titleView;


    @BindView(R.id.lin)
    TextView linTV;

    @BindView(R.id.tv_taskname)
    TextView taskNameTV;

    @Nullable
    @BindView(R.id.tv_badid)
    TextView badIdTV;

    @Nullable
    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.iv_codename)
    ImageView codenameIV;

    @BindView(R.id.iv_arrow)
    ImageView arrowIV;

    @BindView(R.id.tv_tasktype)
    TextView typeTV;


    public MyMissionUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    @Nullable
    public TextView getBadIdTV() {
        return badIdTV;
    }

    public ImageView getCodenameIV() {
        return codenameIV;
    }


    public TextView getLinTV() {
        return linTV;
    }

    @Nullable
    public TextView getNameTV() {
        return nameTV;
    }

    public TextView getTaskNameTV() {
        return taskNameTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public TextView getTitleView() {
        return titleView;
    }

    public ImageView getArrowIV() {
        return arrowIV;
    }

    public TextView getTypeTV() {
        return typeTV;
    }
}
