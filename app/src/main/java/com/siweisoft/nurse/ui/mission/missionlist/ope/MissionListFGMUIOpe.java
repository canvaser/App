package com.siweisoft.nurse.ui.mission.missionlist.ope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.mission.missionlist.adapter.MissionListAdapter;
import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.uibean.MissionItenHeadUIBean;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginResBean;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.SPUtil;
import com.siweisoft.util.ToastUtil;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListFGMUIOpe extends BaseNurseUIOpe {



    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView missionExpandView;

    MissionListAdapter missionListAdapter;

    public static String[] strings = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13"};

    ArrayList<AreaMissionListAdapterBean> adapterList= new ArrayList<>();


    @BindArray(R.array.strarr_mission_type)
    String[] missionTypeStr;

    String[] missionSortStr;

    MissionItenHeadUIBean missionItenHeadUIBean;


    public MissionListFGMUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }

    private void init(){

        getBackTV().setSelected(true);
        getBackTV().setText("全部");

        getMidTV().setSelected(true);


        getRightTV().setSelected(true);
        getRightTV().setText("全部");

    }

    public void initMissionList(ArrayList<AreaMissionListAdapterBean> adapterBeen){

        adapterList.clear();
        adapterList.addAll(new AreaMessionDAOpe().initData(adapterBeen));
        if(missionListAdapter==null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_head_mission,null);
            missionItenHeadUIBean = new MissionItenHeadUIBean(context,view);
            missionExpandView.addHeaderView(view,null,true);
            view.findViewById(R.id.tv_all).setSelected(true);
            missionListAdapter = new MissionListAdapter(context,adapterList);
            missionExpandView.setGroupIndicator(null);
            missionExpandView.setAdapter(missionListAdapter);
        }else{
//            missionListAdapter=null;
//            System.gc();
//            missionListAdapter = new MissionListAdapter(context,adapterList);
//            missionExpandView.setAdapter(missionListAdapter);
            missionListAdapter.notifyDataSetChanged();
        }


        DoLoginResBean loginResBean = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.LOGIN_INFO),DoLoginResBean.class);
        loginResBean.getData().getNurseType().add(0,"全部");
        missionSortStr = (String[]) loginResBean.getData().getNurseType().toArray(new String[loginResBean.getData().getNurseType().size()]);
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
