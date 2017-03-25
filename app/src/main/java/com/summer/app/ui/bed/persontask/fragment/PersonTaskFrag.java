package com.summer.app.ui.bed.persontask.fragment;

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
import com.summer.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.summer.app.ui.bed.persontask.ope.MyMissionStatusOpe;
import com.summer.app.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.menu.popup.PopupUtil;
import com.summer.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.bed.persontask.ope.MyMissionDAOpe;
import com.summer.app.ui.bed.persontask.ope.MyMissonUIOpe;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.summer.app.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.summer.lib.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class PersonTaskFrag extends BaseNurseFrag implements
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener {


    MyMissonUIOpe myMissonUIOpe;

    NurseNetOpe getMyMissionNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    MyMissionDAOpe myMissionDAOpe;

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
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        myMissonUIOpe = new MyMissonUIOpe(activity, getView());
        getMyMissionNetOpe = new NurseNetOpe(activity);
        myMissionDAOpe = new MyMissionDAOpe(activity);
        myMissonUIOpe.init(patientAdditionDAOpe);
        myMissonUIOpe.getRefreshLayout().setMaterialRefreshListener(this);
        myMissonUIOpe.getMissionExpandView().setOnHeaderUpdateListener(this);
        myMissonUIOpe.getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));

    }

    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        getPatientTask(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                materialRefreshLayout.finishRefreshingDelay();
            }
        });
    }

    public void getPatientTask(final OnFinishListener onFinishListener) {
        getMyMissionNetOpe.getPatientTask(patientAdditionDAOpe.getPatientBedResBean().get住院号(), new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    AreaMessionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), AreaMessionListResBean.class);
                    myMissionDAOpe.setList(new MyMissionStatusOpe().sortStatus((ArrayList<AreaMessionListResBean.DataBean>) resBean.getData()));
                    myMissonUIOpe.initList(myMissionDAOpe.getList());
                    myMissonUIOpe.getMyMissionListAdapter().setOnAppItemsClickListener(PersonTaskFrag.this);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_mymission;
    }


    @Override
    public View getPinnedHeader() {
        View headerView = LayoutInflater.from(activity).inflate(R.layout.list_head_mymission, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (myMissonUIOpe.getMyMissionListAdapter() == null || firstVisibleGroupPos < 0) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView title = (TextView) headerView.findViewById(R.id.tv_title);
        TextView num = (TextView) headerView.findViewById(R.id.tv_num);

        title.setText(MyMissionStatusOpe.STATUS_LIST_STR.get(firstVisibleGroupPos));
        num.setText(StringUtil.getStr(myMissonUIOpe.getMyMissionListAdapter().getChildrenCount(firstVisibleGroupPos)));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {
        switch (view.getId()) {
            case R.id.root:
            case R.id.ll_xyz:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, myMissonUIOpe.getMyMissionListAdapter().getChild(index, position));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), this.index, new MissionDetailFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_finish:
                MissisonDetailReqBean reqBean = new MissisonDetailReqBean();
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                reqBean.setRegion(data.getWardcode());
                if (myMissonUIOpe.getMyMissionListAdapter().getChild(index, position).getTitles().size() <= 1) {
                    reqBean.setId(myMissonUIOpe.getMyMissionListAdapter().getChild(index, position).getTitles().get(0).getId());
                } else {
                    reqBean.setTaskids(new AreaMessionDAOpe(activity).getIDs(myMissonUIOpe.getMyMissionListAdapter().getChild(index, position).getTitles()));
                }
                reqBean.setStatus("T");
                NurseNetOpe missionDetailNetOpe = new NurseNetOpe(activity);
                missionDetailNetOpe.updateTask(reqBean, new OnNetWorkReqAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            myMissonUIOpe.getRefreshLayout().autoRefreshWithUI(0);
                        }
                    }
                });
                break;
        }
    }


    @OnClick({BaseID.ID_RIGHT, BaseID.ID_MID, R.id.ll_all, R.id.ll_lin, R.id.ll_long})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                String[] missionSortStr = MethodValue.getUserInfo(activity).getData().getNurseType().toArray(new String[MethodValue.getUserInfo(activity).getData().getNurseType().size()]);
                myMissionDAOpe.setMissionSortStr(missionSortStr);
                MyMissionDAOpe.WAY_TYPE = missionSortStr;
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, myMissionDAOpe.addString(missionSortStr), NurseDialogFrag.RIGHT, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        TextView textView = (TextView) view;
                        myMissionDAOpe.setWayType(textView.getText().toString());
                        myMissonUIOpe.getRightTV().setText(myMissionDAOpe.getWayType());
                        myMissonUIOpe.initList(myMissionDAOpe.sort());
                    }
                });
                break;
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, patientAdditionDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        PopupUtil.getInstance().dimess();
                        myMissonUIOpe.init(patientAdditionDAOpe);
                        getPatientTask(null);
                    }
                });
                break;
            case R.id.ll_all:
                myMissonUIOpe.select(0);
                myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[0]);
                myMissonUIOpe.initList(myMissionDAOpe.sort());
                break;
            case R.id.ll_lin:
                myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[1]);
                myMissonUIOpe.select(1);
                myMissonUIOpe.initList(myMissionDAOpe.sort());
                break;
            case R.id.ll_long:
                myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[2]);
                myMissonUIOpe.select(2);
                myMissonUIOpe.initList(myMissionDAOpe.sort());
                break;
        }
    }


    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        myMissonUIOpe.getRefreshLayout().autoRefreshWithUI(1000);
    }
}
