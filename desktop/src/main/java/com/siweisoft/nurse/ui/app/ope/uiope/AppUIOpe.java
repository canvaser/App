package com.siweisoft.nurse.ui.app.ope.uiope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.app.adapter.AppAdapter;
import com.siweisoft.nurse.ui.app.bean.dabean.AppDABean;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;

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
