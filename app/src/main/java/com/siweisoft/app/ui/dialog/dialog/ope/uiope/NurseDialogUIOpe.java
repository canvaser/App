package com.siweisoft.app.ui.dialog.dialog.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.dialog.dialog.adapter.DialogAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseUIOpe;
import com.siweisoft.lib.util.AnimUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class NurseDialogUIOpe extends BaseUIOpe {

    @BindView(R.id.rcv_pop)
    RecyclerView recyclerView;

    @BindView(R.id.rcv_pop_left)
    RecyclerView leftRecycle;

    @BindView(R.id.rcv_pop_right)
    RecyclerView rightRecycle;

    public NurseDialogUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void showList(String[] strings, OnAppItemClickListener onAppItemClickListener) {
        recyclerView.setVisibility(View.VISIBLE);
        AnimUtil.getInstance().startAnim(context, recyclerView, R.anim.anim_scale_in);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration2(context, 1, com.siweisoft.lib.R.color.color_grey_300));
        DialogAdapter pupListAdapter = new DialogAdapter(context, strings);
        recyclerView.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(onAppItemClickListener);
    }

    public void showLeft(String[] strings, OnAppItemClickListener onAppItemClickListener) {
        leftRecycle.setVisibility(View.VISIBLE);
        AnimUtil.getInstance().startAnim(context, leftRecycle, R.anim.anim_scale_in);
        leftRecycle.setLayoutManager(new LinearLayoutManager(context));
        leftRecycle.addItemDecoration(new MyItemDecoration2(context, 1, com.siweisoft.lib.R.color.color_grey_300));
        DialogAdapter pupListAdapter = new DialogAdapter(context, strings);
        leftRecycle.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(onAppItemClickListener);
    }

    public void showRight(String[] strings, OnAppItemClickListener onAppItemClickListener) {
        rightRecycle.setVisibility(View.VISIBLE);
        AnimUtil.getInstance().startAnim(context, rightRecycle, R.anim.anim_scale_in);
        rightRecycle.setLayoutManager(new LinearLayoutManager(context));
        rightRecycle.addItemDecoration(new MyItemDecoration2(context, 1, R.color.color_grey_300));
        DialogAdapter pupListAdapter = new DialogAdapter(context, strings);
        rightRecycle.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(onAppItemClickListener);
    }


    public RecyclerView getLeftRecycle() {
        return leftRecycle;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public RecyclerView getRightRecycle() {
        return rightRecycle;
    }
}
