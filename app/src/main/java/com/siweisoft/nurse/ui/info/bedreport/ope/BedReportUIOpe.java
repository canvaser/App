package com.siweisoft.nurse.ui.info.bedreport.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.bedreport.adapter.BedReportListAdapter;
import com.siweisoft.nurse.ui.info.bedreport.bean.resbean.BedReportResBean;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    BedReportListAdapter bedReportListAdapter;

    ArrayList<BedReportResBean> data;

    public BedReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
    }

    public void initList(ArrayList<BedReportResBean> data){
        getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        getRecyclerView().addItemDecoration(new MyItemDecoration(context,1));
        bedReportListAdapter = new BedReportListAdapter(context,data);
        getRecyclerView().setAdapter(bedReportListAdapter);
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
