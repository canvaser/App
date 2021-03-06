package com.summer.app.ui.info.bedcheck.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.info.bedcheck.bean.reqbean.WriteBedCheckReqBean;
import com.summer.app.ui.info.bedcheck.bean.resbean.BedCheckListResBean;
import com.summer.app.ui.info.bedcheck.ope.BedCheckDAOpe;
import com.summer.app.ui.info.bedcheck.ope.BedCheckUIOpe;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.menu.popup.PopupUtil;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.lib.base.ui.adapter.PupListAdapter;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedCheckFrag extends BaseNurseFrag {


    BedCheckUIOpe bedCheckUIOpe;


    NurseNetOpe bedCheckNetOpe;

    BedCheckDAOpe bedCheckDAOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bedCheckNetOpe = new NurseNetOpe(activity);
        bedCheckUIOpe = new BedCheckUIOpe(activity, getView());
        bedCheckDAOpe = new BedCheckDAOpe(activity);
        bedCheckUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefreshingDelay();
                    }
                });
            }
        });
        bedCheckUIOpe.getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getData(final OnFinishListener listener) {
        bedCheckNetOpe.getWardInspectionList(new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    BedCheckListResBean bedCheckListResBean = GsonUtil.getInstance().fromJson(o.toString(), BedCheckListResBean.class);
                    bedCheckDAOpe.setData(bedCheckListResBean.getData());
                    bedCheckUIOpe.initList(bedCheckDAOpe.getSelectData());
                }
                if (listener != null) {
                    listener.onFinish(o);
                }
            }
        });
    }

    public void writeData(WriteBedCheckReqBean reqBean) {
        SimpleNetOpe.writeWardInspectionInfo(activity, reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                bedCheckUIOpe.getRefreshLayout().autoRefreshWithUI(0);
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_bedcheck;
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list, null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity, 2));
                String[] strings = new String[]{"我的巡视", "病房巡视"};
                PupListAdapter pupListAdapter = new PupListAdapter(activity, strings);
                recyclerView.setAdapter(pupListAdapter);
                pupListAdapter.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        bedCheckDAOpe.setPosition(position);
                        bedCheckUIOpe.initList(bedCheckDAOpe.getSelectData());
                        PopupUtil.getInstance().dimess();
                    }
                });
                PopupUtil.getInstance().show(activity, view1, v);
                break;
        }
    }
}
