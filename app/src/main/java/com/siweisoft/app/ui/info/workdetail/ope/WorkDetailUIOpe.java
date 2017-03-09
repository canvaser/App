package com.siweisoft.app.ui.info.workdetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.app.ui.info.workdetail.adapter.WorkDetailListAdapter;
import com.siweisoft.app.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class WorkDetailUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_works)
    TextView tvWorks;


    WorkDetailListAdapter workDetailListAdapter;

    public WorkDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }


    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("工作明细");
    }

    public void inithead(int[] ints) {
        tvNum.setText("数量(" + StringUtil.getStr(ints[0]) + ")");
        tvWorks.setText("工作量(" + StringUtil.getStr(ints[1]) + ")");
    }

    public void initList(ArrayList<WorkDetailAdapterBean> data) {
        workDetailListAdapter = new WorkDetailListAdapter(context, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(workDetailListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public WorkDetailListAdapter getWorkDetailListAdapter() {
        return workDetailListAdapter;
    }

    public TextView getTvNum() {
        return tvNum;
    }

    public TextView getTvWorks() {
        return tvWorks;
    }
}
