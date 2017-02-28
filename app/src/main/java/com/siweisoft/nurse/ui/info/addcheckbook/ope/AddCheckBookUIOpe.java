package com.siweisoft.nurse.ui.info.addcheckbook.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.addcheckbook.adapter.AddCheckBookListAdapter;
import com.siweisoft.nurse.ui.info.checkbook.bean.resbean.CheckBookResBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class AddCheckBookUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;


    AddCheckBookListAdapter addCheckBookListAdapter;

    public AddCheckBookUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("提交");
    }

    public void initMid(String name) {
        getMidTV().setText(name);
        getMidTV().setSelected(true);
    }

    public void initList(CheckBookResBean checkBookResBean) {
        addCheckBookListAdapter = new AddCheckBookListAdapter(context, checkBookResBean.getItems());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        recyclerView.setAdapter(addCheckBookListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
