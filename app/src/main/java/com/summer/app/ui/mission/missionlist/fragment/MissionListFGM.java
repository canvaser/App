package com.summer.app.ui.mission.missionlist.fragment;

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
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.addwater.addaddwater.fragment.AddAddWaterFrag;
import com.summer.app.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.summer.app.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionTimeOpe;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.OnNetFinishWithObjInter;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.LogUtil;
import com.summer.lib.util.NullUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.menu.popup.PopupUtil;
import com.summer.lib.util.system.HandleUtil;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.summer.app.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.summer.app.ui.mission.missionlist.ope.MissionListFGMUIOpe;
import com.summer.lib.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListFGM extends CommonUIFrag2<MissionListFGMUIOpe, AreaMessionDAOpe> implements
        PinnedHeaderExpandableListView.OnHeaderUpdateListener, OnAppItemsClickListener {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseOpes.getUiOpe().getRefreshLayout().setMaterialRefreshListener(this);
        baseOpes.getUiOpe().getMissionExpandView().setOnHeaderUpdateListener(this);
        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getMyTask(boolean cache, final boolean extend, final OnFinishListener onFinishListener) {
        final String type1 = baseOpes.getDaOpe().leftType;
        baseOpes.getUiOpe().getBackTV().setText(type1);
        final String type = baseOpes.getDaOpe().getHashMap().get(type1);
        if (type1.equals("历史")) {
            baseOpes.getDaOpe().timeArea = AreaMessionDAOpe.TIME_HISTORY;
        }
        String time = baseOpes.getDaOpe().timeArea;
        final String area = baseOpes.getDaOpe().areaType;
        final String sort = baseOpes.getDaOpe().rightSort;
        final String count = baseOpes.getDaOpe().count;
        baseOpes.getUiOpe().initMid(area, 0);

        baseOpes.getUiOpe().getRightTV().setText(sort);
        LogUtil.E("time:" + time + "----" + "area:" + area + "----" + "type:" + type + "---" + "sort:" + sort + "---" + "count:" + count);

        if (cache && !NullUtil.isStrEmpty(baseOpes.getDaOpe().getCahceData(time + area))) {
            String o = baseOpes.getDaOpe().getCahceData(time + area);
            final AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), AreaMessionListResBean.class);
            new AreaMessionTimeOpe().sort(resBean, type, sort, count, new OnNetFinishWithObjInter() {
                @Override
                public void onNetFinish(Object o) {
                    baseOpes.getUiOpe().initMissionList(extend, (ArrayList<AreaMissionListAdapterBean>) o);
                    baseOpes.getUiOpe().initMid(area, resBean == null ? 0 : resBean.getData() == null ? 0 : resBean.getData().size());
                    baseOpes.getUiOpe().getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                    if (onFinishListener != null) {
                        onFinishListener.onFinish(o);
                    }
                }
            });
            return;
        }

        SimpleNetOpe.getMissionData(activity, time + area, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    final AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), AreaMessionListResBean.class);
                    new AreaMessionTimeOpe().sort(resBean, type, sort, count, new OnNetFinishWithObjInter() {
                        @Override
                        public void onNetFinish(Object o) {
                            baseOpes.getUiOpe().initMissionList(extend, (ArrayList<AreaMissionListAdapterBean>) o);
                            baseOpes.getUiOpe().initMid(area, resBean == null ? 0 : resBean.getData() == null ? 0 : resBean.getData().size());
                            baseOpes.getUiOpe().getMissionListAdapter().setOnAppItemsClickListener(MissionListFGM.this);
                            baseOpes.getDaOpe().setCacheData(type, o.toString());
                        }
                    });
                } else {
                    baseOpes.getUiOpe().initMissionList(false, null);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public View getPinnedHeader() {
        View headerView = LayoutInflater.from(activity).inflate(R.layout.list_head_mission, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (baseOpes.getUiOpe() == null || baseOpes.getUiOpe().getMissionListAdapter() == null ||
                baseOpes.getUiOpe().getMissionListAdapter().getData() == null || baseOpes.getUiOpe().getMissionListAdapter().getData().size() == 0
                || firstVisibleGroupPos < 0) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView startTV = (TextView) headerView.findViewById(R.id.tv_starttime);
        TextView endTV = (TextView) headerView.findViewById(R.id.tv_endtime);
        TextView titleTV = (TextView) headerView.findViewById(R.id.tv_title);
        startTV.setText(StringUtil.getStr((baseOpes.getUiOpe().getMissionListAdapter().getData().get(firstVisibleGroupPos).getHour()) + ":00"));
        endTV.setText(StringUtil.getStr(baseOpes.getUiOpe().getMissionListAdapter().getData().get(firstVisibleGroupPos).getHour() + 2) + ":00");
        titleTV.setText(StringUtil.getStr(baseOpes.getUiOpe().getMissionListAdapter().getData().get(firstVisibleGroupPos).getYYYYMMDD()));
    }


    @Optional
    @OnClick({BaseID.ID_MID, BaseID.ID_BACK, BaseID.ID_RIGHT, R.id.ll_all, R.id.ll_lin, R.id.ll_long})
    public void onClickEvent(View view) {
        switch (view.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, new String[]{"我的任务", MethodValue.getArea().getWardname()}, NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        switch (position) {
                            case 0:
                                baseOpes.getDaOpe().areaType = AreaMessionDAOpe.AREA_TYPE_MY_PATIENT;
                                getMyTask(true, false, null);
                                break;
                            case 1:
                                baseOpes.getDaOpe().areaType = AreaMessionDAOpe.AREA_TYPE_AREA;
                                getMyTask(true, false, null);
                                break;
                        }
                    }
                });
                break;
            case BaseID.ID_BACK:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, baseOpes.getUiOpe().getMissionTypeStr(), NurseDialogFrag.LEFT, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        baseOpes.getDaOpe().leftType = textView.getText().toString();
                        baseOpes.getDaOpe().timeArea = AreaMessionDAOpe.TIME_TODAY;

                        getMyTask(true, false, null);
                    }
                });
                break;

            case BaseID.ID_RIGHT:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, MethodValue.getMissionSortStrs(), NurseDialogFrag.RIGHT, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        baseOpes.getDaOpe().rightSort = textView.getText().toString();
                        getMyTask(true, false, null);
                        PopupUtil.getInstance().dimess();
                    }
                });
                break;
            case R.id.ll_all:
                baseOpes.getUiOpe().select(0);
                baseOpes.getDaOpe().count = AreaMessionDAOpe.COUNT_ALL;
                getMyTask(true, false, null);
                break;
            case R.id.ll_lin:
                baseOpes.getDaOpe().count = AreaMessionDAOpe.COUNT_LIN;
                baseOpes.getUiOpe().select(1);
                getMyTask(true, false, null);
                break;
            case R.id.ll_long:
                baseOpes.getDaOpe().count = AreaMessionDAOpe.COUNT_LONG;
                baseOpes.getUiOpe().select(2);
                getMyTask(true, false, null);
                break;
        }
    }

    @Override
    public void onAppItemClick(int groupPosition, View view, int childPosition) {
        switch (view.getId()) {
            case R.id.ll_xyz:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new MissionDetailFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_finish:
                if (baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getCodename().equals("补液卡") ||
                        baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getNurse_type().equals("静滴") ||
                        baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getNurse_type().equals("术前治疗")) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable(ValueConstant.DATA_DATA, baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition));
                    FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AddAddWaterFrag(), bundle1, ValueConstant.CODE_REQUSET);
                    return;
                }
                MissisonDetailReqBean reqBean = new MissisonDetailReqBean();
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                reqBean.setRegion(data.getWardcode());
                if (baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().size() <= 1) {
                    reqBean.setId(baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles().get(0).getId());
                } else {
                    reqBean.setTaskids(baseOpes.getDaOpe().getIDs(baseOpes.getUiOpe().getAdapterList().get(groupPosition).getData().get(childPosition).getTitles()));
                }
                reqBean.setStatus("T");
                NurseNetOpe missionDetailNetOpe = new NurseNetOpe(activity);
                missionDetailNetOpe.updateTask(reqBean, new OnNetWorkReqAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            getMyTask(false, true, new OnFinishListener() {
                                @Override
                                public void onFinish(Object o) {
                                }
                            });
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        HandleUtil.getInstance().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMyTask(false, true, new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                    }
                });
            }
        }, getResources().getInteger(R.integer.integer_time_short));
    }


    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        getMyTask(false, false, new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                // baseOpes.getUiOpe().getMissionExpandView().setOnHeadViewClick(MissionListFGM.this);
                materialRefreshLayout.finishRefreshingDelay();
            }
        });
    }


    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new MissionListFGMUIOpe(activity, getView()), new AreaMessionDAOpe(activity));
        }
        return R.layout.frag_missionlist;
    }
}
