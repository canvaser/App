package com.summer.app.ui.info.bedcheck.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.info.bedcheck.bean.resbean.BedCheckResBean;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.info.bedcheck.adapter.BedCheckListAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedCheckUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<BedCheckResBean> data;


    BedCheckListAdapter bedCheckListAdapter;

    public BedCheckUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setText("我的巡视");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<BedCheckResBean> data) {
        this.data = data;
        bedCheckListAdapter = new BedCheckListAdapter(context, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 1));

        recyclerView.setAdapter(bedCheckListAdapter);

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
