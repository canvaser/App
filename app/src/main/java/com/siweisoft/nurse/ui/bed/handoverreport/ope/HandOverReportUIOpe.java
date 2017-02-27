package com.siweisoft.nurse.ui.bed.handoverreport.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.shiftdute.adapter.ShiftDuteListAdpter;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class HandOverReportUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<ShiftDuteResBean> data;

    ShiftDuteListAdpter shiftDuteListAdpter;


    public HandOverReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("填写");
        getRightTV().setVisibility(View.VISIBLE);
    }

    public void initMid(String name){
        getMidTV().setSelected(true);
        getMidTV().setText(name);
    }



    public void initList(ArrayList<ShiftDuteResBean> data){
        this.data = data;
        shiftDuteListAdpter = new ShiftDuteListAdpter(context,data);
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
}
