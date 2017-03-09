package com.siweisoft.ui.check.checklist.bean;

import android.content.Context;
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
public class CheckUIBean extends BaseUIBean {


    @BindView(R.id.tv_title)
    TextView titleView;


    @BindView(R.id.lin)
    TextView linTV;

    @BindView(R.id.tv_taskname)
    TextView taskNameTV;

    @BindView(R.id.tv_badid)
    TextView badIdTV;

    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.root)
    SwipeView swipeView;


    @BindView(R.id.tv_finish)
    TextView finishTV;

    @BindView(R.id.ll_left)
    View leftView;

    @BindView(R.id.iv_codename)
    ImageView codeName;

    @BindView(R.id.iv_gou)
    ImageView gou;


    public CheckUIBean(Context context, View convertView) {
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

    public SwipeView getSwipeView() {
        return swipeView;
    }

    public TextView getFinishTV() {
        return finishTV;
    }

    public View getLeftView() {
        return leftView;
    }

    public ImageView getCodeName() {
        return codeName;
    }

    public ImageView getGou() {
        return gou;
    }
}
