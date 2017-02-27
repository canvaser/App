package com.siweisoft.nurse.ui.bed.addmypatient.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.addmypatient.adapter.AddMyPatientListAdapter;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.AddMyPatientAdapterBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.iv_select)
    ImageView selectIV;

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    ArrayList<AddMyPatientAdapterBean> list = new ArrayList<>();


    ArrayList<AddMyPatientAdapterBean> listSelect = new ArrayList<>();

    AddMyPatientListAdapter addMyPatientListAdapter;

    public AddMyPatientUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("选择病人数");
        getRightTV().setText("完成");
        getRightTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<AddMyPatientAdapterBean> resBeen){

        list.clear();
        list.addAll(resBeen);
        recyclerView.addItemDecoration(new MyItemDecoration(context,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if(addMyPatientListAdapter==null){
            addMyPatientListAdapter = new AddMyPatientListAdapter(context,list);
            recyclerView.setAdapter(addMyPatientListAdapter);
        }else{
            addMyPatientListAdapter.notifyDataSetChanged();
        }
        refreshMid();
    }

    public void refreshMid(){
        getListSelect().clear();
        for(int i=0;i<getList().size();i++){
            if(getList().get(i).isSelect()){
                getListSelect().add(getList().get(i));
            }
        }
        getMidTV().setText("选择病人数:"+(getListSelect().size()==0?"":getListSelect().size()));
    }

    public AddMyPatientListAdapter getAddMyPatientListAdapter() {
        return addMyPatientListAdapter;
    }

    public ArrayList<AddMyPatientAdapterBean> getList() {
        return list;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ImageView getSelectIV() {
        return selectIV;
    }

    public ArrayList<AddMyPatientAdapterBean> getListSelect() {
        return listSelect;
    }
}
