package com.summer.lib.base.ui.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.summer.lib.R;
import com.summer.lib.base.ui.adapter.PupListAdapter;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.util.menu.popup.PopupUtil;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BaseNurseUIOpe<A extends CommonUIFrag2> extends BaseUIWithTitleOpe {


    protected A frag;


    public BaseNurseUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void showMidList(Context context, String[] strings, View v, int type, OnAppItemClickListener listener) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.pup_list, null);
        RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 1, com.summer.lib.R.color.color_base_graybg));
        PupListAdapter pupListAdapter = new PupListAdapter(context, strings);
        recyclerView.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(listener);
        PopupUtil.getInstance().show(context, view1, v, type);
    }

    public void showMidList(Context context, ArrayList strings, View v, int type, OnAppItemClickListener listener) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.pup_list, null);
        RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 1, com.summer.lib.R.color.color_base_graybg));
        PupListAdapter pupListAdapter = new PupListAdapter(context, strings);
        recyclerView.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(listener);
        PopupUtil.getInstance().show(context, view1, v, type);
    }

    public A getFrag() {
        return frag;
    }

}
