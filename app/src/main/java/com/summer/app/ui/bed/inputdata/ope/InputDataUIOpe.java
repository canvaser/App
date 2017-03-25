package com.summer.app.ui.bed.inputdata.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.bed.data.bean.resbean.DataTemplateResBean;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.bed.inputdata.adapter.InputDataListAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class InputDataUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<DataTemplateResBean> list = new ArrayList<>();

    int p = 0;

    InputDataListAdapter inputDataListAdapter;


    public InputDataUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {

        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setSelected(true);
        getMidTV().setText("类型");
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("提交");
        getRightTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<DataTemplateResBean> list, int p) {
        this.list.clear();
        this.list.addAll(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        inputDataListAdapter = new InputDataListAdapter(context, this.list.get(p));
        recyclerView.setAdapter(inputDataListAdapter);
    }

    public void refreshList(int p) {
        this.p = p;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
        inputDataListAdapter = new InputDataListAdapter(context, this.list.get(p));
        recyclerView.setAdapter(inputDataListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ArrayList<DataTemplateResBean> getList() {
        return list;
    }

    public int getP() {
        return p;
    }
}
