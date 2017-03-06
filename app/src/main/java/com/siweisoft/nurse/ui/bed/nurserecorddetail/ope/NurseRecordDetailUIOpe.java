package com.siweisoft.nurse.ui.bed.nurserecorddetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.adapter.NurseRecordDetailListAdapter;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordDetailUIOpe<A extends CommonUIFrag2> extends BaseNurseUIOpe<A> {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    NurseRecordDetailListAdapter nurseRecordDetailListAdapter;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    public NurseRecordDetailUIOpe(Context context, View containerView, A a) {
        super(context, containerView);
        frag = a;
        init();
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setText("护理明细");
        getMidTV().setVisibility(View.VISIBLE);
        refreshLayout.setMaterialRefreshListener(frag);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
    }

    public void initList(NurseRecordListResBean listResBean) {
        nurseRecordDetailListAdapter = new NurseRecordDetailListAdapter(context, listResBean.getData());
        recyclerView.setAdapter(nurseRecordDetailListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public NurseRecordDetailListAdapter getNurseRecordDetailListAdapter() {
        return nurseRecordDetailListAdapter;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
