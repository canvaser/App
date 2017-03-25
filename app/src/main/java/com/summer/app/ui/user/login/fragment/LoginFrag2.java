package com.summer.app.ui.user.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.user.login.bean.UserInfo;
import com.summer.app.ui.user.setting.fragment.SettingFrag;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.util.NullUtil;
import com.summer.app.nursevalue.BaseID;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.bean.res.BaseResBean;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.util.SheetDialogUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.app.ui.home.activity.IndexActivity;
import com.summer.app.ui.user.login.bean.DoLoginResBean;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;
import com.summer.app.ui.user.login.ope.LoginDAOpe;
import com.summer.app.ui.user.login.ope.LoginUIOpe;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class LoginFrag2 extends CommonUIFrag2<LoginUIOpe<LoginFrag2>, LoginDAOpe<LoginFrag2>> {


    GetallregionbyuserResBean getallregionbyuserResBean;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!NullUtil.isStrEmpty(SPUtil.getInstance().init(activity).getStr(ValueConstant.USER_INFO))) {
            UserInfo userInfo = GsonUtil.getInstance().fromJson(SPUtil.getInstance().init(activity).getStr(ValueConstant.USER_INFO), UserInfo.class);
            baseOpes.getUiOpe().getAccountEt().setText(userInfo.getAccount());
            baseOpes.getUiOpe().getPwdEt().setText(userInfo.getPwd());
            baseOpes.getUiOpe().getAreaTV().setText(userInfo.getRegionname());
            baseOpes.getDaOpe().setSuffix(userInfo.getRegioncode());
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        getData(null);
    }

    public void getData(final OnFinishListener onFinishListener) {
        SimpleNetOpe.onGetallregionbyuser(activity, baseOpes.getUiOpe().getAccountEt().getText().toString(), new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    getallregionbyuserResBean = GsonUtil.getInstance().fromJson(o.toString(), GetallregionbyuserResBean.class);
                    if (getallregionbyuserResBean.getData().size() > 0) {
                        if (NullUtil.isStrEmpty(SPUtil.getInstance().init(activity).getStr(ValueConstant.AREA_INFO))) {
                            baseOpes.getUiOpe().getAreaTV().setText(getallregionbyuserResBean.getData().get(0).getWardname());
                            baseOpes.getDaOpe().setSuffix(getallregionbyuserResBean.getData().get(0).getSuffix());
                            SPUtil.getInstance().init(activity).saveStr(ValueConstant.AREA_INFO, GsonUtil.getInstance().toJson(getallregionbyuserResBean.getData().get(0)));
                        }
                    }

                } else {
                    baseOpes.getUiOpe().getAreaTV().setText("");
                    baseOpes.getDaOpe().setSuffix("");
                    baseOpes.getDaOpe().setAreaName("");
                    SPUtil.getInstance().init(activity).saveStr(ValueConstant.AREA_INFO, "");
                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(true);
                }
            }
        });
    }

    @Optional
    @OnClick({R.id.btn_login, R.id.tv_area, BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (NullUtil.isStrEmpty(SPUtil.getInstance().init(activity).getStr(ValueConstant.AREA_INFO))) {
                    return;
                }
                //LoadUtil.getInstance().onStartLoading(this);
                SimpleNetOpe.onLogin(activity, baseOpes.getUiOpe().getAccountEt().getText().toString() + baseOpes.getDaOpe().getSuffix(), baseOpes.getUiOpe().getPwdEt().getText().toString(), new UINetAdapter(activity) {

                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(o.toString(), DoLoginResBean.class);
                            UserInfo userInfo = new UserInfo();
                            userInfo.setAccount(baseOpes.getUiOpe().getAccountEt().getText().toString());
                            userInfo.setPwd(baseOpes.getUiOpe().getPwdEt().getText().toString());
                            userInfo.setRegionname(baseOpes.getUiOpe().getAreaTV().getText().toString());
                            userInfo.setRegioncode(baseOpes.getDaOpe().getSuffix());
                            SPUtil.getInstance().init(activity).saveStr(ValueConstant.USER_INFO, GsonUtil.getInstance().toJson(userInfo));
                            SPUtil.getInstance().init(activity).saveStr(ValueConstant.LOGIN_INFO, o.toString());
                            startActivity(new Intent(activity, IndexActivity.class));
                            activity.finish();
                        } else {
                            BaseResBean baseResBean = (BaseResBean) o;
                            ToastUtil.getInstance().show(activity, baseResBean.getErrorMessage());
                        }

                    }
                });
                break;
            case R.id.tv_area:
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        if (!(Boolean) o) {
                            return;
                        }
                        ArrayList<String> s = new ArrayList<>();
                        for (int i = 0; i < getallregionbyuserResBean.getData().size(); i++) {
                            s.add(getallregionbyuserResBean.getData().get(i).getWardname());
                        }
                        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, s);
                        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TextView textView = (TextView) v;
                                baseOpes.getUiOpe().getAreaTV().setText(textView.getText().toString());
                                for (int i = 0; i < getallregionbyuserResBean.getData().size(); i++) {
                                    if (getallregionbyuserResBean.getData().get(i).getWardname().equals(baseOpes.getUiOpe().getAreaTV().getText().toString())) {
                                        baseOpes.getDaOpe().setSuffix(getallregionbyuserResBean.getData().get(i).getSuffix());
                                        SPUtil.getInstance().init(activity).saveStr(ValueConstant.AREA_INFO, GsonUtil.getInstance().toJson(getallregionbyuserResBean.getData().get(i)));
                                    }
                                }
                                SheetDialogUtil.getInstance().dismess();
                            }
                        });
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                FragmentUtil.getInstance().addToContaier(activity, this, new SettingFrag(), R.id.root);
                break;
        }
    }


    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new LoginUIOpe<LoginFrag2>(activity, getView()), new LoginDAOpe<LoginFrag2>(activity));
        }
        return R.layout.frag_login;
    }
}
