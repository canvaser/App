package com.siweisoft.app.ui.document.document.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.document.document.adapter.DocumentDetailListAdapter;
import com.siweisoft.app.ui.document.document.bean.netbean.DocumentDetailResBean;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentDetailListUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public DocumentDetailListUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
    }

    public void init(String name) {
        if (name != null) {
            getMidTV().setText(name);
        }
    }

    public void initList(DocumentDetailResBean documentDetailResBean) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
        recyclerView.setAdapter(new DocumentDetailListAdapter(context, documentDetailResBean));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
