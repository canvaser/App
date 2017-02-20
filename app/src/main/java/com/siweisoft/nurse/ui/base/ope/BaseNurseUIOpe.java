package com.siweisoft.nurse.ui.base.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseUIWithTitleOpe;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BaseNurseUIOpe extends BaseUIWithTitleOpe {

    public BaseNurseUIOpe(Context context, View containerView) {
        super(context, containerView);
    }


    public void showMidList(Context context,String[] strings ,View v,int type,OnAppItemClickListener listener){
        View view1 = LayoutInflater.from(context).inflate(R.layout.pup_list,null);
        RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,1, com.siweisoft.lib.R.color.color_base_graybg));
        PupListAdapter pupListAdapter = new PupListAdapter(context,strings);
        recyclerView.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(listener);
        PopupUtil.getInstance().show(context,view1,v,type);
    }

    public void showMidList(Context context, ArrayList strings , View v, int type, OnAppItemClickListener listener){
        View view1 = LayoutInflater.from(context).inflate(R.layout.pup_list,null);
        RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration(context,1, com.siweisoft.lib.R.color.color_base_graybg));
        PupListAdapter pupListAdapter = new PupListAdapter(context,strings);
        recyclerView.setAdapter(pupListAdapter);
        pupListAdapter.setOnAppItemClickListener(listener);
        PopupUtil.getInstance().show(context,view1,v,type);
    }
}
