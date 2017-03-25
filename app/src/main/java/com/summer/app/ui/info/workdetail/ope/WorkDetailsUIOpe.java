package com.summer.app.ui.info.workdetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.info.workdetail.adapter.WorkDetailsListAdapter;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class WorkDetailsUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    WorkDetailsListAdapter workDetailsListAdapter;


    public WorkDetailsUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }


    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }

    public void initMid(String txt) {
        getMidTV().setText(txt);
    }


    public void initList(WorkDetailAdapterBean data) {
        workDetailsListAdapter = new WorkDetailsListAdapter(context, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(workDetailsListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
