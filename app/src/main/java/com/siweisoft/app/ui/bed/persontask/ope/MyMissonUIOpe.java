package com.siweisoft.app.ui.bed.persontask.ope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.app.ui.bed.persontask.adapter.MyMissionListAdapter;
import com.siweisoft.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.app.ui.mission.missionlist.bean.uibean.MissionItenHeadUIBean;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.system.HandleUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

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
        //missionExpandView.addHeaderView(view, null, true);
        select(0);
        view.findViewById(R.id.tv_all).setSelected(true);
    }

    public void init(PatientAdditionDAOpe patientAdditionDAOpe) {
        if (patientAdditionDAOpe != null) {
            getMidTV().setText(patientAdditionDAOpe.getMidTitle());
        }
    }

    public void initList(final HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> list) {
        if (myMissionListAdapter == null) {
            myMissionListAdapter = new MyMissionListAdapter(context, list);
            missionExpandView.setGroupIndicator(null);
            missionExpandView.setAdapter(myMissionListAdapter);
            missionExpandView.expandGroup(MyMissionStatusOpe.STATUS_LIST.size() - 1);
        } else {
            myMissionListAdapter.notifyDataSetChanged();
        }

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
