package com.siweisoft.ui.document.document.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.nursenet.NurseNetOpe;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.ui.document.document.bean.netbean.DocumentDetailResBean;
import com.siweisoft.ui.document.document.bean.netbean.DocumentListResBean;
import com.siweisoft.ui.document.document.ope.daope.DocumentDetailListDAOpe;
import com.siweisoft.ui.document.document.ope.uiope.DocumentDetailListUIOpe;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentDetailListFrag extends BaseNurseFrag<DocumentDetailListUIOpe, NurseNetOpe, BaseDBOpe, DocumentDetailListDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA2) == null) {
            return;
        }
        getOpe().getDaOpe().setDataBean((DocumentListResBean.DataBean) getArguments().get(ValueConstant.DATA_DATA2));
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

    @Override
    public BaseNurseOpes<DocumentDetailListUIOpe, NurseNetOpe, BaseDBOpe, DocumentDetailListDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new DocumentDetailListUIOpe(activity, getView()), new NurseNetOpe(activity), null, new DocumentDetailListDAOpe(activity));
        }
        return baseNurseOpes;
    }


    public void getData(@NonNull final OnFinishListener onFinishListener) {
        getOpe().getNetOpe().document_documemtdetail(getOpe().getDaOpe().getDataBean().getId(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    LogUtil.E(o.toString());
                    DocumentDetailResBean documentDetailResBean = GsonUtil.getInstance().fromJson(o.toString(), DocumentDetailResBean.class);
                    getOpe().getDaOpe().setDocumentDetailResBean(documentDetailResBean);
                    getOpe().getUiOpe().initList(getOpe().getDaOpe().getDocumentDetailResBean());
                }
                onFinishListener.onFinish(o);
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_doment_documentdetaillist;
    }
}
