package com.summer.app.ui.info.addwaterlist.ope;

import android.content.Context;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-22.
 */

public class WaterListUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView missionExpandView;

    public WaterListUIOpe(Context context, View containerView) {
        super(context, containerView);
    }


    public PinnedHeaderExpandableListView getMissionExpandView() {
        return missionExpandView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
