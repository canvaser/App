package com.summer.app.ui.addwater.addwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.summer.app.R;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.summer.app.ui.addwater.addwater.bean.uibean.AddWaterListHeadUIBean;
import com.summer.app.ui.addwater.addwater.ope.daope.AddWaterListDAOpe;
import com.summer.app.ui.addwater.addwater.ope.uiope.AddWaterListUIOpe;
import com.summer.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.summer.lib.base.ui.adapter.AppBaseExpandableListAdapter;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.base.ui.netadapter.DelayUINetAdapter;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.lib.util.dialog.DialogUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.pickerview.TimePickerDialog;
import com.summer.lib.view.pickerview.data.Type;
import com.summer.lib.view.pickerview.listener.OnDateSetListener;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;

import java.io.Serializable;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-17.
 */
//补液卡
public class AddWaterListFrag2 extends CommonUIFrag2<AddWaterListUIOpe<AddWaterListFrag2>, AddWaterListDAOpe<AddWaterListFrag2>>
        implements PinnedHeaderExpandableListView.OnHeaderUpdateListener, OnAppItemsClickListener {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!baseOpes.getDaOpe().canGoOn()) {
            return;
        }
        baseOpes.getDaOpe().setPatientAdditionDAOpe((PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA));
        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }


    @Override
    public View getPinnedHeader() {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_head_addwater, null);
        view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return view;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (baseOpes.getDaOpe() == null || baseOpes.getDaOpe().getAddWaterListResBean() == null || firstVisibleGroupPos < 0 || baseOpes.getDaOpe().getAddWaterListResBean().getData().get(firstVisibleGroupPos) == null) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        AddWaterListHeadUIBean uiBean = new AddWaterListHeadUIBean(activity, headerView);
        uiBean.getNameTV().setText(StringUtil.getStr(baseOpes.getDaOpe().getAddWaterListResBean().getData().get(firstVisibleGroupPos).getAdvCon() + baseOpes.getDaOpe().getAddWaterListResBean().getData().get(firstVisibleGroupPos).getStart()));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA, (Serializable) view.getTag(R.id.data));
        FragManager.getInstance().startFragmentForResult(getFragmentManager(), this.index, new AddWaterDetailFrag(), bundle, ValueConstant.CODE_REQUSET1);
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                DialogUtil.showTimePick(activity, getFragmentManager(), "date", Type.ALL, new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        baseOpes.getDaOpe().setStartTime(DateFormatUtil.convent_yyyyMMddHHMM(new Date(millseconds)));
                        baseOpes.getDaOpe().setEndtime(DateFormatUtil.getTomorromTimeYYYYMMdd() + " 00:00");
                        baseOpes.getUiOpe().getRefreshLayout().autoRefresh();
                    }
                });
                break;
        }
    }

    @Override
    public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
        SimpleNetOpe.addwater_list(activity, baseOpes.getDaOpe().getPatientAdditionDAOpe().getPatientBedResBean().get住院号(), "71", baseOpes.getDaOpe().getStartTime(), baseOpes.getDaOpe().getEndtime(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    baseOpes.getDaOpe().setAddWaterListResBean(GsonUtil.getInstance().fromJson(o.toString(), AddWaterListResBean.class));
                    baseOpes.getUiOpe().initList(baseOpes.getDaOpe().getAddWaterListResBean());
                    baseOpes.getUiOpe().getListView().setOnHeaderUpdateListener(AddWaterListFrag2.this);
                }
                baseOpes.getUiOpe().getRefreshLayout().finishRefresh();
                ((AppBaseExpandableListAdapter) (baseOpes.getUiOpe().getListView().getExpandableListAdapter())).setOnAppItemsClickListener(AddWaterListFrag2.this);
            }
        });
    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new AddWaterListUIOpe<AddWaterListFrag2>(activity, getView(), this), new AddWaterListDAOpe<AddWaterListFrag2>(activity, this));
        }
        return R.layout.frag_addwater_list;
    }
}
