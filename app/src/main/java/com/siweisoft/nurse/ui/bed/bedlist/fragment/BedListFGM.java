package com.siweisoft.nurse.ui.bed.bedlist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.addmypatient.fragment.AddMyPatientFrag;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedListResBean;
import com.siweisoft.nurse.ui.bed.bedlist.ope.BedListDAOpe;
import com.siweisoft.nurse.ui.bed.bedlist.ope.BedListFGMUIOpe;
import com.siweisoft.nurse.ui.bed.bedlist.ope.GetMyPatientListNetOpe;
import com.siweisoft.nurse.ui.bed.patient.fragment.PatientFrag;
import com.siweisoft.nurse.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListFGM extends BaseNurseFrag implements OnAppItemClickListener {


    BedListFGMUIOpe bedListFGMUIOpe;

    GetMyPatientListNetOpe getMyPatientListNetOpe;

    BedListDAOpe bedListDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bedListFGMUIOpe = new BedListFGMUIOpe(activity,getView());
        getMyPatientListNetOpe = new GetMyPatientListNetOpe(activity);
        bedListDAOpe= new BedListDAOpe();
        bedListFGMUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
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
        bedListFGMUIOpe.getRefreshLayout().autoRefresh(500);

    }


    public void getData(final OnFinishListener onFinishListener){
        bedListFGMUIOpe.setTitle(bedListDAOpe.getIndex(),0);
        switch (bedListDAOpe.getIndex()){
            case 0:
                getMyPatientList(onFinishListener);
                break;
            case 1:
                getRegion(onFinishListener);
                break;
        }
    }

    private void getRegion(final OnFinishListener onFinishListener){
        getMyPatientListNetOpe.getRegion(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {

                if(success){
                    final PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),PatientBedListResBean.class);
                    bedListDAOpe.setAllList(resBean.getData());
                    bedListDAOpe.initAllBedList(activity, new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            bedListFGMUIOpe.initBedList(resBean.getData());
                            bedListFGMUIOpe.getBedListAdapter().setOnAppItemClickListener(BedListFGM.this);
                            bedListFGMUIOpe.setTitle(bedListDAOpe.getIndex(),resBean.getData().size());
                        }
                    });

                }else{
                    bedListFGMUIOpe.initBedList(null);
                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(null);
                }
            }
        });
    }

    private void getRegion2(final OnFinishListener onFinishListener){
        getMyPatientListNetOpe.getRegion(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {

                if(success){
                    final PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),PatientBedListResBean.class);
                    bedListDAOpe.setAllList(resBean.getData());
                    bedListDAOpe.initAllBedList(context, new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            bedListFGMUIOpe.initBedList(resBean.getData());
                            bedListFGMUIOpe.getBedListAdapter().setOnAppItemClickListener(BedListFGM.this);
                            bedListFGMUIOpe.setTitle(bedListDAOpe.getIndex(),resBean.getData().size());
                            onFinishListener.onFinish(o);
                        }
                    });
                }else{
                    bedListFGMUIOpe.initBedList(null);
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    private void getMyPatientList(final OnFinishListener onFinishListener){
        getMyPatientListNetOpe.getMyPatientList(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    PatientBedListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),PatientBedListResBean.class);
                    bedListDAOpe.setMyList(resBean.getData());
                    bedListDAOpe.initMyBedList(activity);
                    bedListFGMUIOpe.initBedList(bedListDAOpe.getMyList());
                    bedListFGMUIOpe.getBedListAdapter().setOnAppItemClickListener(BedListFGM.this);
                    bedListFGMUIOpe.setTitle(bedListDAOpe.getIndex(),resBean.getData().size());
                }else{
                    bedListFGMUIOpe.initBedList(null);
                }
                if(onFinishListener!=null){
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
    @OnClick({BaseID.ID_MID,BaseID.ID_RIGHT})
    public void onClick(View view){
        switch (view.getId()){
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(),BaseID.ID_ROOT,new String[]{"我的病人",MethodValue.getArea().getWardname()}, NurseDialogFrag.MID,new OnAppItemClickListener() {

                            @Override
                            public void onAppItemClick(View view, int position) {
                                switch (position){
                                    case 0:
                                        bedListDAOpe.setIndex(0);
                                        bedListFGMUIOpe.getRefreshLayout().autoRefresh();
                                        break;
                                    case 1:
                                        bedListDAOpe.setIndex(1);
                                        bedListFGMUIOpe.getRefreshLayout().autoRefresh();
                                        break;
                                }
                            }
                        });
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA,bedListDAOpe.getMyList());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new AddMyPatientFrag(),bundle,ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, final int position) {
        if(bedListDAOpe.getAllList()==null){
            getRegion2(new OnFinishListener() {
                @Override
                public void onFinish(Object o) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ValueConstant.DATA_DATA,bedListDAOpe.getAllList());
                    bundle.putSerializable(ValueConstant.DATA_DATA2,bedListFGMUIOpe.getBedListAdapter().getData().get(position));
                    FragManager.getInstance().startFragment(getFragmentManager(),index,new PatientFrag(),bundle);
                }
            });
        }else{
            Bundle bundle = new Bundle();
            bundle.putSerializable(ValueConstant.DATA_DATA,bedListDAOpe.getAllList());
            bundle.putSerializable(ValueConstant.DATA_DATA2,bedListFGMUIOpe.getBedListAdapter().getData().get(position));
            FragManager.getInstance().startFragment(getFragmentManager(),index,new PatientFrag(),bundle);
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
       bedListFGMUIOpe.getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onCmd(final Bundle bundle) {
        if(bundle==null || bundle.getString(ValueConstant.FARG_TYPE)==null|| !bundle.getString(ValueConstant.FARG_TYPE).equals(ValueConstant.FARG_TYPE_CMD)){
            return;
        }
        if(bedListDAOpe.getAllList()==null){
            getData(new OnFinishListener() {
                @Override
                public void onFinish(Object o) {
                    String zyh = bundle.getString(ValueConstant.DATA_POSITION);
                    int p= bedListDAOpe.getPosition(bedListDAOpe.getAllList(),zyh);
                    if(p!=-1){
                        onAppItemClick(null,p);
                    }
                }
            });
        }else{
            final String zyh = bundle.getString(ValueConstant.DATA_POSITION);
            int p= bedListDAOpe.getPosition(bedListDAOpe.getAllList(),zyh);
            if(p!=-1){
                onAppItemClick(null,p);
            }else{
                getRegion(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        int p= bedListDAOpe.getPosition(bedListDAOpe.getAllList(),zyh);
                        if(p!=-1){
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(ValueConstant.DATA_DATA,bedListDAOpe.getAllList());
                            bundle.putSerializable(ValueConstant.DATA_POSITION2,p);
                            bundle.putInt(ValueConstant.DATA_POSITION,R.id.rl_mymission);
                            bundle.putString(ValueConstant.FARG_TYPE,ValueConstant.FARG_TYPE_CMD);
                            FragManager.getInstance().startFragment(getFragmentManager(),index,new PatientFrag(),bundle);
                        }
                    }
                });
            }
        }

    }

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }
}
