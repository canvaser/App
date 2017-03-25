package com.summer.app.ui.info.checkbookdetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.info.checkbookdetail.bean.reqbean.CheckBookDetailReqBean;
import com.summer.app.ui.info.checkbookdetail.ope.CheckBookDetailUIOpe;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.ui.info.checkbook.bean.resbean.CheckBookResBean;
import com.summer.app.ui.info.checkbookdetail.bean.resbean.CheckBookResbean;
import com.summer.app.ui.info.checkbookdetail.bean.uibean.CheckBookDetailHeadUIBean;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookDetailFrag extends BaseNurseFrag implements PinnedHeaderExpandableListView.OnHeaderUpdateListener {


    CheckBookDetailUIOpe checkBookDetailUIOpe;

    NurseNetOpe checkBookDetailNetOpe;

    CheckBookResBean checkBookResBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        checkBookResBean = (CheckBookResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        checkBookDetailUIOpe = new CheckBookDetailUIOpe(activity, getView());
        checkBookDetailNetOpe = new NurseNetOpe(activity);
        checkBookDetailUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
        checkBookDetailUIOpe.getListView().setOnHeaderUpdateListener(this);
        checkBookDetailUIOpe.getRefreshLayout().autoRefreshWithUI(0);

    }

    public void getData(final OnFinishListener onFinishListener) {
        CheckBookDetailReqBean reqBean = new CheckBookDetailReqBean();
        reqBean.setFileid(checkBookResBean.getFileid());
        checkBookDetailNetOpe.getInstrumentCountData(reqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    CheckBookResbean checkBookResbean = GsonUtil.getInstance().fromJson(o.toString(), CheckBookResbean.class);
                    checkBookDetailUIOpe.initList(checkBookResbean.getData());
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_checkbookdetail;
    }

    @Override
    public View getPinnedHeader() {
        CheckBookDetailHeadUIBean checkHeadUIBean = null;
        View convertView = LayoutInflater.from(activity).inflate(R.layout.list_head_checkbookdetail, null);
        checkHeadUIBean = (CheckBookDetailHeadUIBean) convertView.getTag();
        convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ValueConstant.DIMEN_1 * 40));
        return convertView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (firstVisibleGroupPos < 0 || checkBookDetailUIOpe == null || checkBookDetailUIOpe.getData() == null) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        CheckBookDetailHeadUIBean checkHeadUIBean = new CheckBookDetailHeadUIBean(activity, headerView);
        checkHeadUIBean.getTimeTV().setText(StringUtil.getStr(checkBookDetailUIOpe.getData().get(firstVisibleGroupPos).getExectime()));
        checkHeadUIBean.getDuteTV().setText(StringUtil.getStr(checkBookDetailUIOpe.getData().get(firstVisibleGroupPos).getShift()));
        checkHeadUIBean.getNameTV().setText(StringUtil.getStr(checkBookDetailUIOpe.getData().get(firstVisibleGroupPos).getUsername()));
    }
}
