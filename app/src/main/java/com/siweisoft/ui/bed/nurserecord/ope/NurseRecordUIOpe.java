package com.siweisoft.ui.bed.nurserecord.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.ui.bed.nurserecord.adapter.NurseRecordListAdapter;
import com.siweisoft.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class NurseRecordUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    NurseRecordListAdapter nurseRecordListAdapter;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    public NurseRecordUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setVisibility(View.VISIBLE);
        getBackTV().setVisibility(View.VISIBLE);
    }

    public void initTile(String str) {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setSelected(true);
        getMidTV().setText(str);
    }

    public void initList(ArrayList<NurseRecordResBean> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
        nurseRecordListAdapter = new NurseRecordListAdapter(context, data);
        recyclerView.setAdapter(nurseRecordListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public NurseRecordListAdapter getNurseRecordListAdapter() {
        return nurseRecordListAdapter;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
