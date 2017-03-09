package com.siweisoft.app.ui.addwater.addaddwater.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.app.ui.addwater.addaddwater.adapter.AddAddWaterAdapter;
import com.siweisoft.app.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.app.ui.addwater.addaddwater.bean.uibean.AddAddWaterUIBean;
import com.siweisoft.app.ui.addwater.addaddwater.ope.daope.AddAddWaterDAOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddAddWaterUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    @BindView(R.id.tv_start)
    TextView startTV;


    public AddAddWaterUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setText("增加补液卡");
        getMidTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("提交");
        getRightTV().setSelected(true);
    }

    public void sethead() {

    }

    public void initList(final AddAddWaterResBean aa) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration2(context, 2));
        final AddAddWaterDAOpe addAddWaterDAOpe = new AddAddWaterDAOpe(context);
        recyclerView.setAdapter(new AddAddWaterAdapter(context, aa));
    }

    public void setDishu(String dishu) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            AddAddWaterUIBean uiBean = (AddAddWaterUIBean) recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if (uiBean.getNameTV().getText().equals("滴速")) {
                uiBean.getTxtET().setFocusable(true);
                uiBean.getTxtET().setFocusableInTouchMode(true);
                uiBean.getTxtET().requestFocus();
                uiBean.getTxtET().setText(dishu);
                uiBean.getTxtET().clearFocus();
            }
        }

    }

    public void setleftBuyeLiang(String str) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            AddAddWaterUIBean uiBean = (AddAddWaterUIBean) recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if (uiBean.getNameTV().getText().equals("剩余补液量")) {
                uiBean.getTxtET().setFocusable(true);
                uiBean.getTxtET().setFocusableInTouchMode(true);
                uiBean.getTxtET().requestFocus();
                uiBean.getTxtET().setText(str);
                uiBean.getTxtET().clearFocus();
            }
        }

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public TextView getStartTV() {
        return startTV;
    }

}
