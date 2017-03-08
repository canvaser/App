package com.siweisoft.nurse.ui.info.bedreport.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.bedreport.adapter.BedReportListAdapter;
import com.siweisoft.nurse.ui.info.bedreport.bean.resbean.BedReportResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReportUIOpe extends BaseNurseUIOpe {


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

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setText("病床报告");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<BedReportResBean> data) {
        getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        getRecyclerView().addItemDecoration(new MyItemDecoration(context, 1));
        bedReportListAdapter = new BedReportListAdapter(context, data);
        getRecyclerView().setAdapter(bedReportListAdapter);
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
