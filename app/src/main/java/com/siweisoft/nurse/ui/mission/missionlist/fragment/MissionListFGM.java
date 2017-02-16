package com.siweisoft.nurse.ui.mission.missionlist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListener;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.nurse.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.siweisoft.nurse.ui.mission.missiondetail.ope.MissionDetailNetOpe;
import com.siweisoft.nurse.ui.mission.missionlist.bean.MissionDABean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionTimeOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.MissionListFGMUIOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.MissionListNetOpe;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListFGM extends BaseNurseFrag implements
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener {



    MissionListFGMUIOpe missionListFGMUIOpe;


    MissionListNetOpe missionListNetOpe;

    AreaMessionDAOpe areaMessionDAOpe ;


    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        missionListFGMUIOpe = new MissionListFGMUIOpe(activity,getView());
        missionListNetOpe= new MissionListNetOpe(activity);
        areaMessionDAOpe= new AreaMessionDAOpe();
        missionListFGMUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getMyTask(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
        missionListFGMUIOpe.getMissionExpandView().setOnHeaderUpdateListener(MissionListFGM.this);
        getMyTask(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                missionListFGMUIOpe.getMissionExpandView().setOnHeadViewClick(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        LogUtil.E(position);
                        switch (position){
                            case 1:
                                missionListFGMUIOpe.getMissionItenHeadUIBean().select(0);
                                areaMessionDAOpe.count = AreaMessionDAOpe.COUNT_ALL;
                                getMyTask(true,null);
                                break;
                            case 2:
                                areaMessionDAOpe.count = AreaMessionDAOpe.COUNT_LIN;
                                missionListFGMUIOpe.getMissionItenHeadUIBean().select(1);
                                getMyTask(true,null);
                                break;
                            case 3:
                                areaMessionDAOpe.count = AreaMessionDAOpe.COUNT_LONG;
                                missionListFGMUIOpe.getMissionItenHeadUIBean().select(2);
                                getMyTask(true,null);
                                break;
                        }
                    }
                });

            }
        });
    }

    public void getMyTask(final OnFinishListener onFinishListener){
        final String type1=areaMessionDAOpe.leftType;
         String type=AreaMessionDAOpe.ALL;
        missionListFGMUIOpe.getBackTV().setText(type1);
        switch (type1){
            case "全部":
                type = AreaMessionDAOpe.ALL;
                break;
            case "完成":
                type = DataValue.STATUS_YI_WAN_CHENG;
                break;
            case "未完":

                break;
            case "删除":
                type = DataValue.SSTATUS_SHAN_CHU;
                break;
            case "拒绝":
                type = DataValue.STATUS_BING_REN_JU_JUE;
                break;
            case "不在":
                type = DataValue.STATUS_BING_REN_BU_ZAI;
                break;
            case "历史":
                areaMessionDAOpe.timeArea = AreaMessionDAOpe.TIME_HISTORY;
                type = AreaMessionDAOpe.ALL;
                break;

        }

        String time=areaMessionDAOpe.timeArea;
        String area=areaMessionDAOpe.areaType;
        final String sort=areaMessionDAOpe.rightSort;
        final String count=areaMessionDAOpe.count;
        LogUtil.E("time:"+time+"----"+"area:"+area+"----"+"type:"+type+"---"+"sort:"+sort+"---"+"count:"+count);
        switch (area){
            case AreaMessionDAOpe.AREA_TYPE_AREA:
                missionListFGMUIOpe.getMidTV().setText("病区");
                break;
            case AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                missionListFGMUIOpe.getMidTV().setText("我的病人");
                break;
        }

        missionListFGMUIOpe.getRightTV().setText(sort);
        switch (time+area){
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_AREA:
                final String finalType = type;
                missionListNetOpe.getMyWardTaskOfToday(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myAreaTodayData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                final String finalType1 = type;
                missionListNetOpe.getMyPatientTaskOfToday(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType1,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myPatientTodayData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_AREA:
                final String finalType2 = type;
                missionListNetOpe.getMyWardTaskOfHistory(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType2,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myAreaHistoryData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                final String finalType3 = type;
                missionListNetOpe.getMyPatientTaskOfHistory(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType3,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myPatientHistoryData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
        }

    }

    public void getMyTask(boolean cache,final OnFinishListener onFinishListener){
        final String type1=areaMessionDAOpe.leftType;
        String type=AreaMessionDAOpe.ALL;
        missionListFGMUIOpe.getBackTV().setText(type1);
        switch (type1){
            case "全部":
                type = AreaMessionDAOpe.ALL;
                break;
            case "完成":
                type = DataValue.STATUS_YI_WAN_CHENG;
                break;
            case "未完":

                break;
            case "删除":
                type = DataValue.SSTATUS_SHAN_CHU;
                break;
            case "拒绝":
                type = DataValue.STATUS_BING_REN_JU_JUE;
                break;
            case "不在":
                type = DataValue.STATUS_BING_REN_BU_ZAI;
                break;
            case "历史":
                areaMessionDAOpe.timeArea = AreaMessionDAOpe.TIME_HISTORY;
                type = AreaMessionDAOpe.ALL;
                break;

        }

        String time=areaMessionDAOpe.timeArea;
        String area=areaMessionDAOpe.areaType;
        final String sort=areaMessionDAOpe.rightSort;
        final String count=areaMessionDAOpe.count;
        LogUtil.E("time:"+time+"----"+"area:"+area+"----"+"type:"+type+"---"+"sort:"+sort+"---"+"count:"+count);
        switch (area){
            case AreaMessionDAOpe.AREA_TYPE_AREA:
                missionListFGMUIOpe.getMidTV().setText(MethodValue.getArea().getWardname());
                break;
            case AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                missionListFGMUIOpe.getMidTV().setText("我的任务");
                break;
        }

        missionListFGMUIOpe.getRightTV().setText(sort);
        switch (time+area){
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_AREA:
                final String finalType = type;
                if(!areaMessionDAOpe.myAreaTodayData.equals("")){
                    String o =areaMessionDAOpe.myAreaTodayData;
                    AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                    missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType,sort,count));
                    missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(this);
                    areaMessionDAOpe.myAreaTodayData = o.toString();
                    if(onFinishListener!=null){
                        onFinishListener.onFinish(o);
                    }
                    break;
                }
                missionListNetOpe.getMyWardTaskOfToday(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myAreaTodayData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                final String finalType1 = type;
                if(!areaMessionDAOpe.myPatientTodayData.equals("")){
                    String o = areaMessionDAOpe.myPatientTodayData;
                    AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                    missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType1,sort,count));
                    missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                    areaMessionDAOpe.myPatientTodayData = o.toString();
                    if(onFinishListener!=null){
                        onFinishListener.onFinish(o);
                    }
                    break;
                }
                missionListNetOpe.getMyPatientTaskOfToday(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType1,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myPatientTodayData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_AREA:
                final String finalType2 = type;
                if(!areaMessionDAOpe.myAreaHistoryData.equals("")){
                    String o= areaMessionDAOpe.myAreaHistoryData;
                    AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                    missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType2,sort,count));
                    missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(this);
                    areaMessionDAOpe.myAreaHistoryData = o.toString();
                    if(onFinishListener!=null){
                        onFinishListener.onFinish(o);
                    }
                    break;
                }
                missionListNetOpe.getMyWardTaskOfHistory(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType2,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myAreaHistoryData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                final String finalType3 = type;
                if(!areaMessionDAOpe.myPatientHistoryData.equals("")){
                    String o = areaMessionDAOpe.myPatientHistoryData;
                    AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                    missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType3,sort,count));
                    missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                    areaMessionDAOpe.myPatientHistoryData = o.toString();
                    if(onFinishListener!=null){
                        onFinishListener.onFinish(o);
                    }
                    break;
                }
                missionListNetOpe.getMyPatientTaskOfHistory(new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                            missionListFGMUIOpe.initMissionList(new AreaMessionTimeOpe().sort(resBean, finalType3,sort,count));
                            missionListFGMUIOpe.getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            areaMessionDAOpe.myPatientHistoryData = o.toString();
                        }
                        if(onFinishListener!=null){
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
        }

    }




    @Override
    public int getContainView() {
        return R.layout.frag_missionlist;
    }


    @Override
    public View getPinnedHeader() {
        View headerView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.list_head_mission, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if(missionListFGMUIOpe==null || missionListFGMUIOpe.getMissionListAdapter()==null ||
                missionListFGMUIOpe.getMissionListAdapter().getData()==null||missionListFGMUIOpe.getMissionListAdapter().getData().size()==0
                ||firstVisibleGroupPos<0){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView startTV = (TextView) headerView.findViewById(R.id.tv_starttime);
        TextView endTV = (TextView) headerView.findViewById(R.id.tv_endtime);
        TextView titleTV = (TextView) headerView.findViewById(R.id.tv_title);
        startTV.setText(StringUtil.getStr((missionListFGMUIOpe.getMissionListAdapter().getData().get(firstVisibleGroupPos).getHour())+":00"));
        endTV.setText(StringUtil.getStr(missionListFGMUIOpe.getMissionListAdapter().getData().get(firstVisibleGroupPos).getHour()+2)+":00");
        titleTV.setText(StringUtil.getStr(missionListFGMUIOpe.getMissionListAdapter().getData().get(firstVisibleGroupPos).getYYYYMMDD()));
    }



    @Optional
    @OnClick({BaseID.ID_MID,BaseID.ID_BACK, BaseID.ID_RIGHT})
    public void onClickEvent(View view){
        switch (view.getId()){
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity,2));
                String[] strings = new String[]{"我的任务", MethodValue.getArea().getWardname()};
                PupListAdapter pupListAdapter = new PupListAdapter(activity,strings);
                recyclerView.setAdapter(pupListAdapter);
                pupListAdapter.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                areaMessionDAOpe.areaType = AreaMessionDAOpe.AREA_TYPE_MY_PATIENT;
                                getMyTask(true,null);
                                break;
                            case 1:
                                areaMessionDAOpe.areaType = AreaMessionDAOpe.AREA_TYPE_AREA;
                                getMyTask(true,null);
                                break;
                        }
                        PopupUtil.getInstance().dimess();
                    }
                });
                PopupUtil.getInstance().show(activity,view1,view);
                break;
            case BaseID.ID_BACK:
                View view2 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.rcv_pop);
                recyclerView2.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView2.addItemDecoration(new MyItemDecoration(activity,2));
                PupListAdapter pupListAdapter2 = new PupListAdapter(activity,missionListFGMUIOpe.getMissionTypeStr());
                recyclerView2.setAdapter(pupListAdapter2);
                pupListAdapter2.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        areaMessionDAOpe.leftType= textView.getText().toString();
                        areaMessionDAOpe.timeArea = AreaMessionDAOpe.TIME_TODAY;

                        getMyTask(true,null);
                        PopupUtil.getInstance().dimess();
                    }
                });
                PopupUtil.getInstance().show(activity,view2,view);
                break;

            case BaseID.ID_RIGHT:
                View view3 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView3 = (RecyclerView) view3.findViewById(R.id.rcv_pop);
                recyclerView3.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView3.addItemDecoration(new MyItemDecoration(activity,2));

                PupListAdapter pupListAdapter3 = new PupListAdapter(activity,missionListFGMUIOpe.getMissionSortStr());
                recyclerView3.setAdapter(pupListAdapter3);
                pupListAdapter3.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        areaMessionDAOpe.rightSort= textView.getText().toString();
                        getMyTask(true,null);
                        PopupUtil.getInstance().dimess();
                    }
                });
                PopupUtil.getInstance().show(activity,view3,view);
                break;

        }
    }

    @Override
    public void onAppItemClick(int groupPosition, View view, int childPosition) {
        switch (view.getId()){
            case R.id.ll_xyz:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA,missionListFGMUIOpe.getAdapterList().get(groupPosition).getData().get(childPosition));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new MissionDetailFrag(),bundle, ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_finish:
                MissisonDetailReqBean reqBean = new MissisonDetailReqBean();
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                reqBean.setRegion(data.getWardcode());
                if(missionListFGMUIOpe.getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().size()<=1){
                    reqBean.setId(missionListFGMUIOpe.getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getId());
                }else{
                    reqBean.setTaskids(areaMessionDAOpe.getIDs(missionListFGMUIOpe.getAdapterList().get(groupPosition).getData().get(childPosition).getTitles()));
                }
                reqBean.setStatus("T");
                MissionDetailNetOpe missionDetailNetOpe = new MissionDetailNetOpe(activity);
                missionDetailNetOpe.updateTask(reqBean, new OnNetWorkReqAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                           missionListFGMUIOpe.getRefreshLayout().autoRefresh();
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        missionListFGMUIOpe.getRefreshLayout().autoRefresh(500);
    }
}
