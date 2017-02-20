package com.siweisoft.nurse.ui.dialog.dialog.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseUIOpe;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.dialog.dialog.adapter.DialogAdapter;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class NurseDialogUIOpe extends BaseUIOpe{

    @BindView(R.id.rcv_pop)
    RecyclerView recyclerView;

    public NurseDialogUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void showList(String[] strings,OnAppItemClickListener onAppItemClickListener){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,1, com.siweisoft.lib.R.color.color_base_graybg));
        DialogAdapter pupListAdapter = new DialogAdapter(context,strings);
        recyclerView.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(onAppItemClickListener);
    }
}
