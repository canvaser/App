package com.siweisoft.nurse.ui.info.announcement.ope;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-13.
 */
public class AnnounceUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    public AnnounceUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getMidTV().setText("通知公告");
        getBackTV().setText("返回");
        getBackTV().setSelected(true);

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
