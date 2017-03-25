package com.siweisoft.test;

//by summer on 2017-03-25.

import com.summer.lib.bean.UIBean.BaseUIBean;
import com.summer.lib.ui.fragment.BaseUIFrag;
import com.summer.lib.ui.ope.CommonOpes;

public class MainFrag extends BaseUIFrag<MainUIOpe, MainDAOpe> {


    @Override
    public BaseUIBean getUIBean(boolean create) {
        opes = new CommonOpes<>(new MainUIOpe(activity, new MainUIBean(activity).getView()), new MainDAOpe());
        return null;
    }
}
