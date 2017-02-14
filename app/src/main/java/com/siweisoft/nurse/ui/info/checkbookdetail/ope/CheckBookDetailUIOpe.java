package com.siweisoft.nurse.ui.info.checkbookdetail.ope;

import android.content.Context;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.checkbookdetail.adapter.CheckBookDetailListAdapter;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.resbean.CheckBookDetailItemsListResBean;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckBookDetailUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.elv_elv)
    PinnedHeaderExpandableListView listView;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    CheckBookDetailListAdapter checkBookAdapter;

    ArrayList<CheckBookDetailItemsListResBean> data;

    public CheckBookDetailUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }

    private void init(){

        getMidTV().setText("物品清点单");
        getBackTV().setText("返回");
        getBackTV().setSelected(true);

    }

    public void initList( ArrayList<CheckBookDetailItemsListResBean> data){
        this.data =data;
        checkBookAdapter = new CheckBookDetailListAdapter(context,data);
        listView.setAdapter(checkBookAdapter);
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public CheckBookDetailListAdapter getCheckBookAdapter() {
        return checkBookAdapter;
    }

    public ArrayList<CheckBookDetailItemsListResBean> getData() {
        return data;
    }

    public PinnedHeaderExpandableListView getListView() {
        return listView;
    }
}
