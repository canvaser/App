package com.siweisoft.nurse.ui.document.document.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.document.document.adapter.DocumentListAdapter;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListResBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-15.
 */
public class DocumentListUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public DocumentListUIOpe(Context context, View containerView) {
        super(context, containerView);
    }


    public void initList(DocumentListResBean documentListResBean){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,2));
        recyclerView.setAdapter(new DocumentListAdapter(context,documentListResBean));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
