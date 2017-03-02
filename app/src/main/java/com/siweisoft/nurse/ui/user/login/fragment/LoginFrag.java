package com.siweisoft.nurse.ui.user.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.fragment.BaseUIFragment;
import com.siweisoft.lib.base.ui.fragment.CommonUIFrag;
import com.siweisoft.lib.base.ui.ope.CommonOpes;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.listener.BaseTextWather;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.bean.res.BaseResBean;
import com.siweisoft.lib.util.FragmentUtil;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.lib.util.SheetDialogUtil;
import com.siweisoft.lib.util.ToastUtil;
import com.siweisoft.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.nurse.ope.SimpleNetOpe;
import com.siweisoft.nurse.ui.home.activity.IndexActivity;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginResBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.nurse.ui.user.login.ope.LoginDAOpe;
import com.siweisoft.nurse.ui.user.login.ope.LoginUIOpe;
import com.siweisoft.nurse.ui.user.setting.fragment.SettingFrag;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class LoginFrag extends CommonUIFrag<LoginUIOpe<LoginFrag>, LoginDAOpe<LoginFrag>> {


    GetallregionbyuserResBean getallregionbyuserResBean;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        commonOpes.getUiOpe().getAccountEt().addTextChangedListener(new BaseTextWather() {
            @Override
            public void afterTextChanged(Editable s) {
                // getData();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        getData(null);
    }

    public void getData(final OnFinishListener onFinishListener) {
        SimpleNetOpe.onGetallregionbyuser(activity, commonOpes.getUiOpe().getAccountEt().getText().toString(), new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    getallregionbyuserResBean = GsonUtil.getInstance().fromJson(o.toString(), GetallregionbyuserResBean.class);
                    if (getallregionbyuserResBean.getData().size() > 0) {
                        commonOpes.getUiOpe().getAreaTV().setText(getallregionbyuserResBean.getData().get(0).getWardname());
                        commonOpes.getDaOpe().setSuffix(getallregionbyuserResBean.getData().get(0).getSuffix());
                        commonOpes.getDaOpe().setAreaName(getallregionbyuserResBean.getData().get(0).getWardname());
                        SPUtil.getInstance().init(activity).saveStr(ValueConstant.AREA_INFO, GsonUtil.getInstance().toJson(getallregionbyuserResBean.getData().get(0)));
                    }
                    if (onFinishListener != null) {
                        onFinishListener.onFinish(true);
                    }
                } else {
                    commonOpes.getUiOpe().getAreaTV().setText("");
                    commonOpes.getDaOpe().setSuffix("");
                    commonOpes.getDaOpe().setAreaName("");
                    SPUtil.getInstance().init(activity).saveStr(ValueConstant.AREA_INFO, "");
                    if (onFinishListener != null) {
                        onFinishListener.onFinish(false);
                    }
                }
            }
        });
    }

    @Optional
    @OnClick({R.id.btn_login, R.id.tv_area, BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                //LoadUtil.getInstance().onStartLoading(this);
                SimpleNetOpe.onLogin(activity, commonOpes.getUiOpe().getAccountEt().getText().toString() + commonOpes.getDaOpe().getSuffix(), commonOpes.getUiOpe().getPwdEt().getText().toString(), new UINetAdapter(activity) {

                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(o.toString(), DoLoginResBean.class);
                            SPUtil.getInstance().init(activity).saveStr(ValueConstant.LOGIN_INFO, o.toString());
                            startActivity(new Intent(activity, IndexActivity.class));
                            activity.finish();
                        } else {
                            BaseResBean baseResBean = (BaseResBean) o;
                            ToastUtil.getInstance().show(activity, baseResBean.getErrorMessage());
                        }

                    }
                });
//                startActivityForResult(new Intent(activity, CaptureActivity.class),ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_area:
//                if(NullUtil.isNull(getallregionbyuserResBean)||NullUtil.isNull(getallregionbyuserResBean.getData())||NullUtil.isNull(getallregionbyuserResBean.getData().get(0))||NullUtil.isNull(getallregionbyuserResBean.getData().get(0).getSuffix())){
//                    return;
//                }
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
                                commonOpes.getUiOpe().getAreaTV().setText(textView.getText().toString());
                                for (int i = 0; i < getallregionbyuserResBean.getData().size(); i++) {
                                    if (getallregionbyuserResBean.getData().get(i).getWardname().equals(commonOpes.getUiOpe().getAreaTV().getText().toString())) {
                                        commonOpes.getDaOpe().setSuffix(getallregionbyuserResBean.getData().get(i).getSuffix());
                                        commonOpes.getDaOpe().setAreaName(getallregionbyuserResBean.getData().get(i).getWardname());
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
            commonOpes = new CommonOpes<>(new LoginUIOpe<LoginFrag>(activity, getView()), new LoginDAOpe<LoginFrag>(activity));
        }
        return R.layout.frag_login;
    }
}
