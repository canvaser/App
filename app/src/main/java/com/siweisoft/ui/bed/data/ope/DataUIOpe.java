package com.siweisoft.ui.bed.data.ope;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.ui.bed.data.adapter.DataAdapter3;
import com.siweisoft.ui.bed.data.adapter.DataAdapter4;
import com.siweisoft.ui.bed.data.bean.adatperbean.DataAdapterBean;
import com.siweisoft.ui.bed.patient.ope.PatientAdditionDAOpe;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class DataUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.elv_data)
    PinnedHeaderExpandableListView listView;

    @Nullable
    @BindView(R.id.ll_data_container)
    LinearLayout rootV;

    @Nullable
    @BindView(R.id.tv_date)
    TextView dateTV;


    ArrayList<View> containers = new ArrayList<>();


    ArrayList<LinearLayout> leftV = new ArrayList<>();

    ArrayList<RecyclerView> recyclerViews = new ArrayList<>();

    DataAdapter4 dataAdapter;

    ArrayList<DataAdapterBean> list = new ArrayList<>();


    public DataUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();

    }

    private void init() {

        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getRightTV().setText("录入");
        getRightTV().setSelected(true);
        getRightTV().setVisibility(View.VISIBLE);
        getMidTV().setSelected(true);
        getMidTV().setVisibility(View.VISIBLE);
        getDateTV().setText(StringUtil.getStr(DateFormatUtil.convent_yyyyMMdd(new Date())));
    }

    public void initTitle(PatientAdditionDAOpe patientAdditionDAOpe) {
        getMidTV().setText(patientAdditionDAOpe.getPatientBedResBean().get住院号() + "" + patientAdditionDAOpe.getPatientBedResBean().get姓名());
    }

    public void init(ArrayList<DataAdapterBean> list) {
        this.list.clear();
        this.list.addAll(list);
        leftV.clear();
        recyclerViews.clear();
        containers.clear();
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_container_data, null);
            //rootV.addView(view,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            containers.add(view);
            leftV.add((LinearLayout) view.findViewById(R.id.ll_left));
            recyclerViews.add((RecyclerView) view.findViewById(R.id.rcv_rcv));
        }

        for (int i = 0; i < leftV.size(); i++) {

            for (int j = 0; j < list.get(i).getTitle().size(); j++) {
                View v = LayoutInflater.from(context).inflate(R.layout.list_data, null);
                leftV.get(i).addView(v, new LinearLayout.LayoutParams(ValueConstant.DIMEN_1 * 100, ValueConstant.DIMEN_1 * 40));
                TextView textView = (TextView) v.findViewById(R.id.tv_txt);
                if (j == list.get(i).getTitle().size() - 1 && i != leftV.size() - 1) {
                    ViewGroup.LayoutParams p = textView.getLayoutParams();
                    p.height = ValueConstant.DIMEN_1 * 40;
                    textView.setLayoutParams(p);
                }
                if (j % 2 == 0) {
                    textView.setBackgroundColor(Color.WHITE);
                } else {
                    textView.setBackgroundColor(context.getResources().getColor(R.color.light_pink));
                }
                textView.setText(list.get(i).getTitle().get(j));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            recyclerViews.get(i).setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            if (i == list.size() - 1) {
                recyclerViews.get(i).setAdapter(new DataAdapter3(context, list.get(i), false));
            } else {
                recyclerViews.get(i).setAdapter(new DataAdapter3(context, list.get(i)));
            }
        }
    }

    public void init2() {
        if (dataAdapter == null) {
            dataAdapter = new DataAdapter4(context, containers, list);
            listView.setAdapter(dataAdapter);
            for (int i = 0; i < dataAdapter.getGroupCount(); i++) {
                listView.expandGroup(i);
            }
        } else {
            dataAdapter.notifyDataSetChanged();
        }

    }

    public void initLeftListener(View.OnClickListener onClickListener) {
        for (int i = 0; i < getLeftV().size(); i++) {
            ViewGroup group = getLeftV().get(i);
            for (int j = 0; j < group.getChildCount(); j++) {
                group.getChildAt(j).setTag(R.id.type, "left");
                group.getChildAt(j).setTag(R.id.groupposition, i);
                group.getChildAt(j).setTag(R.id.childposition, j);
                group.getChildAt(j).setOnClickListener(onClickListener);
            }
        }
    }


    public PinnedHeaderExpandableListView getListView() {
        return listView;
    }

    public ArrayList<DataAdapterBean> getList() {
        return list;
    }

    public ArrayList<RecyclerView> getRecyclerViews() {
        return recyclerViews;
    }

    public ArrayList<LinearLayout> getLeftV() {
        return leftV;
    }

    @Nullable
    public TextView getDateTV() {
        return dateTV;
    }

    public DataAdapter4 getDataAdapter() {
        return dataAdapter;
    }

    public ArrayList<View> getContainers() {
        return containers;
    }


}
