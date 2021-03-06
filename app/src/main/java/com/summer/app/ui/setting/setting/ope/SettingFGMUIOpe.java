package com.summer.app.ui.setting.setting.ope;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ui.user.login.bean.DoLoginResBean;
import com.summer.lib.constant.MethodConstant;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.app.nursevalue.DataValue;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class SettingFGMUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.tv_account)
    TextView accountTV;

    @BindView(R.id.tv_verson)
    TextView versionTV;

    @BindView(R.id.tv_serverip)
    TextView serviceIpTV;

    public SettingFGMUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setBackgroundResource(R.drawable.drawable_right);
        getMidTV().setText("设置");
        getRightTV().setText("注销");
        getBackTV().setSelected(true);
        getBackTV().setText("高级");
        getRightTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        String str = SPUtil.getInstance().init(context).getStr(ValueConstant.LOGIN_INFO);
        if (str != null) {
            DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(str, DoLoginResBean.class);
            nameTV.setText(doLoginResBean.getData().getUser().getDisplayname());
            accountTV.setText(doLoginResBean.getData().getUser().getEmail());
            versionTV.setText(MethodConstant.getVersionName(context));
            serviceIpTV.setText(DataValue.URL_NURSE);
        }
    }


    public TextView getAccountTV() {
        return accountTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public TextView getServiceIpTV() {
        return serviceIpTV;
    }

    public TextView getVersionTV() {
        return versionTV;
    }
}
