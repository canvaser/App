package com.siweisoft.nurse.ui.bed.assaydetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayResBean;
import com.siweisoft.nurse.ui.bed.assaydetail.adapter.AssayDetailAdapter;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayDetailUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    AssayDetailAdapter assayDetailAdapter;

    public AssayDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
    }

    public void initList(ArrayList<AssayResBean> list){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,2));
        assayDetailAdapter = new AssayDetailAdapter(context,list);
        recyclerView.setAdapter(assayDetailAdapter);
    }



}
