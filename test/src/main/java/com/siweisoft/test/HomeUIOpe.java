package com.siweisoft.test;

//by summer on 2017-03-30.

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.summer.lib.bean.BaseUIBean;
import com.summer.lib.ope.BaseUIOpe;
import com.summer.lib.ui.interf.IRecycle;
import com.summer.lib.ui.interf.ITitle;

public class HomeUIOpe<A extends BaseUIBean> extends BaseUIOpe<A> implements IRecycle, ITitle {


    public HomeUIOpe(Context context, A uiBean) {
        super(context, uiBean);
    }

    @Override
    public void init(RecyclerView recyclerView) {

    }

    @Override
    public void loadData(RecyclerView recyclerView) {

    }

    @Override
    public void refreshData(RecyclerView recyclerView) {

    }

    @Override
    public void setTxt(TextView txt) {
        txt.setText("homeuiope");
    }
}
