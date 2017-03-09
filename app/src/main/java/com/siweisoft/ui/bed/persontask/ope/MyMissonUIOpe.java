package com.siweisoft.ui.bed.persontask.ope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.ui.bed.persontask.adapter.MyMissionListAdapter;
import com.siweisoft.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.ui.mission.missionlist.bean.uibean.MissionItenHeadUIBean;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MyMissonUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView missionExpandView;

    MyMissionListAdapter myMissionListAdapter;


    MissionItenHeadUIBean missionItenHeadUIBean;

    public MyMissonUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
        init(null);
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getMidTV().setSelected(true);
        getRightTV().setSelected(true);
        getRightTV().setText("全部");
        View view = LayoutInflater.from(context).inflate(R.layout.item_head_mission, null);
        missionItenHeadUIBean = new MissionItenHeadUIBean(context, view);
        missionExpandView.addHeaderView(view, null, true);
        view.findViewById(R.id.tv_all).setSelected(true);
    }

    public void init(PatientAdditionDAOpe patientAdditionDAOpe) {
        if (patientAdditionDAOpe != null) {
            getMidTV().setText(patientAdditionDAOpe.getMidTitle());
        }
    }

    public void initList(HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> list) {
        if (myMissionListAdapter == null) {
            myMissionListAdapter = new MyMissionListAdapter(context, list);
            missionExpandView.setGroupIndicator(null);
            missionExpandView.setAdapter(myMissionListAdapter);
            missionExpandView.expandGroup((list.size() - 1) >= 0 ? list.size() - 1 : 0);
        } else {
            myMissionListAdapter.notifyDataSetChanged();
        }

    }

    public PinnedHeaderExpandableListView getMissionExpandView() {
        return missionExpandView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public MyMissionListAdapter getMyMissionListAdapter() {
        return myMissionListAdapter;
    }


    public MissionItenHeadUIBean getMissionItenHeadUIBean() {
        return missionItenHeadUIBean;
    }
}
