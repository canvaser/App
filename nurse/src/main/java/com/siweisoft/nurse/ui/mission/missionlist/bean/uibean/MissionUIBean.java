package com.siweisoft.nurse.ui.mission.missionlist.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;
import com.siweisoft.lib.view.swipeview.view.SwipeView;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class MissionUIBean extends BaseUIBean {


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

    @Nullable
    @BindView(R.id.root)
    SwipeView swipeView;

    @BindView(R.id.ll_xyz)
    View leftV;

    @Nullable
    @BindView(R.id.tv_finish)
    View finishV;

    @BindView(R.id.tv_titlenum)
    TextView numTV;

    @BindView(R.id.tv_key)
    TextView keyTV;

    @BindView(R.id.iv_arrow)
    ImageView arrowIV;

    public MissionUIBean(Context context, View convertView) {
        super(context, convertView);

    }

    public TextView getBadIdTV() {
        return badIdTV;
    }

    public TextView getLinTV() {
        return linTV;
    }

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

    public ImageView getCodenameIV() {
        return codenameIV;
    }

    public SwipeView getSwipeView() {
        return swipeView;
    }

    public View getFinishV() {
        return finishV;
    }

    public View getLeftV() {
        return leftV;
    }

    public TextView getNumTV() {
        return numTV;
    }

    public TextView getKeyTV() {
        return keyTV;
    }

    public ImageView getArrowIV() {
        return arrowIV;
    }

}
