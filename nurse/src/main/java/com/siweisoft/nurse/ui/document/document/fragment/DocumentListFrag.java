package com.siweisoft.nurse.ui.document.document.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.document.document.adapter.DocumentListAdapter;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListResBean;
import com.siweisoft.nurse.ui.document.document.ope.daope.DocumentListDAOpe;
import com.siweisoft.nurse.ui.document.document.ope.uiope.DocumentListUIOpe;
import com.siweisoft.lib.base.ui.adapter.PupListAdapter;
import com.siweisoft.lib.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class DocumentListFrag extends BaseNurseFrag<DocumentListUIOpe, NurseNetOpe, BaseDBOpe, DocumentListDAOpe> implements OnAppItemClickListener {


    PatientAdditionDAOpe patientAdditionDAOpe;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA2) == null) {
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        getOpe().getDaOpe().setDataBean((DocumentListResBean.DataBean) getArguments().get(ValueConstant.DATA_DATA2));
        getOpe().getUiOpe().init(getOpe().getDaOpe().getDataBean().getTitle() == null ? patientAdditionDAOpe.getPatientBedResBean().get姓名() : getOpe().getDaOpe().getDataBean().getTitle());
        getOpe().getUiOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        getOpe().getUiOpe().getRefreshLayout().finishRefresh();
                    }
                });
            }
        });
        getOpe().getUiOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getData(@NonNull final OnFinishListener onFinishListener) {
        getOpe().getNetOpe().document_documemtList(getOpe().getDaOpe().getDataBean().getId(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    DocumentListResBean documentListResBean = GsonUtil.getInstance().fromJson(o.toString(), DocumentListResBean.class);
                    getOpe().getDaOpe().setDocumentListResBean(documentListResBean);
                    getOpe().getUiOpe().initList(documentListResBean);
                    getOpe().getUiOpe().initUpdate(documentListResBean);
                    ((DocumentListAdapter) getOpe().getUiOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(DocumentListFrag.this);
                }
                onFinishListener.onFinish(o);
            }
        });
    }


    @Override
    public BaseNurseOpes<DocumentListUIOpe, NurseNetOpe, BaseDBOpe, DocumentListDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new DocumentListUIOpe(activity, getView()), new NurseNetOpe(activity), null, new DocumentListDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @OnClick({BaseID.ID_MID, BaseID.ID_RIGHT})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case BaseID.ID_MID:
                if (getOpe().getDaOpe().getDataBean().getTitle() != null) {
                    return;
                }
                View view1 = layoutInflater.inflate(R.layout.pup_list, null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.getLayoutParams().height = ValueConstant.DIMEN_1 * 200;
                recyclerView.requestLayout();
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity, 2));

                PupListAdapter p = new PupListAdapter(activity, patientAdditionDAOpe.getNames());
                p.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        getOpe().getUiOpe().init(patientAdditionDAOpe.getNames().get(position));
                        PopupUtil.getInstance().dimess();
                    }
                });
                recyclerView.setAdapter(p);
                PopupUtil.getInstance().show(activity, view1, v);
                break;
            case BaseID.ID_RIGHT:
                getOpe().getDaOpe().setEnableEnter();
                getOpe().getUiOpe().getRecyclerView().getAdapter().notifyDataSetChanged();
                break;
        }
    }

    @Override
    public int getContainView() {
        return R.layout.frag_doment_documentlist;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        if (!((DocumentListResBean.DataBean) view.getTag(R.id.data)).isEnter()) {
            return;
        }
        if (((DocumentListResBean.DataBean) view.getTag(R.id.data)).getType().equals(DocumentListResBean.DataBean.TYPE_HAVE_CHILD)) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(ValueConstant.DATA_DATA, patientAdditionDAOpe);
            bundle.putSerializable(ValueConstant.DATA_DATA2, ((DocumentListResBean.DataBean) view.getTag(R.id.data)));
            FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new DocumentListFrag(), bundle, ValueConstant.CODE_REQUSET1);
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable(ValueConstant.DATA_DATA2, ((DocumentListResBean.DataBean) view.getTag(R.id.data)));
            FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new DocumentDetailListFrag(), bundle, ValueConstant.CODE_REQUSET2);
        }

    }
}
