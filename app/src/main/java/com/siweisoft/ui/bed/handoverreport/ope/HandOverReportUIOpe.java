package com.siweisoft.ui.bed.handoverreport.ope;

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
import com.siweisoft.ui.bed.shiftdute.adapter.ShiftDuteListAdpter;
import com.siweisoft.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class HandOverReportUIOpe<A extends CommonUIFrag2> extends BaseNurseUIOpe<A> {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<ShiftDuteResBean> data;

    ShiftDuteListAdpter shiftDuteListAdpter;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    public HandOverReportUIOpe(Context context, View containerView, A frag) {
        super(context, containerView);
        this.frag = frag;
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("填写");
        getRightTV().setVisibility(View.VISIBLE);
        getRefreshLayout().setMaterialRefreshListener(frag);
    }

    public void initMid(String name) {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setSelected(true);
        getMidTV().setText(name);
    }


    public void initList(ArrayList<ShiftDuteResBean> data) {
        this.data = data;
        shiftDuteListAdpter = new ShiftDuteListAdpter(context, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(shiftDuteListAdpter);
    }

    public ShiftDuteListAdpter getShiftDuteListAdpter() {
        return shiftDuteListAdpter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ArrayList<ShiftDuteResBean> getData() {
        return data;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
