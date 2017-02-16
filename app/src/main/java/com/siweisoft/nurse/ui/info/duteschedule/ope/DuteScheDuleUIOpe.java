package com.siweisoft.nurse.ui.info.duteschedule.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.duteschedule.adapter.DuteScheDuleListAadpter;
import com.siweisoft.nurse.ui.info.duteschedule.bean.resbean.DuteScheDuleResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;


    DuteScheDuleListAadpter duteScheDuleListAadpter;

    private ArrayList<DuteScheDuleResBean> data;

    public DuteScheDuleUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("信息");
        getMidTV().setText("排班表");

    }


    public void initList(ArrayList<DuteScheDuleResBean> data){
        this.data =data;
        duteScheDuleListAadpter = new DuteScheDuleListAadpter(context,this.data);
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
