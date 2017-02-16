package com.siweisoft.nurse.ui.info.infolist.ope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.infolist.adapter.InfoListAdapter;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class InfoListFGMUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    InfoListAdapter infoListAdapter;

    public InfoListFGMUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }

    private void init(){

        getMidTV().setText("信息");

        recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        recyclerView.addItemDecoration(new MyItemDecoration(context,1));
        infoListAdapter = new InfoListAdapter(context);
        recyclerView.setAdapter(infoListAdapter);
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public InfoListAdapter getInfoListAdapter() {
        return infoListAdapter;
    }
}
