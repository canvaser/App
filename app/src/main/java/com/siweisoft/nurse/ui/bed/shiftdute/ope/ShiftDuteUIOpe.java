package com.siweisoft.nurse.ui.bed.shiftdute.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.shiftdute.adapter.ShiftDuteListAdpter;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<ShiftDuteResBean> data;

    ShiftDuteListAdpter shiftDuteListAdpter;

    public ShiftDuteUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void initList(ArrayList<ShiftDuteResBean> data){
        this.data = data;
        shiftDuteListAdpter = new ShiftDuteListAdpter(context,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(shiftDuteListAdpter);
    }
}
