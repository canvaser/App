package com.summer.app.ui.addwater.addaddwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.summer.app.ui.addwater.addaddwater.ope.uiope.AddAddWaterUIOpe;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.ope.BaseDBOpe;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SheetDialogUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.addwater.addaddwater.bean.netbean.GetBylResBean;
import com.summer.app.ui.addwater.addaddwater.ope.daope.AddAddWaterDAOpe;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.DelayUINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddAddWaterFrag extends BaseNurseFrag<AddAddWaterUIOpe, NurseNetOpe, BaseDBOpe, AddAddWaterDAOpe> {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getDaOpe().setAreaMessionResBean((AreaMessionListResBean.DataBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        getOpe().getUiOpe().sethead(getOpe().getDaOpe().getAreaMessionResBean().getTitles());
        getOpe().getUiOpe().getRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getData(final OnFinishListener onFinishListener) {
        getOpe().getNetOpe().document_documemtdetail("71", new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                getOpe().getDaOpe().setAddAddWaterResBean(GsonUtil.getInstance().fromJson(o.toString(), AddAddWaterResBean.class));
                getOpe().getDaOpe().fillcontent(getOpe().getDaOpe().getAreaMessionResBean().getTitles().get(0).getTitle());
                getOpe().getUiOpe().initList(getOpe().getDaOpe().getAddAddWaterResBean());
                getBYLbyId(onFinishListener);
            }
        });
    }

    public void getBYLbyId(final OnFinishListener onFinishListener) {
        getOpe().getNetOpe().getbylbyadvid(getOpe().getDaOpe().getAreaMessionResBean().getTitles().get(0).get医嘱ID(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                getOpe().getDaOpe().setGetBylResBean(GsonUtil.getInstance().fromJson(o.toString(), GetBylResBean.class));
                getOpe().getUiOpe().setleftBuyeLiang(getOpe().getDaOpe().getGetBylResBean().getData().getResult());
                onFinishListener.onFinish(null);
            }
        });
    }

    public void wirteData() {

        getOpe().getNetOpe().write_addwater_data(getOpe().getDaOpe().getAreaMessionResBean().getTitles().get(0).getId(),
                getOpe().getDaOpe().getAreaMessionResBean().getTitles().get(0).get医嘱ID(),
                getOpe().getDaOpe().getAreaMessionResBean().getRegionId(),
                getOpe().getDaOpe().getAreaMessionResBean().getZyh(),
                getOpe().getDaOpe().getAddAddWaterResBean().getData().get(0).getData(),
                new DelayUINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, new String[]{"稍后是否还需要新增补液卡记录", "是", "否", "取消"});
                        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TextView textView = (TextView) v;
                                switch (textView.getText().toString()) {
                                    case "是":

                                        break;
                                    case "否":

                                        break;
                                    case "取消":

                                        break;
                                }
                                SheetDialogUtil.getInstance().dismess();
                            }
                        });
                    }
                });
    }

    @OnClick({BaseID.ID_RIGHT, R.id.tv_clear, R.id.tv_start})
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_start:
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new CountDishuFrag(), new Bundle(), ValueConstant.CODE_REQUSET);
                break;
            case BaseID.ID_RIGHT:
                wirteData();
                break;
            case R.id.tv_clear:
                getOpe().getDaOpe().clearDisu();
                getOpe().getUiOpe().getRecyclerView().getAdapter().notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        if (bundle.getString(ValueConstant.DATA_DATA) != null) {
            getOpe().getDaOpe().fillDisu(bundle.getString(ValueConstant.DATA_DATA));
            getOpe().getUiOpe().getRecyclerView().getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        getData(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                materialRefreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addaddwater;
    }

    @Override
    public BaseNurseOpes<AddAddWaterUIOpe, NurseNetOpe, BaseDBOpe, AddAddWaterDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AddAddWaterUIOpe(activity, getView()), new NurseNetOpe(activity), null, new AddAddWaterDAOpe(activity));
        }
        return baseNurseOpes;
    }
}
