package com.siweisoft.nurse.ui.info.bedcheck.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.ui.info.bedcheck.bean.resbean.BedCheckListResBean;
import com.siweisoft.nurse.ui.info.bedcheck.ope.BedCheckDAOpe;
import com.siweisoft.nurse.ui.info.bedcheck.ope.BedCheckNetOpe;
import com.siweisoft.nurse.ui.info.bedcheck.ope.BedCheckUIOpe;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.menu.popup.PopupUtil;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedCheckFrag extends BaseNurseFrag{



    BedCheckUIOpe bedCheckUIOpe;


    BedCheckNetOpe bedCheckNetOpe;

    BedCheckDAOpe bedCheckDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bedCheckNetOpe = new BedCheckNetOpe(activity);
        bedCheckUIOpe = new BedCheckUIOpe(activity,getView());
        bedCheckDAOpe= new BedCheckDAOpe(activity);
        bedCheckUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
     bedCheckUIOpe.getRefreshLayout().autoRefresh();
    }

    public void getData(final OnFinishListener listener){
        bedCheckNetOpe.getWardInspectionList(new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    BedCheckListResBean bedCheckListResBean = GsonUtil.getInstance().fromJson(o.toString(),BedCheckListResBean.class);
                    bedCheckDAOpe.setData(bedCheckListResBean.getData());
                    bedCheckUIOpe.initList(bedCheckDAOpe.getSelectData());
                }
                if(listener!=null){
                    listener.onFinish(o);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_bedcheck;
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity,2));
                String[] strings = new String[]{"我的巡视","病房巡视"};
                PupListAdapter pupListAdapter = new PupListAdapter(activity,strings);
                recyclerView.setAdapter(pupListAdapter);
                pupListAdapter.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        bedCheckDAOpe.setPosition(position);
                        bedCheckUIOpe.initList(bedCheckDAOpe.getSelectData());
                        PopupUtil.getInstance().dimess();
                    }
                });
                PopupUtil.getInstance().show(activity,view1,v);
                break;
        }
    }
}
