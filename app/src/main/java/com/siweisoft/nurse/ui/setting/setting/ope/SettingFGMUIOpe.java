package com.siweisoft.nurse.ui.setting.setting.ope;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.MethodConstant;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginResBean;

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

    private void init(){
        getMidTV().setText("设置");
        getRightTV().setText("注销");
        getBackTV().setSelected(true);
        getBackTV().setText("高级");
        getRightTV().setSelected(true);
        String str = SPUtil.getInstance().init(context).getStr(ValueConstant.LOGIN_INFO);
        if(str!=null){
            DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(str,DoLoginResBean.class);
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
