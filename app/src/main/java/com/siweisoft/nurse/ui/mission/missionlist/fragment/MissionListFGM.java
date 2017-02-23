package com.siweisoft.nurse.ui.mission.missionlist.fragment;

import android.content.Intent;
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
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.OnNetFinishWithObjInter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.addwater.addaddwater.fragment.AddAddWaterFrag;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.nurse.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.siweisoft.nurse.ui.mission.missiondetail.ope.MissionDetailNetOpe;
import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionTimeOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.MissionListFGMUIOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.MissionListNetOpe;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListFGM extends BaseNurseFrag<MissionListFGMUIOpe,MissionListNetOpe,BaseDBOpe,AreaMessionDAOpe> implements
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener,
        AdapterView.OnItemClickListener{



    @Override
    public BaseNurseOpes<MissionListFGMUIOpe, MissionListNetOpe, BaseDBOpe, AreaMessionDAOpe> getOpe() {
        if(baseNurseOpes == null){
            baseNurseOpes = new BaseNurseOpes(new MissionListFGMUIOpe(activity,getView()),new MissionListNetOpe(activity),null,new AreaMessionDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getBaseNurseUIOpe().getMissionExpandView().setOnHeaderUpdateListener(this);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getMyTask(boolean cache,final OnFinishListener onFinishListener){
        final String type1=getOpe().getBaseDAOpe().leftType;
        getOpe().getBaseNurseUIOpe().getBackTV().setText(type1);
        final String type = getOpe().getBaseDAOpe().getHashMap().get(type1);
        if(type1.equals("历史")){
            getOpe().getBaseDAOpe().timeArea = AreaMessionDAOpe.TIME_HISTORY;
        }
        String time=getOpe().getBaseDAOpe().timeArea;
        final String area=getOpe().getBaseDAOpe().areaType;
        final String sort=getOpe().getBaseDAOpe().rightSort;
        final String count=getOpe().getBaseDAOpe().count;
        getOpe().getBaseNurseUIOpe().initMid(area,0);

        getOpe().getBaseNurseUIOpe().getRightTV().setText(sort);
        LogUtil.E("time:"+time+"----"+"area:"+area+"----"+"type:"+type+"---"+"sort:"+sort+"---"+"count:"+count);

        if(cache && !NullUtil.isStrEmpty(getOpe().getBaseDAOpe().getCahceData(time+area))){
            String o =getOpe().getBaseDAOpe().getCahceData(time+area);
            final AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
            new AreaMessionTimeOpe().sort(resBean, type, sort, count, new OnNetFinishWithObjInter() {
                @Override
                public void onNetFinish(Object o) {
                    getOpe().getBaseNurseUIOpe().initMissionList((ArrayList<AreaMissionListAdapterBean>) o);
                    getOpe().getBaseNurseUIOpe().initMid(area,resBean==null?0:resBean.getData()==null?0:resBean.getData().size());
                    getOpe().getBaseNurseUIOpe().getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                    if(onFinishListener!=null){
                        onFinishListener.onFinish(o);
                    }
                }
            });
            return;
        }

        getOpe().getBaseNetOpe().getMissionData(time+area,new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    final AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AreaMessionListResBean.class);
                    new AreaMessionTimeOpe().sort(resBean, type, sort, count, new OnNetFinishWithObjInter() {
                        @Override
                        public void onNetFinish(Object o) {
                            getOpe().getBaseNurseUIOpe().initMissionList((ArrayList<AreaMissionListAdapterBean>) o);
                            getOpe().getBaseNurseUIOpe().initMid(area,resBean==null?0:resBean.getData()==null?0:resBean.getData().size());
                            getOpe().getBaseNurseUIOpe().getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            getOpe().getBaseDAOpe().setCacheData(type,o.toString());
                        }
                    });
                }else{
                    getOpe().getBaseNurseUIOpe().initMissionList(null);
                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
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
        if(getOpe().getBaseNurseUIOpe()==null || getOpe().getBaseNurseUIOpe().getMissionListAdapter()==null ||
                getOpe().getBaseNurseUIOpe().getMissionListAdapter().getData()==null||getOpe().getBaseNurseUIOpe().getMissionListAdapter().getData().size()==0
                ||firstVisibleGroupPos<0){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView startTV = (TextView) headerView.findViewById(R.id.tv_starttime);
        TextView endTV = (TextView) headerView.findViewById(R.id.tv_endtime);
        TextView titleTV = (TextView) headerView.findViewById(R.id.tv_title);
        startTV.setText(StringUtil.getStr((getOpe().getBaseNurseUIOpe().getMissionListAdapter().getData().get(firstVisibleGroupPos).getHour())+":00"));
        endTV.setText(StringUtil.getStr(getOpe().getBaseNurseUIOpe().getMissionListAdapter().getData().get(firstVisibleGroupPos).getHour()+2)+":00");
        titleTV.setText(StringUtil.getStr(getOpe().getBaseNurseUIOpe().getMissionListAdapter().getData().get(firstVisibleGroupPos).getYYYYMMDD()));
    }



    @Optional
    @OnClick({BaseID.ID_MID,BaseID.ID_BACK, BaseID.ID_RIGHT})
    public void onClickEvent(View view){
        switch (view.getId()){
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(),BaseID.ID_ROOT,new String[]{"我的任务", MethodValue.getArea().getWardname()}, NurseDialogFrag.MID,new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                getOpe().getBaseDAOpe().areaType = AreaMessionDAOpe.AREA_TYPE_MY_PATIENT;
                                getMyTask(true,null);
                                break;
                            case 1:
                                getOpe().getBaseDAOpe().areaType = AreaMessionDAOpe.AREA_TYPE_AREA;
                                getMyTask(true,null);
                                break;
                        }
                    }
                });
                break;
            case BaseID.ID_BACK:
                NurseDialogFrag.show(getFragmentManager(),BaseID.ID_ROOT,getOpe().getBaseNurseUIOpe().getMissionTypeStr(), NurseDialogFrag.LEFT,new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        getOpe().getBaseDAOpe().leftType= textView.getText().toString();
                        getOpe().getBaseDAOpe().timeArea = AreaMessionDAOpe.TIME_TODAY;

                        getMyTask(true,null);
                    }
                });
                break;

            case BaseID.ID_RIGHT:
                NurseDialogFrag.show(getFragmentManager(),BaseID.ID_ROOT,getOpe().getBaseNurseUIOpe().getMissionSortStr(), NurseDialogFrag.RIGHT,new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        getOpe().getBaseDAOpe().rightSort= textView.getText().toString();
                        getMyTask(true,null);
                        PopupUtil.getInstance().dimess();
                    }
                });
                break;
        }
    }

    @Override
    public void onAppItemClick(int groupPosition, View view, int childPosition) {
        switch (view.getId()){
            case R.id.ll_xyz:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA,getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new MissionDetailFrag(),bundle, ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_finish:
                if(getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getCodename().equals("补液卡")||
                        getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getNurse_type().equals("静滴")||
                        getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getNurse_type().equals("术前治疗")){
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable(ValueConstant.DATA_DATA,getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition));
                    FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new AddAddWaterFrag(),bundle1, ValueConstant.CODE_REQUSET);
                    return;
                }
                MissisonDetailReqBean reqBean = new MissisonDetailReqBean();
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                reqBean.setRegion(data.getWardcode());
                if(getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().size()<=1){
                    reqBean.setId(getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getId());
                }else{
                    reqBean.setTaskids(getOpe().getBaseDAOpe().getIDs(getOpe().getBaseNurseUIOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles()));
                }
                reqBean.setStatus("T");
                MissionDetailNetOpe missionDetailNetOpe = new MissionDetailNetOpe(activity);
                missionDetailNetOpe.updateTask(reqBean, new OnNetWorkReqAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh();
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        getMyTask(false,new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                getOpe().getBaseNurseUIOpe().getMissionExpandView().setOnHeadViewClick(MissionListFGM.this);
                materialRefreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 1:
                getOpe().getBaseNurseUIOpe().getMissionItenHeadUIBean().select(0);
                getOpe().getBaseDAOpe().count = AreaMessionDAOpe.COUNT_ALL;
                getMyTask(true,null);
                break;
            case 2:
                getOpe().getBaseDAOpe().count = AreaMessionDAOpe.COUNT_LIN;
                getOpe().getBaseNurseUIOpe().getMissionItenHeadUIBean().select(1);
                getMyTask(true,null);
                break;
            case 3:
                getOpe().getBaseDAOpe().count = AreaMessionDAOpe.COUNT_LONG;
                getOpe().getBaseNurseUIOpe().getMissionItenHeadUIBean().select(2);
                getMyTask(true,null);
                break;
        }
    }
}
