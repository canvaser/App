package com.siweisoft.ui.bed.persontask.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.nursenet.NurseNetOpe;
import com.siweisoft.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.nursevalue.MethodValue;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.ui.bed.persontask.ope.MyMissionDAOpe;
import com.siweisoft.ui.bed.persontask.ope.MyMissionStatusOpe;
import com.siweisoft.ui.bed.persontask.ope.MyMissonUIOpe;
import com.siweisoft.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.siweisoft.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.ui.mission.missiondetail.fragment.MissionDetailFrag;
import com.siweisoft.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.lib.util.fragment.FragManager;

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
        myMissonUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getPatientTask(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        myMissonUIOpe.getMissionExpandView().setOnHeadViewClick(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 1:
                                        myMissonUIOpe.getMissionItenHeadUIBean().select(0);
                                        myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[0]);
                                        break;
                                    case 2:
                                        myMissonUIOpe.getMissionItenHeadUIBean().select(1);
                                        myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[1]);
                                        break;
                                    case 3:
                                        myMissonUIOpe.getMissionItenHeadUIBean().select(2);
                                        myMissionDAOpe.setTimeType(MyMissionDAOpe.TIME_TYPE[2]);
                                        break;
                                }
                                //myMissonUIOpe.initList(myMissionDAOpe.sort());
                            }
                        });
                        materialRefreshLayout.finishRefreshingDelay();
                    }
                });
            }
        });
        myMissonUIOpe.getMissionExpandView().setOnHeaderUpdateListener(this);
        myMissonUIOpe.getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));

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
                            myMissonUIOpe.getRefreshLayout().autoRefresh();
                        }
                    }
                });
                break;
        }
    }


    @OnClick({BaseID.ID_RIGHT, BaseID.ID_MID})
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
        }
    }


    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        myMissonUIOpe.getRefreshLayout().autoRefresh(1000);
    }
}
