package com.siweisoft.nurse.ui.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.app.adapter.AppAdapter;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.ope.daope.AppDAOpe;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsDBOpe;
import com.siweisoft.nurse.ui.app.ope.uiope.AppUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.IntentUtil;
import com.siweisoft.util.SheetDialogUtil;
import com.siweisoft.view.bottomdialogmenuview.BottomDialogMenuView;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppFrag extends BaseNurseFragWithoutTitle<AppUIOpe, BaseNetOpe, AppsDBOpe, AppDAOpe>
        implements OnAppItemLongClickListener, OnAppItemClickListener {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(0);
        getOpe().getBaseDAOpe().setData(appsFrag.getOpe().getBaseDAOpe().getAppDABean().getData().get(getArguments().getString(ValueConstant.DATA_DATA)));
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getData());
        ((AppAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(this);
        ((AppAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(this);
    }

    @Override
    public BaseNurseOpes<AppUIOpe, BaseNetOpe, AppsDBOpe, AppDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AppUIOpe(activity, getView()), new BaseNetOpe(activity), new AppsDBOpe(activity, new AppDBBean()), new AppDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_app;
    }

    @Override
    public void onAppItemLongClick(View view, final int position) {
        getOpe().getBaseDAOpe().setItem((AppDBBean) view.getTag(R.id.data));
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, getOpe().getBaseDAOpe().getList(activity));
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = (String) v.getTag(R.id.data);
                if (str.startsWith("添加到")) {
                    String ss = str.substring(3, str.length());
                    getOpe().getBaseDBOpe().add(ss, getOpe().getBaseDAOpe().getItem().getAppName(), getOpe().getBaseDAOpe().getItem().getPackageName());
                    AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size() - 1);
                    appsFrag.getData();
                }
                switch (str) {
                    case "换图":
                        IntentUtil.getInstance().photoShowFromphone(fragment, ValueConstant.CODE_REQUSET);
                        getOpe().getBaseDAOpe().setItem(getOpe().getBaseDAOpe().getData().get(position));
                        break;
                    case "删除":
                        getOpe().getBaseDBOpe().delete(getOpe().getBaseDAOpe().getData().get(position).getId());
                        AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size() - 1);
                        appsFrag.getData();
                        break;
                    case "卸载":
                        IntentUtil.getInstance().uninstall(activity, getOpe().getBaseDAOpe().getItem().getPackageName());
                        getOpe().getBaseDBOpe().delete(getOpe().getBaseDAOpe().getData().get(position).getId());
                        AppsFrag appsFrag1 = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size() - 1);
                        appsFrag1.getData();
                        break;
                    case "刷新":
                        ValueConstant.IS_FROM_SYS = true;
                        AppsFrag appsFrag2 = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size() - 1);
                        appsFrag2.getData();
                        break;
                }
                SheetDialogUtil.getInstance().dismess();
            }
        });
    }

    @Override
    public void onAppItemClick(View view, int position) {
        IntentUtil.getInstance().IntentTo(activity, ((AppAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).getData().get(position).getPackageName());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ValueConstant.CODE_REQUSET:
                if (data == null || data.getData() == null) {
                    return;
                }
                AppDBBean appDBBean = getOpe().getBaseDAOpe().getItem();
                getOpe().getBaseDBOpe().updateIcon(appDBBean.getId(), data.getDataString());
                AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size() - 1);
                appsFrag.getData();
                break;
        }
    }

}
