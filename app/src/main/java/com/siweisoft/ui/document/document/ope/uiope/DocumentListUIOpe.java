package com.siweisoft.ui.document.document.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.ui.document.document.adapter.DocumentListAdapter;
import com.siweisoft.ui.document.document.bean.netbean.DocumentListResBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-15.
 */
public class DocumentListUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public DocumentListUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
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

    public void initUpdate(DocumentListResBean documentListResBean) {
        if (documentListResBean != null && documentListResBean.getData() != null && documentListResBean.getData().size() > 0
                && documentListResBean.getData().get(0).getType() != null
                && documentListResBean.getData().get(0).getType().equals(DocumentListResBean.DataBean.TYPE_NO_CHILD)) {
            getRightTV().setVisibility(View.VISIBLE);
            getRightTV().setText("修改");
            getRightTV().setSelected(true);
        }
    }


    public void initList(DocumentListResBean documentListResBean) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
        recyclerView.setAdapter(new DocumentListAdapter(context, documentListResBean));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
