package com.siweisoft.nurse.ui.setting.updatepwd.ope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.siweisoft.app.R;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.ToastUtil;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class UpdatePwdUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.et_beforepwd)
    EditText beforePwdEt;


    @BindView(R.id.et_newpwd)
    EditText newPwdEt;

    @BindView(R.id.et_newpwd2)
    EditText newPwd2Et;


    public UpdatePwdUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }


    private void init(){
        getBackTV().setSelected(true);
        getBackTV().setText("返回");

        getRightTV().setSelected(true);
        getRightTV().setText("提交");
    }

    public boolean isReady(){
        if(NullUtil.isStrEmpty(getBeforePwdEt().getText().toString())){
            ToastUtil.getInstance().show(context,"请输入原密码");
            return false;
        }

        if(NullUtil.isStrEmpty(getNewPwdEt().getText().toString())){
            ToastUtil.getInstance().show(context,"请输入新密码");
            return false;
        }

        if(NullUtil.isStrEmpty(getNewPwd2Et().getText().toString())){
            ToastUtil.getInstance().show(context,"请输重复密码");
            return false;
        }
        if(!getNewPwd2Et().getText().toString().equals(getNewPwdEt().getText().toString())){
            ToastUtil.getInstance().show(context,"重复密码不一致");
            return false;
        }
        return true;
    }


    public EditText getBeforePwdEt() {
        return beforePwdEt;
    }

    public void setBeforePwdEt(EditText beforePwdEt) {
        this.beforePwdEt = beforePwdEt;
    }

    public EditText getNewPwd2Et() {
        return newPwd2Et;
    }

    public void setNewPwd2Et(EditText newPwd2Et) {
        this.newPwd2Et = newPwd2Et;
    }

    public EditText getNewPwdEt() {
        return newPwdEt;
    }

    public void setNewPwdEt(EditText newPwdEt) {
        this.newPwdEt = newPwdEt;
    }
}
