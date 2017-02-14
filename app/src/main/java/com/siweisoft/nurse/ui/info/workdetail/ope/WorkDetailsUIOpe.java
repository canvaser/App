package com.siweisoft.nurse.ui.info.workdetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.home.bean.reqbean.WriteAlarmReqBean;
import com.siweisoft.nurse.ui.info.workdetail.adapter.WorkDetailListAdapter;
import com.siweisoft.nurse.ui.info.workdetail.adapter.WorkDetailsListAdapter;
import com.siweisoft.nurse.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;
import com.siweisoft.nurse.ui.info.workdetail.bean.resbean.WorkDetailResBean;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class WorkDetailsUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    WorkDetailsListAdapter workDetailsListAdapter;


    public WorkDetailsUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }


    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");


    }

    public void initMid(String txt){
        getMidTV().setText(txt);
    }


    public void initList(WorkDetailAdapterBean data){
        workDetailsListAdapter = new WorkDetailsListAdapter(context,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,ValueConstant.DIMEN_1));
        recyclerView.setAdapter(workDetailsListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
