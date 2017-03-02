package com.siweisoft.nurse.ui.setting.backsetting.ope.daope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.setting.setting.bean.dbbean.BackUIDBBean;

/**
 * Created by summer on 2016/12/31 14:48.
 */

public class BackSettingDAOpe extends BaseDAOpe {

    BackUIDBBean backUIDBBean;

    public BackSettingDAOpe(Context context) {
        super(context);
    }

    public BackUIDBBean getBackUIDBBean() {
        return backUIDBBean;
    }

    public void setBackUIDBBean(BackUIDBBean backUIDBBean) {
        this.backUIDBBean = backUIDBBean;
    }
}
