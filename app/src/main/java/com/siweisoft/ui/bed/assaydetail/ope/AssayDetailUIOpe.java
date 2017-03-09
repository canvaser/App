package com.siweisoft.ui.bed.assaydetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.ui.bed.assay.bean.resbean.AssayListResBean;
import com.siweisoft.ui.bed.assaydetail.adapter.AssayDetailAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayDetailUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    AssayDetailAdapter assayDetailAdapter;

    public AssayDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<AssayListResBean.AssayDataBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
        assayDetailAdapter = new AssayDetailAdapter(context, list);
        recyclerView.setAdapter(assayDetailAdapter);
    }


}
