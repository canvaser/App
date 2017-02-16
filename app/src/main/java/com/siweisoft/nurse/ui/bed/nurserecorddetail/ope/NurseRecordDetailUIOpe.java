package com.siweisoft.nurse.ui.bed.nurserecorddetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.nurserecord.adapter.NurseRecordListAdapter;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.adapter.NurseRecordDetailListAdapter;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordDetailUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    NurseRecordDetailListAdapter nurseRecordDetailListAdapter;

    public NurseRecordDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
    }

    public void initList(NurseRecordListResBean listResBean){
        nurseRecordDetailListAdapter = new NurseRecordDetailListAdapter(context,listResBean.getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(nurseRecordDetailListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
