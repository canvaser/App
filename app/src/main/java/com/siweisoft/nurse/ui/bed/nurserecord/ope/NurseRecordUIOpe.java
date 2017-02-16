package com.siweisoft.nurse.ui.bed.nurserecord.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.nurserecord.adapter.NurseRecordListAdapter;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class NurseRecordUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    NurseRecordListAdapter nurseRecordListAdapter;


    public NurseRecordUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }
    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
    }

    public void initList(ArrayList<NurseRecordResBean> data){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,2));
        nurseRecordListAdapter = new NurseRecordListAdapter(context,data);
        recyclerView.setAdapter(nurseRecordListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public NurseRecordListAdapter getNurseRecordListAdapter() {
        return nurseRecordListAdapter;
    }
}
