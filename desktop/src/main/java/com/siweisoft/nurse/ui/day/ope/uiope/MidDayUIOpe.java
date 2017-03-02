package com.siweisoft.nurse.ui.day.ope.uiope;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.day.adapter.LeftDayAdapter;
import com.siweisoft.nurse.ui.day.bean.dbbean.DayDBBean;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.view.other.AppMaterialRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-03.
 */

public class MidDayUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    @BindView(R.id.refresh)
    AppMaterialRefreshLayout refreshLayout;


    public MidDayUIOpe(Context context, View containerView) {
        super(context, containerView);
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void initList(ArrayList<DayDBBean> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new LeftDayAdapter(context, data));
    }

    @Nullable
    @Override
    public AppMaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
