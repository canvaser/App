package com.summer.nurse.ui.setting.backsetting.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;

import com.summer.app.R;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;
import com.summer.nurse.ui.setting.backsetting.adapter.Backsettingadapter;
import com.summer.nurse.ui.setting.setting.bean.dbbean.BackUIDBBean;

import java.util.ArrayList;

/**
 * Created by summer on 2016/12/31 13:58.
 */

public class BackSettingUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public BackSettingUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setText("界面列表");
    }

    public void initList(ArrayList<BackUIDBBean> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new Backsettingadapter(context, data));
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
