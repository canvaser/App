package com.siweisoft.nurse.ui.info.checkbook.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.checkbook.adapter.CheckBookAdapter;
import com.siweisoft.nurse.ui.info.checkbook.bean.resbean.CheckBookResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckBookUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    CheckBookAdapter checkBookAdapter;

    ArrayList<CheckBookResBean> data;

    public CheckBookUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }

    private void init(){

        getMidTV().setText("点物本");
        getBackTV().setText("返回");
        getBackTV().setSelected(true);

        getRightTV().setText("增加");
        getRightTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<CheckBookResBean> data){
        this.data =data;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,1));
        checkBookAdapter = new CheckBookAdapter(context,data);
        recyclerView.setAdapter(checkBookAdapter);
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public CheckBookAdapter getCheckBookAdapter() {
        return checkBookAdapter;
    }

    public ArrayList<CheckBookResBean> getData() {
        return data;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }
}
