package com.siweisoft.nurse.ui.bed.MyMission.ope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.MyMission.adapter.MyMissionListAdapter;
import com.siweisoft.nurse.ui.base.view.MissionExpandView;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.uibean.MissionItenHeadUIBean;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MyMissonUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView missionExpandView;

    MyMissionListAdapter myMissionListAdapter;

    private HashMap<String,ArrayList<AreaMessionResBean>> list;

    MissionItenHeadUIBean missionItenHeadUIBean;

    public MyMissonUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
        init(null);
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");

        getMidTV().setSelected(true);
        getRightTV().setSelected(true);
        getRightTV().setText("日历");
        View view = LayoutInflater.from(context).inflate(R.layout.item_head_mission,null);
        missionItenHeadUIBean = new MissionItenHeadUIBean(context,view);
        missionExpandView.addHeaderView(view,null,true);
        view.findViewById(R.id.tv_all).setSelected(true);
    }

    public void init(PatientAdditionDAOpe patientAdditionDAOpe){
        if(patientAdditionDAOpe!=null){
            getMidTV().setText(patientAdditionDAOpe.getPatientBedResBean().get姓名()+patientAdditionDAOpe.getPatientBedResBean().get病床号());
        }
    }

    public void initList(HashMap<String,ArrayList<AreaMessionResBean>> list){
        this.list = list;
        myMissionListAdapter = new MyMissionListAdapter(context,this.list);
        missionExpandView.setGroupIndicator(null);
        missionExpandView.setAdapter(myMissionListAdapter);

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

    public HashMap<String, ArrayList<AreaMessionResBean>> getList() {
        return list;
    }

    public MissionItenHeadUIBean getMissionItenHeadUIBean() {
        return missionItenHeadUIBean;
    }
}
