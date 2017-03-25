package com.summer.app.ui.info.addwaterlist.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.summer.app.ui.addwater.addwater.fragment.AddWaterListFrag2;
import com.summer.lib.base.ui.adapter.AppBaseExpandableListAdapter;
import com.summer.lib.base.ui.netadapter.DelayUINetAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;

/**
 * Created by ${viwmox} on 2017-03-22.
 */

public class WaterListFrag extends AddWaterListFrag2 {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
        SimpleNetOpe.addwater_list_ward(activity, MethodValue.getArea().getWardcode(), "71", baseOpes.getDaOpe().getStartTime(), baseOpes.getDaOpe().getEndtime(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    baseOpes.getDaOpe().setAddWaterListResBean(GsonUtil.getInstance().fromJson(o.toString(), AddWaterListResBean.class));
                    baseOpes.getUiOpe().initList(baseOpes.getDaOpe().getAddWaterListResBean());
                    baseOpes.getUiOpe().getListView().setOnHeaderUpdateListener(WaterListFrag.this);
                    ((AppBaseExpandableListAdapter) (baseOpes.getUiOpe().getListView().getExpandableListAdapter())).setOnAppItemsClickListener(WaterListFrag.this);
                }
                baseOpes.getUiOpe().getRefreshLayout().finishRefresh();
            }
        });
    }


}
