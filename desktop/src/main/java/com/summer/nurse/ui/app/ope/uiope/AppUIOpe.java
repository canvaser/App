package com.summer.nurse.ui.app.ope.uiope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.nurse.ui.app.adapter.AppAdapter;
import com.summer.nurse.ui.app.bean.dbbean.AppDBBean;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.recycle)
    RecyclerView recyclerView;


    public AppUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void initList(ArrayList<AppDBBean> data) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5));
        recyclerView.setAdapter(new AppAdapter(context, data));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
