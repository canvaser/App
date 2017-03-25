package com.summer.nurse.ui.app.ope.uiope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.nurse.ui.app.adapter.AppGroupAdapter;
import com.summer.nurse.ui.app.bean.dbbean.AppGroupDBBean;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppGroupUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public AppGroupUIOpe(Context context, View containerView) {
        super(context, containerView);
        getMidTV().setText("分组列表");
    }

    public void initList(ArrayList<AppGroupDBBean> data) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.setAdapter(new AppGroupAdapter(context, data));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
