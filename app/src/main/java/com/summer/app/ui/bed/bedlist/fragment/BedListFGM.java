package com.summer.app.ui.bed.bedlist.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.bed.addmypatient.fragment.AddMyPatientFrag;
import com.summer.app.ui.bed.bedlist.adapter.BedListAdapter;
import com.summer.app.ui.bed.bedlist.ope.BedListDAOpe;
import com.summer.app.ui.bed.bedlist.ope.BedListFGMUIOpe;
import com.summer.app.ui.bed.patient.fragment.PatientFrag;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.summer.app.ui.home.activity.IndexActivity;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedListResBean;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListFGM extends CommonUIFrag2<BedListFGMUIOpe<BedListFGM>, BedListDAOpe<BedListFGM>> implements OnAppItemClickListener {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(500);
    }


    public void getData(int type, final OnFinishListener onFinishListener) {
        baseOpes.getUiOpe().setTitle(baseOpes.getDaOpe().getIndex(), 0);
        switch (type) {
            case 0:
                SimpleNetOpe.getMyPatientList(activity, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), PatientBedListResBean.class);
                            baseOpes.getDaOpe().setMyList(resBean.getData());
                            baseOpes.getDaOpe().initMyBedList(activity);
                            baseOpes.getUiOpe().initBedList(baseOpes.getDaOpe().getMyList());
                            ((BedListAdapter) baseOpes.getUiOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(BedListFGM.this);
                            baseOpes.getUiOpe().setTitle(baseOpes.getDaOpe().getIndex(), baseOpes.getDaOpe().getNotNullBedSize(resBean.getData()));
                        } else {
                            baseOpes.getDaOpe().getMyList().clear();
                            baseOpes.getUiOpe().initBedList(null);
                        }
                        if (onFinishListener != null) {
                            onFinishListener.onFinish(null);
                        }
                    }
                });
                break;
            case 1:
                SimpleNetOpe.getRegion(activity, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {

                        if (success) {
                            final PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), PatientBedListResBean.class);
                            baseOpes.getDaOpe().setAllList(resBean.getData());
                            baseOpes.getDaOpe().initAllBedList(activity, new OnFinishListener() {
                                @Override
                                public void onFinish(Object o) {
                                    baseOpes.getUiOpe().initBedList(resBean.getData());
                                    ((BedListAdapter) baseOpes.getUiOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(BedListFGM.this);
                                    baseOpes.getUiOpe().setTitle(baseOpes.getDaOpe().getIndex(), baseOpes.getDaOpe().getNotNullBedSize(resBean.getData()));
                                }
                            });

                        } else {
                            baseOpes.getUiOpe().initBedList(null);
                        }
                        if (onFinishListener != null) {
                            onFinishListener.onFinish(null);
                        }
                    }
                });
            case 3:
                SimpleNetOpe.getRegion(activity, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {

                        if (success) {
                            final PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), PatientBedListResBean.class);
                            baseOpes.getDaOpe().setAllList(resBean.getData());
                            baseOpes.getDaOpe().initAllBedList(context, new OnFinishListener() {
                                @Override
                                public void onFinish(Object o) {
                                    //bedListFGMUIOpe.initBedList(resBean.getData());
                                    //bedListFGMUIOpe.getBedListAdapter().setOnAppItemClickListener(BedListFGM.this);
                                    //bedListFGMUIOpe.setTitle(bedListDAOpe.getIndex(),resBean.getData().size());
                                    onFinishListener.onFinish(o);
                                }
                            });
                        } else {
                            baseOpes.getUiOpe().initBedList(null);
                            onFinishListener.onFinish(o);
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        super.onRefresh(materialRefreshLayout);
        getData(baseOpes.getDaOpe().getIndex(), new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                materialRefreshLayout.finishRefreshingDelay();
            }
        });
    }

    private void getRegion(final OnFinishListener onFinishListener) {

    }

    private void getMyPatientList(final OnFinishListener onFinishListener) {

    }

    @Optional
    @OnClick({BaseID.ID_MID, BaseID.ID_RIGHT})
    public void onClick(View view) {
        switch (view.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, new String[]{"我的病人", MethodValue.getArea().getWardname()}, NurseDialogFrag.MID, new OnAppItemClickListener() {

                    @Override
                    public void onAppItemClick(View view, int position) {
                        switch (position) {
                            case 0:
                                baseOpes.getDaOpe().setIndex(0);
                                baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(0);
                                break;
                            case 1:
                                baseOpes.getDaOpe().setIndex(1);
                                baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(0);
                                break;
                        }
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, baseOpes.getDaOpe().getMyList());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AddMyPatientFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onAppItemClick(final View view, final int position) {
        if (baseOpes.getDaOpe().getAllList() == null) {
            getData(3, new OnFinishListener() {
                @Override
                public void onFinish(Object o) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ValueConstant.DATA_DATA, baseOpes.getDaOpe().getValidList());
                    bundle.putSerializable(ValueConstant.DATA_DATA2, ((BedListAdapter) baseOpes.getUiOpe().getRecyclerView().getAdapter()).getData().get(position));
                    FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle);
                }
            });
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable(ValueConstant.DATA_DATA, baseOpes.getDaOpe().getValidList());
            bundle.putSerializable(ValueConstant.DATA_DATA2, ((BedListAdapter) baseOpes.getUiOpe().getRecyclerView().getAdapter()).getData().get(position));
            FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle);
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        //baseOpes.getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onCmd(final Bundle bundle) {
        if (bundle == null || bundle.getString(ValueConstant.FARG_TYPE) == null || !bundle.getString(ValueConstant.FARG_TYPE).equals(ValueConstant.FARG_TYPE_CMD)) {
            return;
        }
        if (baseOpes.getDaOpe().getAllList() == null) {
            getData(3, new OnFinishListener() {
                @Override
                public void onFinish(Object o) {
                    String zyh = bundle.getString(ValueConstant.DATA_POSITION);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ValueConstant.DATA_DATA, baseOpes.getDaOpe().getValidList());
                    bundle.putSerializable(ValueConstant.DATA_DATA2, baseOpes.getDaOpe().getPatientBedResBean(baseOpes.getDaOpe().getValidList(), zyh));
                    IndexActivity indexActivity = (IndexActivity) activity;
                    indexActivity.getHomeUIOpe().getViewPager().setCurrentItem(0);
                    FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle);
                }
            });
        } else {
            final String zyh = bundle.getString(ValueConstant.DATA_POSITION);
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable(ValueConstant.DATA_DATA, baseOpes.getDaOpe().getValidList());
            bundle1.putSerializable(ValueConstant.DATA_DATA2, baseOpes.getDaOpe().getPatientBedResBean(baseOpes.getDaOpe().getValidList(), zyh));
            IndexActivity indexActivity = (IndexActivity) activity;
            indexActivity.getHomeUIOpe().getViewPager().setCurrentItem(0);
            FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle1);
        }

    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new BedListFGMUIOpe<BedListFGM>(activity, getView(), this), new BedListDAOpe<BedListFGM>(activity, this));
        }
        return R.layout.frag_bedlist;
    }
}
