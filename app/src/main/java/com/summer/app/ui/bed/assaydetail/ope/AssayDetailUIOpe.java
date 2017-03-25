package com.summer.app.ui.bed.assaydetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.bed.assay.bean.resbean.AssayListResBean;
import com.summer.app.ui.bed.assaydetail.adapter.AssayDetailAdapter;

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

    public void initTitle(String str) {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText(str);
    }

    public void initList(ArrayList<AssayListResBean.AssayDataBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
        assayDetailAdapter = new AssayDetailAdapter(context, list);
        recyclerView.setAdapter(assayDetailAdapter);
    }


}
