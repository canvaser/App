package com.summer.app.ui.info.duteschedule.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.info.duteschedule.adapter.DuteScheDuleListAadpter;
import com.summer.app.ui.info.duteschedule.bean.resbean.DuteScheDuleResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;


    DuteScheDuleListAadpter duteScheDuleListAadpter;

    private ArrayList<DuteScheDuleResBean> data;

    public DuteScheDuleUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("信息");
        getMidTV().setText("排班表");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }


    public void initList(ArrayList<DuteScheDuleResBean> data) {
        this.data = data;
        duteScheDuleListAadpter = new DuteScheDuleListAadpter(context, this.data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(duteScheDuleListAadpter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }


}
