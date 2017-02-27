package com.siweisoft.nurse.ui.bed.assay.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.assay.adapter.AssayListAdapter;
import com.siweisoft.nurse.ui.bed.assay.bean.adapterbean.AssayAdapterBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AssayUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    AssayListAdapter assayListAdapter;


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    public AssayUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getRightTV().setText("日历");
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
    }

    public void initTitle(String title) {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText(title);
        getMidTV().setSelected(true);
    }

    public void initList(ArrayList<AssayAdapterBean> data){
        assayListAdapter = new AssayListAdapter(context,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,2));
        recyclerView.setAdapter(assayListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public AssayListAdapter getAssayListAdapter() {
        return assayListAdapter;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
