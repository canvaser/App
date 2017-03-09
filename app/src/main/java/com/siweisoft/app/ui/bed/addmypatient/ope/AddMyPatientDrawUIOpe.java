package com.siweisoft.app.ui.bed.addmypatient.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.app.ui.bed.addmypatient.adapter.AddMyPatientDrawListAdapter;
import com.siweisoft.app.ui.bed.addmypatient.bean.AddMyPatientAdapterBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientDrawUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<AddMyPatientAdapterBean> list = new ArrayList<>();

    AddMyPatientDrawListAdapter addMyPatientListAdapter;

    public AddMyPatientDrawUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("选择病人数");
        getRightTV().setText("完成");
        getRightTV().setSelected(true);
    }

    public void initList(ArrayList<AddMyPatientAdapterBean> resBeen) {
        list.clear();
        list.addAll(resBeen);
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if (addMyPatientListAdapter == null) {
            addMyPatientListAdapter = new AddMyPatientDrawListAdapter(context, list);
            recyclerView.setAdapter(addMyPatientListAdapter);
        } else {
            addMyPatientListAdapter.notifyDataSetChanged();
        }

    }

    public AddMyPatientDrawListAdapter getAddMyPatientListAdapter() {
        return addMyPatientListAdapter;
    }

    public ArrayList<AddMyPatientAdapterBean> getList() {
        return list;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
