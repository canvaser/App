package com.siweisoft.nurse.ui.bed.inputdata.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Size;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateListResBean;
import com.siweisoft.nurse.ui.bed.data.ope.DataNetOpe;
import com.siweisoft.nurse.ui.bed.inputdata.ope.InputDataNetOpe;
import com.siweisoft.nurse.ui.bed.inputdata.ope.InputDataUIOpe;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class InputDataFrag extends BaseNurseFrag{


    InputDataUIOpe inputDataUIOpe;

    DataNetOpe dataNetOpe;

    InputDataNetOpe inputDataNetOpe ;

    PatientBedResBean resBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        inputDataUIOpe= new InputDataUIOpe(activity,getView());
        dataNetOpe = new DataNetOpe(activity);
        inputDataNetOpe = new InputDataNetOpe(activity);
        getTemplate();
    }

    @Override
    public int getContainView() {
        return R.layout.frag_inputdata;
    }

    public void getTemplate(){
        dataNetOpe.getRecordTemplate(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    DataTemplateListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),DataTemplateListResBean.class);
                    inputDataUIOpe.initList(resBean.getData(),0);
                }
            }
        });
    }

    @OnClick({BaseID.ID_MID,BaseID.ID_RIGHT})
    public void onClick(View view){
        switch (view.getId()){
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity,2));
                ArrayList<String> ss  = new ArrayList<>();
                for(int i=0;i<inputDataUIOpe.getList().size();i++){
                    ss.add(inputDataUIOpe.getList().get(i).getGroupname());
                }
                String[] strings = new String[ss.size()];
                strings= ss.toArray(strings);

                PupListAdapter p = new PupListAdapter(activity,strings);
                p.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        inputDataUIOpe.refreshList(position);
                        PopupUtil.getInstance().dimess();
                    }
                });
                recyclerView.setAdapter(p);
                PopupUtil.getInstance().show(activity,view1,view);
                break;
            case BaseID.ID_RIGHT:
                inputDataNetOpe.writeRecordData(inputDataUIOpe.getList().get(inputDataUIOpe.getP()), resBean.get住院号(), resBean.get关联病区号(), new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            FragManager.getInstance().finish(getFragmentManager(),index);
                        }
                    }
                });
                break;
        }
    }
}
