package com.summer.nurse.ui.calendar.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.summer.app.R;
import com.summer.base.ui.id.BaseID;
import com.summer.base.ui.interf.OnFinishListener;
import com.summer.base.ui.interf.view.OnAppItemClickListener;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.ui.calendar.adapter.CalendarListAdapter;
import com.summer.nurse.ui.calendar.bean.netbean.DayBean;
import com.summer.nurse.ui.calendar.ope.daope.CalendarDAOpe;
import com.summer.nurse.ui.calendar.ope.netope.CalendarNetOpe;
import com.summer.nurse.ui.calendar.ope.uiope.CalendarUIOpe;
import com.summer.nurse.util.fragment.FragManager;
import com.summer.util.ToastUtil;
import com.summer.view.refreshlayout.MaterialRefreshLayout;
import com.summer.view.refreshlayout.MaterialRefreshListener;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class CalendarFrag extends BaseNurseFrag<CalendarUIOpe, CalendarNetOpe, BaseDBOpe, CalendarDAOpe> implements OnAppItemClickListener, OnDateSelectedListener {


    @Override
    public int getContainView() {
        return R.layout.frag_calendar;
    }

    @Override
    public BaseNurseOpes<CalendarUIOpe, CalendarNetOpe, BaseDBOpe, CalendarDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new CalendarUIOpe(activity, getView()), new CalendarNetOpe(activity), null, new CalendarDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getOpe().getBaseNetOpe().getNetRecordListWithDate(getOpe().getBaseDAOpe().getYear(), getOpe().getBaseDAOpe().getMonth(), getOpe().getBaseDAOpe().getDay(), new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        List<DayBean> data = (List<DayBean>) o;
                        getOpe().getBaseNurseUIOpe().initList(data);
                        getOpe().getBaseNurseUIOpe().getRefreshLayout().finishRefresh();
                        ((CalendarListAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(CalendarFrag.this);
                    }
                });
            }
        });
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(500);
        getOpe().getBaseNurseUIOpe().getCalendarPickerView().setOnDateChangedListener(this);
    }

    @OnClick({BaseID.ID_MID, BaseID.ID_RIGHT, BaseID.ID_BACK})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                if (getOpe().getBaseDAOpe().doubleClick(System.currentTimeMillis())) {
                    getOpe().getBaseNurseUIOpe().init();

                }
                break;
            case BaseID.ID_RIGHT:
                v.setSelected(!v.isSelected());
                if (v.isSelected()) {
                    getOpe().getBaseNurseUIOpe().coll();
                } else {
                    getOpe().getBaseNurseUIOpe().expand();
                }
                break;
        }
    }


    @Override
    public void onAppItemClick(View view, int position) {
        DayBean dayBean = (DayBean) view.getTag(R.id.data);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA, dayBean);
        FragManager.getInstance().startFragment(activity.getSupportFragmentManager(), 3, new DayRecordDetailFrag(), bundle);
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        int year = date.getYear();
        int month = date.getMonth() + 1;
        int day = date.getDay();
        ToastUtil.getInstance().show(activity, year + ":" + month + ":" + day);
        getOpe().getBaseNetOpe().getNetRecordListWithDate(year, month, day, new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                List<DayBean> data = (List<DayBean>) o;
                getOpe().getBaseNurseUIOpe().initList(data);
                getOpe().getBaseNurseUIOpe().getRefreshLayout().finishRefresh();
                ((CalendarListAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(CalendarFrag.this);
            }
        });

    }
}
