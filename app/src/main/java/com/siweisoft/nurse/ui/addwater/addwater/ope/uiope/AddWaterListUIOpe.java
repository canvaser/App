package com.siweisoft.nurse.ui.addwater.addwater.ope.uiope;

import android.content.Context;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.ui.addwater.addwater.adapter.AddWaterListAdpter;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterListUIOpe<B extends CommonUIFrag2> extends BaseNurseUIOpe<B> {

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView listView;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    public AddWaterListUIOpe(Context context, View containerView, B frag) {
        super(context, containerView);
        this.frag = frag;
        init();
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("补液卡");
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("日历");
        getRefreshLayout().setMaterialRefreshListener(getFrag());
    }

    public void initList(AddWaterListResBean addWaterListResBean) {
        getListView().setGroupIndicator(null);
        getListView().setAdapter(new AddWaterListAdpter(context, addWaterListResBean));
        for (int i = 0; i < getListView().getExpandableListAdapter().getGroupCount(); i++) {
            getListView().expandGroup(i);
        }
    }

    public PinnedHeaderExpandableListView getListView() {
        return listView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
