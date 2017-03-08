package com.siweisoft.nurse.ui.info.checkbookdetail.ope;

import android.content.Context;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.info.checkbookdetail.adapter.CheckBookDetailListAdapter;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.resbean.CheckBookDetailItemsListResBean;

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

    private void init() {

        getMidTV().setText("物品清点单");
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<CheckBookDetailItemsListResBean> data) {
        this.data = data;
        checkBookAdapter = new CheckBookDetailListAdapter(context, data);
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
