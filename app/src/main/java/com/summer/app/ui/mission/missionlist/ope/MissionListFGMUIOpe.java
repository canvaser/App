package com.summer.app.ui.mission.missionlist.ope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ui.mission.missionlist.adapter.MissionListAdapter;
import com.summer.app.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.summer.app.ui.mission.missionlist.bean.uibean.MissionItenHeadUIBean;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListFGMUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView missionExpandView;


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

    MissionListAdapter missionListAdapter;

    public static String[] strings = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

    ArrayList<AreaMissionListAdapterBean> adapterList = new ArrayList<>();


    @BindArray(R.array.strarr_mission_type)
    String[] missionTypeStr;

    String[] missionSortStr;

    MissionItenHeadUIBean missionItenHeadUIBean;


    public MissionListFGMUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }


    private void init() {
        getBackTV().setBackgroundResource(R.drawable.drawable_right);
        getBackTV().setSelected(true);
        getBackTV().setText("全部");
        getRightTV().setSelected(true);
        getMidTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("全部");
        select(0);
    }

    public void initMid(String area, int count) {
        switch (area) {
            case AreaMessionDAOpe.AREA_TYPE_AREA:
                getMidTV().setText(MethodValue.getArea().getWardname() + (count == 0 ? "" : count));
                break;
            case AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                getMidTV().setText("我的任务");
                break;
        }
    }

    public void initMissionList(final boolean extend, ArrayList<AreaMissionListAdapterBean> adapterBeen) {
        adapterList.clear();
        if (adapterBeen != null) {
            adapterList.addAll(new AreaMessionDAOpe(context).initData(adapterBeen));
        }
        if (missionListAdapter == null || (missionListAdapter != null && !extend)) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_head_mission, null);
            missionItenHeadUIBean = new MissionItenHeadUIBean(context, view);
//            missionExpandView.addHeaderView(view, null, true);
//            view.findViewById(R.id.tv_all).setSelected(true);
            missionListAdapter = new MissionListAdapter(context, adapterList);
            missionExpandView.setGroupIndicator(null);
            missionExpandView.setAdapter(missionListAdapter);
            for (int i = 0; i < missionListAdapter.getGroupCount(); i++) {
                missionExpandView.expandGroup(i);
            }
        } else {
            missionListAdapter.notifyDataSetChanged();
        }
        missionExpandView.requestRefreshHeader();
        missionSortStr = MethodValue.getMissionSortStrs();
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

    public MissionListAdapter getMissionListAdapter() {
        return missionListAdapter;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public PinnedHeaderExpandableListView getMissionExpandView() {
        return missionExpandView;
    }

    public String[] getMissionTypeStr() {
        return missionTypeStr;
    }

    public String[] getMissionSortStr() {
        return missionSortStr;
    }

    public ArrayList<AreaMissionListAdapterBean> getAdapterList() {
        return adapterList;
    }

    public MissionItenHeadUIBean getMissionItenHeadUIBean() {
        return missionItenHeadUIBean;
    }

}
