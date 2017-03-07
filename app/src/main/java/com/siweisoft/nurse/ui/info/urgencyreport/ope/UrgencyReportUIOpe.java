package com.siweisoft.nurse.ui.info.urgencyreport.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.urgencyreport.adapter.UngencyReportListAdapter;
import com.siweisoft.nurse.ui.info.urgencyreport.bean.resbean.UrgencyReportResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class UrgencyReportUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    UngencyReportListAdapter ungencyReportListAdapter;

    ArrayList<UrgencyReportResBean> data = new ArrayList<>();

    public UrgencyReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setText("紧急报告");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<UrgencyReportResBean> data) {
        this.data.clear();
        this.data.addAll(data);
        if (ungencyReportListAdapter == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
            ungencyReportListAdapter = new UngencyReportListAdapter(context, this.data);
            recyclerView.addItemDecoration(new MyItemDecoration2(context, ValueConstant.DIMEN_1));
            recyclerView.setAdapter(ungencyReportListAdapter);
        } else {
            ungencyReportListAdapter.notifyDataSetChanged();
        }

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public UngencyReportListAdapter getUngencyReportListAdapter() {
        return ungencyReportListAdapter;
    }


    public ArrayList<UrgencyReportResBean> getData() {
        return data;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
