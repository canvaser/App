package com.summer.app.ui.setting.scanlist.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.setting.scanlist.adapter.ScanListAdapter;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.view.ItemDecoration.MyItemDecoration2;
import com.summer.app.db.bean.ScanDBBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-09.
 */
public class ScanListUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    public ScanListUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("二维码记录");

        getRightTV().setSelected(true);
        getRightTV().setText("清空");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void initList(ArrayList<ScanDBBean> scanList) {
        if (scanList == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration2(context, 2));
        recyclerView.setAdapter(new ScanListAdapter(context, scanList));
    }
}
