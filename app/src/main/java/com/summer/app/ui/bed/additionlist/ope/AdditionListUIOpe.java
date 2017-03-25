package com.summer.app.ui.bed.additionlist.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.app.ui.bed.additionlist.adapter.AdditionListAdapter;
import com.summer.app.ui.bed.patient.bean.resbean.PatientAdditionResBean;
import com.summer.app.ui.home.bean.resbean.AdditionListResBean;
import com.summer.app.ui.home.bean.resbean.AdditionResbean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditionListUIOpe extends BaseNurseUIOpe {


    AdditionListAdapter additionListAdapter;

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<AdditionResbean> data = new ArrayList<>();


    public AdditionListUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }


    private void init() {
        getBackTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getRightTV().setSelected(true);
        getRightTV().setText("提交");

    }

    public void initList(ArrayList<PatientAdditionResBean> list, String position) {
        data.clear();
        String s = SPUtil.getInstance().getStr(ValueConstant.ADDITION_INFO);
        if (s != null) {

            AdditionListResBean resBean = GsonUtil.getInstance().fromJson(s, AdditionListResBean.class);
            for (int i = 0; i < resBean.getData().size(); i++) {
                switch (position) {
                    case "0":
                        if (resBean.getData().get(i).getCanSet().equals("Y") && resBean.getData().get(i).getType().equals("导管")) {
                            data.add(resBean.getData().get(i));
                        }
                        break;
                    case "1":
                        if (resBean.getData().get(i).getCanSet().equals("Y") && resBean.getData().get(i).getType().equals("关怀")) {
                            data.add(resBean.getData().get(i));
                        }
                        break;
                }
            }
            if (list != null && list.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (data.get(i).getName().equals(list.get(j).getValue())) {
                            data.get(i).setSelect(true);
                            break;
                        }
                    }
                }
            }

            additionListAdapter = new AdditionListAdapter(context, data);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.addItemDecoration(new MyItemDecoration(context, ValueConstant.DIMEN_1));
            recyclerView.setAdapter(additionListAdapter);
        }
    }

    public AdditionListAdapter getAdditionListAdapter() {
        return additionListAdapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ArrayList<AdditionResbean> getData() {
        return data;
    }
}
