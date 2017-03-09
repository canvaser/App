package com.siweisoft.app.ui.info.checkbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.info.checkbookdetail.fragment.CheckBookDetailFrag;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.app.ui.info.addcheckbook.fragment.AddCheckBookFrag;
import com.siweisoft.app.ui.info.checkbook.bean.resbean.CheckBookListResBean;
import com.siweisoft.app.ui.info.checkbook.ope.CheckBookUIOpe;
import com.siweisoft.lib.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookFrag extends BaseNurseFrag implements OnAppItemClickListener {

    NurseNetOpe checkBookNetOpe;

    CheckBookUIOpe checkBookUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkBookUIOpe = new CheckBookUIOpe(activity, getView());
        checkBookNetOpe = new NurseNetOpe(activity);
        checkBookUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefreshingDelay();
                    }
                });
            }
        });
        checkBookUIOpe.getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getData(final OnFinishListener onFinishListener) {
        checkBookNetOpe.getInstrumentFileItem(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    CheckBookListResBean checkBookListResBean = GsonUtil.getInstance().fromJson(o.toString(), CheckBookListResBean.class);
                    checkBookUIOpe.initList(checkBookListResBean.getData());
                    checkBookUIOpe.getCheckBookAdapter().setOnAppItemClickListener(CheckBookFrag.this);
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_checkbook;
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, checkBookUIOpe.getData());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AddCheckBookFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA, checkBookUIOpe.getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(), index, new CheckBookDetailFrag(), bundle);
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        checkBookUIOpe.getRefreshLayout().autoRefresh(500);
    }
}
