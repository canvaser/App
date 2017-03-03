package com.siweisoft.nurse.ui.addwater.addwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppBaseExpandableListAdapter;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseOpes;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ope.SimpleNetOpe;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.nurse.ui.addwater.addwater.bean.uibean.AddWaterListHeadUIBean;
import com.siweisoft.nurse.ui.addwater.addwater.ope.daope.AddWaterListDAOpe;
import com.siweisoft.nurse.ui.addwater.addwater.ope.uiope.AddWaterListUIOpe;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;

import java.io.Serializable;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-17.
 */
//补液卡
public class AddWaterListFrag2 extends CommonUIFrag2<AddWaterListUIOpe<AddWaterListFrag>, AddWaterListDAOpe<AddWaterListFrag>>
        implements PinnedHeaderExpandableListView.OnHeaderUpdateListener, OnAppItemsClickListener {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!baseOpes.getDaOpe().canGoOn()) {
            return;
        }
        baseOpes.getDaOpe().setPatientAdditionDAOpe((PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA));
        baseOpes.getUiOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
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
        FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AddWaterDetailFrag(), bundle, ValueConstant.CODE_REQUSET1);
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
