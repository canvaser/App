package com.siweisoft.app.ui.bed.advice.ope;

import android.content.Context;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.nursevalue.DataValue;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.app.ui.bed.advice.adapter.AdviceListAdapter;
import com.siweisoft.app.ui.bed.advice.bean.resbean.AdviceResBean;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class AdviceUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView doubleExpandView;


    @BindView(R.id.refresh)
    MaterialRefreshLayout materialRefreshLayout;

    AdviceListAdapter adviceListAdapter;

    public static String[] strings = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};


    HashMap<String, ArrayList<AdviceResBean>> hashMap = new HashMap<>();

    public AdviceUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();

    }


    private void init() {
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getRightTV().setSelected(true);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("日历");
        getBackTV().setVisibility(View.VISIBLE);
    }

    public void initTitle(String title) {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText(title);
        getMidTV().setSelected(true);
    }

    public void initAdviceList(HashMap<String, ArrayList<AdviceResBean>> hashMap) {
        this.hashMap = hashMap;
        adviceListAdapter = new AdviceListAdapter(context, this.hashMap);
        doubleExpandView.setGroupIndicator(null);
        doubleExpandView.setAdapter(adviceListAdapter);
        for (int i = 0; i < DataValue.STATUS_TYPE_TIME.size(); i++) {
            doubleExpandView.expandGroup(i);
        }
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

    public MaterialRefreshLayout getMaterialRefreshLayout() {
        return materialRefreshLayout;
    }
}
