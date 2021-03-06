package com.summer.app.ui.check.checklist.ope;

import android.content.Context;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.check.checklist.adapter.CheckListAdapter;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.check.checklist.bean.resbean.CheckResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckListFGMUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView missionExpandView;

    CheckListAdapter checkListAdapter;

    public static String[] strings = new String[]{"0", "1", "2", "3", "4", "5", "6"};

    public CheckListFGMUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }

    private void init() {
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("全部");
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("配药核对");
        getRightTV().setBackgroundResource(R.drawable.drawable_right);
        getRightTV().setSelected(true);
    }

    public void initList(ArrayList<CheckResBean> data) {
        checkListAdapter = new CheckListAdapter(context, data);
        missionExpandView.setGroupIndicator(null);
        missionExpandView.setAdapter(checkListAdapter);
        for (int i = 0; i < checkListAdapter.getGroupCount(); i++) {
            missionExpandView.expandGroup(i);
        }
    }

    public PinnedHeaderExpandableListView getMissionExpandView() {
        return missionExpandView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public CheckListAdapter getCheckListAdapter() {
        return checkListAdapter;
    }
}
