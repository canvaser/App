package com.siweisoft.nurse.ui.bed.advice.ope;

import android.content.Context;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseUIWithTitleOpe;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.base.view.DoubleExpandView;
import com.siweisoft.nurse.ui.bed.advice.adapter.AdviceListAdapter;
import com.siweisoft.nurse.ui.bed.advice.bean.resbean.AdviceResBean;
import com.siweisoft.nurse.ui.mission.missionlist.adapter.MissionListAdapter;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class AdviceUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView doubleExpandView;

    AdviceListAdapter adviceListAdapter;

    public static String[] strings = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13"};



    HashMap<String,ArrayList<AdviceResBean>> hashMap = new HashMap<>();

    public AdviceUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();

    }


    private void init(){
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
    }

    public void initAdviceList(HashMap<String,ArrayList<AdviceResBean>> hashMap){
        this.hashMap = hashMap;
        adviceListAdapter = new AdviceListAdapter(context,this.hashMap);
        doubleExpandView.setAdapter(adviceListAdapter);
    }


    public PinnedHeaderExpandableListView getDoubleExpandView() {
        return doubleExpandView;
    }

    public HashMap<String, ArrayList<AdviceResBean>> getHashMap() {
        return hashMap;
    }

    public AdviceListAdapter getAdviceListAdapter() {
        return adviceListAdapter;
    }
}
