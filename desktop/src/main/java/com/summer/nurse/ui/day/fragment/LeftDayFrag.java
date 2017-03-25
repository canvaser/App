package com.summer.nurse.ui.day.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.base.ui.interf.view.OnAppItemLongClickListener;
import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.summer.nurse.ui.day.adapter.LeftDayAdapter;
import com.summer.nurse.ui.day.bean.dbbean.DayDBBean;
import com.summer.nurse.ui.day.ope.dbope.DayAddDBOpe;
import com.summer.nurse.ui.day.ope.uiope.LeftDayUIOpe;
import com.summer.util.SheetDialogUtil;
import com.summer.util.data.FormatUtil;
import com.summer.view.bottomdialogmenuview.BottomDialogMenuView;
import com.summer.view.refreshlayout.MaterialRefreshLayout;
import com.summer.view.refreshlayout.MaterialRefreshListener;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class LeftDayFrag extends BaseNurseFragWithoutTitle<LeftDayUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> implements OnAppItemLongClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            setArguments(new Bundle());
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().getBefore(FormatUtil.getInstance().getNowHHMMTime()));
        ((LeftDayAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(this);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().getBefore(FormatUtil.getInstance().getNowHHMMTime()));
                materialRefreshLayout.finishRefresh();
                ((LeftDayAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(LeftDayFrag.this);
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_leftday;
    }

    @Override
    public BaseNurseOpes<LeftDayUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new LeftDayUIOpe(activity, getView()), null, new DayAddDBOpe(activity, new DayDBBean()), null);
        }
        return baseNurseOpes;
    }

    @Override
    public void onAppItemLongClick(View view, int position) {
        final DayDBBean dayDBBean = (DayDBBean) view.getTag(R.id.data);
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, new String[]{"删除"});
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                switch (textView.getText().toString()) {
                    case "删除":
                        getOpe().getBaseDBOpe().delete(dayDBBean.getId());
                        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().getBefore(FormatUtil.getInstance().getNowHHMMTime()));
                        ((LeftDayAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(LeftDayFrag.this);
                        break;
                }
                SheetDialogUtil.getInstance().dismess();
            }
        });

    }
}
