package com.summer.app.ui.check.checklist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ui.check.checklist.bean.bean.TitleBean;
import com.summer.app.ui.check.checklist.bean.resbean.CheckResBean;
import com.summer.app.ui.check.checklist.ope.CheckListFGMUIOpe;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.summer.lib.bean.reqbean.BaseNurseReqBean;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.check.checklist.bean.CheckDABean;
import com.summer.app.ui.check.checklist.bean.reqbean.UpdateCheckListReqBean;
import com.summer.app.ui.check.checklist.bean.resbean.CheckListResBean;
import com.summer.app.ui.check.checklist.ope.CheckDAOpe;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckListFGM extends BaseNurseFrag implements
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener {


    CheckListFGMUIOpe checkListFGMUIOpe;

    NurseNetOpe checkListNetOpe;
    CheckDAOpe checkDAOpe;


    CheckDABean checkDABean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkListFGMUIOpe = new CheckListFGMUIOpe(activity, getView());
        checkListNetOpe = new NurseNetOpe(activity);
        checkDAOpe = new CheckDAOpe();
        checkDABean = new CheckDABean();
        checkListFGMUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        checkListFGMUIOpe.getRefreshLayout().finishRefresh();
                    }
                });
            }
        });
        checkListFGMUIOpe.getMissionExpandView().setOnHeaderUpdateListener(this);
        checkListFGMUIOpe.getRefreshLayout().autoRefreshWithUI(0);

    }

    public void getData(final OnFinishListener onFinishListener) {
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
//        baseNurseReqBean.setBegin("2016-10-01");
//        baseNurseReqBean.setEnd("2016-12-01");
        checkListNetOpe.getCheckTasks(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    final CheckListResBean checkListResBean = GsonUtil.getInstance().fromJson(o.toString(), CheckListResBean.class);
                    checkDAOpe.setRes(checkListResBean.getData());
                    checkDAOpe.initData(checkListResBean.getData());
                    checkDAOpe.initData2(new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            ArrayList<CheckResBean> s = (ArrayList<CheckResBean>) o;
                            checkListFGMUIOpe.initList(s);
                            checkDAOpe.getTitles().clear();
                            for (int i = 0; i < checkListResBean.getData().size(); i++) {
                                checkDAOpe.getTitles().add(new TitleBean(checkListResBean.getData().get(i).getData().size(), checkListResBean.getData().get(i).getItemName()));
                            }
                            checkListFGMUIOpe.getCheckListAdapter().setOnAppItemsClickListener(CheckListFGM.this);
                            checkListFGMUIOpe.getMissionExpandView().requestRefreshHeader();
                            if (onFinishListener != null) {
                                onFinishListener.onFinish(o);
                            }
                        }
                    });
                } else {
                    if (onFinishListener != null) {
                        onFinishListener.onFinish(o);
                    }
                }
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_checklist;
    }


    @Override
    public View getPinnedHeader() {
        View headerView = LayoutInflater.from(activity).inflate(R.layout.list_head_check, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (checkDAOpe == null || checkDAOpe.getTitles() == null || firstVisibleGroupPos < 0 || checkDAOpe.getTitles().get(firstVisibleGroupPos) == null) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView count = (TextView) headerView.findViewById(R.id.tv_count);
        TextView name = (TextView) headerView.findViewById(R.id.tv_name);
        count.setText("总数:" + checkDAOpe.getTitles().get(firstVisibleGroupPos).getNum() + "");
        name.setText(checkDAOpe.getTitles().get(firstVisibleGroupPos).getTitle() + "");
    }

    @Override
    public void onAppItemClick(final int index, View view, final int position) {
        switch (view.getId()) {
            case R.id.ll_left:

                break;
            case R.id.tv_finish:
                final UpdateCheckListReqBean reqBean = new UpdateCheckListReqBean();
                if (checkListFGMUIOpe.getCheckListAdapter().getData().get(index).getData().get(position).getCheckStatus().equals("T")) {
                    reqBean.setStatus("F");
                } else {
                    reqBean.setStatus("T");
                }
                reqBean.setId(checkListFGMUIOpe.getCheckListAdapter().getData().get(index).getData().get(position).getId());
                checkListNetOpe.updateCheckStatus(reqBean, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            checkListFGMUIOpe.getCheckListAdapter().getData().get(index).getData().get(position).setCheckStatus(reqBean.getStatus());
                            checkListFGMUIOpe.getCheckListAdapter().notifyDataSetChanged();
                        }
                    }
                });
                break;
        }
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, MethodValue.getMissionSortStrs(), NurseDialogFrag.RIGHT, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        checkListFGMUIOpe.getRightTV().setText(textView.getText().toString());
                        checkDAOpe.setSort(textView.getText().toString());
                        checkDAOpe.initData2(new OnFinishListener() {
                            @Override
                            public void onFinish(Object o) {
                                ArrayList<CheckResBean> s = (ArrayList<CheckResBean>) o;
                                checkListFGMUIOpe.initList(s);
                                checkDAOpe.getTitles().clear();
                                for (int i = 0; i < s.size(); i++) {
                                    checkDAOpe.getTitles().add(new TitleBean(s.get(i).getData().size(), s.get(i).getItemName()));
                                }
                                checkListFGMUIOpe.getMissionExpandView().requestRefreshHeader();
                            }
                        });

                    }
                });
                break;
        }
    }
}
