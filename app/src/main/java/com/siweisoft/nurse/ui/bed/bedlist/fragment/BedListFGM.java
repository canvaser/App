package com.siweisoft.nurse.ui.bed.bedlist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.bed.addmypatient.fragment.AddMyPatientFrag;
import com.siweisoft.nurse.ui.bed.bedlist.adapter.BedListAdapter;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedListResBean;
import com.siweisoft.nurse.ui.bed.bedlist.ope.BedListDAOpe;
import com.siweisoft.nurse.ui.bed.bedlist.ope.BedListFGMUIOpe;
import com.siweisoft.nurse.ui.bed.patient.fragment.PatientFrag;
import com.siweisoft.nurse.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.io.Serializable;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListFGM extends BaseNurseFrag<BedListFGMUIOpe, NurseNetOpe, BaseDBOpe, BedListDAOpe> implements OnAppItemClickListener {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseNurseOpes.getUiOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefreshing();
                    }
                });
            }
        });
        baseNurseOpes.getUiOpe().getRefreshLayout().autoRefresh(500);
    }


    public void getData(final OnFinishListener onFinishListener) {
        baseNurseOpes.getUiOpe().setTitle(baseNurseOpes.getDaOpe().getIndex(), 0);
        switch (baseNurseOpes.getDaOpe().getIndex()) {
            case 0:
                getMyPatientList(onFinishListener);
                break;
            case 1:
                getRegion(onFinishListener);
                break;
        }
    }

    private void getRegion(final OnFinishListener onFinishListener) {
        baseNurseOpes.getNetOpe().getRegion(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {

                if (success) {
                    final PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), PatientBedListResBean.class);
                    baseNurseOpes.getDaOpe().setAllList(resBean.getData());
                    baseNurseOpes.getDaOpe().initAllBedList(activity, new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            baseNurseOpes.getUiOpe().initBedList(resBean.getData());
                            ((BedListAdapter) baseNurseOpes.getUiOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(BedListFGM.this);
                            baseNurseOpes.getUiOpe().setTitle(baseNurseOpes.getDaOpe().getIndex(), resBean.getData().size());
                        }
                    });

                } else {
                    baseNurseOpes.getUiOpe().initBedList(null);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(null);
                }
            }
        });
    }

    public void getRegion2(final OnFinishListener onFinishListener) {
        baseNurseOpes.getNetOpe().getRegion(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {

                if (success) {
                    final PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), PatientBedListResBean.class);
                    baseNurseOpes.getDaOpe().setAllList(resBean.getData());
                    baseNurseOpes.getDaOpe().initAllBedList(context, new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            //bedListFGMUIOpe.initBedList(resBean.getData());
                            //bedListFGMUIOpe.getBedListAdapter().setOnAppItemClickListener(BedListFGM.this);
                            //bedListFGMUIOpe.setTitle(bedListDAOpe.getIndex(),resBean.getData().size());
                            onFinishListener.onFinish(o);
                        }
                    });
                } else {
                    baseNurseOpes.getUiOpe().initBedList(null);
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    private void getMyPatientList(final OnFinishListener onFinishListener) {
        baseNurseOpes.getNetOpe().getMyPatientList(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), PatientBedListResBean.class);
                    baseNurseOpes.getDaOpe().setMyList(resBean.getData());
                    baseNurseOpes.getDaOpe().initMyBedList(activity);
                    baseNurseOpes.getUiOpe().initBedList(baseNurseOpes.getDaOpe().getMyList());
                    ((BedListAdapter) baseNurseOpes.getUiOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(BedListFGM.this);
                    baseNurseOpes.getUiOpe().setTitle(baseNurseOpes.getDaOpe().getIndex(), resBean.getData().size());
                } else {
                    baseNurseOpes.getUiOpe().initBedList(null);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(null);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_bedlist;
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
                                baseNurseOpes.getDaOpe().setIndex(0);
                                baseNurseOpes.getUiOpe().getRefreshLayout().autoRefresh();
                                break;
                            case 1:
                                baseNurseOpes.getDaOpe().setIndex(1);
                                baseNurseOpes.getUiOpe().getRefreshLayout().autoRefresh();
                                break;
                        }
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, baseNurseOpes.getDaOpe().getMyList());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AddMyPatientFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, final int position) {
        if (baseNurseOpes.getDaOpe().getAllList() == null) {
            getRegion2(new OnFinishListener() {
                @Override
                public void onFinish(Object o) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ValueConstant.DATA_DATA, baseNurseOpes.getDaOpe().getAllList());
                    bundle.putSerializable(ValueConstant.DATA_DATA2, ((BedListAdapter) baseNurseOpes.getUiOpe().getRecyclerView().getAdapter()).getData().get(position));
                    FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle);
                }
            });
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable(ValueConstant.DATA_DATA, baseNurseOpes.getDaOpe().getAllList());
            bundle.putSerializable(ValueConstant.DATA_DATA2, ((BedListAdapter) baseNurseOpes.getUiOpe().getRecyclerView().getAdapter()).getData().get(position));
            FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle);
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        baseNurseOpes.getUiOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onCmd(final Bundle bundle) {
        if (bundle == null || bundle.getString(ValueConstant.FARG_TYPE) == null || !bundle.getString(ValueConstant.FARG_TYPE).equals(ValueConstant.FARG_TYPE_CMD)) {
            return;
        }
        if (baseNurseOpes.getDaOpe().getAllList() == null) {
            getData(new OnFinishListener() {
                @Override
                public void onFinish(Object o) {
                    String zyh = bundle.getString(ValueConstant.DATA_POSITION);
                    int p = baseNurseOpes.getDaOpe().getPosition(baseNurseOpes.getDaOpe().getAllList(), zyh);
                    if (p != -1) {
                        onAppItemClick(null, p);
                    }
                }
            });
        } else {
            final String zyh = bundle.getString(ValueConstant.DATA_POSITION);
            int p = baseNurseOpes.getDaOpe().getPosition(baseNurseOpes.getDaOpe().getAllList(), zyh);
            if (p != -1) {
                onAppItemClick(null, p);
            } else {
                getRegion(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        int p = baseNurseOpes.getDaOpe().getPosition(baseNurseOpes.getDaOpe().getAllList(), zyh);
                        if (p != -1) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(ValueConstant.DATA_DATA, baseNurseOpes.getDaOpe().getAllList());
                            bundle.putSerializable(ValueConstant.DATA_POSITION2, p);
                            bundle.putInt(ValueConstant.DATA_POSITION, R.id.rl_mymission);
                            bundle.putString(ValueConstant.FARG_TYPE, ValueConstant.FARG_TYPE_CMD);
                            FragManager.getInstance().startFragment(getFragmentManager(), index, new PatientFrag(), bundle);
                        }
                    }
                });
            }
        }

    }

    @Override
    public BaseNurseOpes<BedListFGMUIOpe, NurseNetOpe, BaseDBOpe, BedListDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes<>(new BedListFGMUIOpe(activity, getView()), new NurseNetOpe(activity), null, new BedListDAOpe(activity));
        }
        return baseNurseOpes;
    }


}
