package com.summer.app.ui.addwater.addwater.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.view.ItemDecoration.MyItemDecoration2;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.app.ui.addwater.addwater.adapter.AddWaterDetailAdapter;
import com.summer.app.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;

import java.util.List;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-17.
 */
public class AddWaterDetailUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public AddWaterDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("补液卡详情");
    }

    public void initList(List<AddWaterListResBean.DataBean.FilesBean> filesBeans) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration2(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(new AddWaterDetailAdapter(context, filesBeans));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
