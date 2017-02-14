package com.siweisoft.nurse.ui.bed.MyMission.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.bed.MyMission.bean.reqbean.GetPatientTaskOfTodayReqBean;
import com.siweisoft.nurse.ui.bed.MyMission.bean.reqbean.GetPatientTaskReqBean;
import com.siweisoft.nurse.ui.bed.MyMission.ope.GetMyMissionNetOpe;
import com.siweisoft.nurse.ui.bed.MyMission.ope.MyMissionDAOpe;
import com.siweisoft.nurse.ui.bed.MyMission.ope.MyMissionStatusOpe;
import com.siweisoft.nurse.ui.bed.MyMission.ope.MyMissonUIOpe;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.nurse.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.siweisoft.nurse.ui.mission.missiondetail.ope.MissionDetailNetOpe;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.SPUtil;
import com.siweisoft.util.StringUtil;
import com.siweisoft.util.menu.popup.PopupUtil;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MyMissonFrag extends BaseNurseFrag implements
        ExpandableListView.OnChildClickListener,
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener{


    MyMissonUIOpe myMissonUIOpe;

    GetMyMissionNetOpe getMyMissionNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    MyMissionDAOpe myMissionDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        myMissonUIOpe= new MyMissonUIOpe(activity,getView());
        getMyMissionNetOpe= new GetMyMissionNetOpe(activity);
        myMissionDAOpe= new MyMissionDAOpe(activity);
        myMissonUIOpe.init(patientAdditionDAOpe);
        myMissonUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getPatientTask(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        myMissonUIOpe.getMissionExpandView().setOnHeadViewClick(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1:
                                        myMissonUIOpe.getMissionItenHeadUIBean().select(0);
                                        myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[0]);
                                        break;
                                    case 2:
                                        myMissonUIOpe.getMissionItenHeadUIBean().select(1);
                                        myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[1]);
                                        break;
                                    case 3:
                                        myMissonUIOpe.getMissionItenHeadUIBean().select(2);
                                        myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[2]);
                                        break;
                                }
                                myMissonUIOpe.initList(myMissionDAOpe.sort());
                            }
                        });
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
        myMissonUIOpe.getMissionExpandView().setOnHeaderUpdateListener(this);
        myMissonUIOpe.getMissionExpandView().setOnChildClickListener(this);
        myMissonUIOpe.getRefreshLayout().autoRefresh(500);

    }

    public void getPatientTask(final OnFinishListener onFinishListener){
        getMyMissionNetOpe.getPatientTask(patientAdditionDAOpe.getPatientBedResBean().get住院号(), new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                    myMissionDAOpe.setList(new MyMissionStatusOpe().sortStatus(resBean.getData()));
                    myMissonUIOpe.initList(myMissionDAOpe.getList());
                    myMissonUIOpe.getMyMissionListAdapter().setOnAppItemClickListener(MyMissonFrag.this);
                    myMissonUIOpe.getMyMissionListAdapter().setOnAppItemsClickListener(MyMissonFrag.this);
                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
    }



    @Override
    public int getContainView() {
        return R.layout.frag_mymission;
    }


    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        FragManager.getInstance().startFragment(getFragmentManager(),1,new MissionDetailFrag());
        return false;
    }

    @Override
    public View getPinnedHeader() {
        View headerView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.list_head_mymission, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if(myMissonUIOpe.getMyMissionListAdapter()==null || firstVisibleGroupPos<0 ){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView title = (TextView) headerView.findViewById(R.id.tv_title);
        TextView num = (TextView) headerView.findViewById(R.id.tv_num);

        title.setText(MyMissionStatusOpe.STATUS_LIST_STR.get(firstVisibleGroupPos));
        num.setText(StringUtil.getStr(myMissonUIOpe.getMyMissionListAdapter().getChildrenCount(firstVisibleGroupPos)));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {
        switch (view.getId()){
            case R.id.ll_xyz:
                Bundle bundle =new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA,(AreaMessionResBean)myMissonUIOpe.getMyMissionListAdapter().getChild(index,position));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),this.index,new MissionDetailFrag(),bundle,ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_finish:
                MissisonDetailReqBean reqBean = new MissisonDetailReqBean();
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                reqBean.setRegion(data.getWardcode());
                if(myMissonUIOpe.getMyMissionListAdapter().getChild(index,position).getTitles().size()<=1){
                    reqBean.setId(myMissonUIOpe.getMyMissionListAdapter().getChild(index,position).getTitles().get(0).getId());
                }else{
                    reqBean.setTaskids(new AreaMessionDAOpe().getIDs(myMissonUIOpe.getMyMissionListAdapter().getChild(index,position).getTitles()));
                }
                reqBean.setStatus("T");
                MissionDetailNetOpe missionDetailNetOpe = new MissionDetailNetOpe(activity);
                missionDetailNetOpe.updateTask(reqBean, new OnNetWorkReqAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            myMissonUIOpe.getRefreshLayout().autoRefresh();
                        }
                    }
                });
                break;
        }
    }



    @Override
    @OnClick({BaseID.ID_RIGHT,BaseID.ID_MID})
    public void onBackClick(View v){
        super.onBackClick(v);
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                View view3 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView3 = (RecyclerView) view3.findViewById(R.id.rcv_pop);
                recyclerView3.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView3.addItemDecoration(new MyItemDecoration(activity,2));
                String[] missionSortStr = (String[]) MethodValue.getUserInfo(activity).getData().getNurseType().toArray(new String[MethodValue.getUserInfo(activity).getData().getNurseType().size()]);
                myMissionDAOpe.setMissionSortStr(missionSortStr);
                MyMissionDAOpe.WAY_TYPE = missionSortStr;
                PupListAdapter pupListAdapter3 = new PupListAdapter(activity, myMissionDAOpe.addString(missionSortStr));
                recyclerView3.setAdapter(pupListAdapter3);
                pupListAdapter3.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        myMissionDAOpe.setWayType(textView.getText().toString());
                        myMissonUIOpe.getRightTV().setText(myMissionDAOpe.getWayType());
                        PopupUtil.getInstance().dimess();
                        myMissonUIOpe.initList(myMissionDAOpe.sort());
                    }
                });
                PopupUtil.getInstance().show(activity,view3,v);
                break;
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.getLayoutParams().height = ValueConstant.DIMEN_1*200;
                recyclerView.requestLayout();
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity,2));

                PupListAdapter p = new PupListAdapter(activity,patientAdditionDAOpe.getNames());
                p.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        PopupUtil.getInstance().dimess();
                        myMissonUIOpe.init(patientAdditionDAOpe);
                        getPatientTask(null);
                    }
                });
                recyclerView.setAdapter(p);
                PopupUtil.getInstance().show(activity,view1,v);
                break;
        }
    }



    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        myMissonUIOpe.getRefreshLayout().autoRefresh(1000);
    }
}
