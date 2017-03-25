package com.summer.app.ui.bed.bedlist.ope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;

import com.summer.app.R;
import com.summer.app.ui.bed.bedlist.adapter.BedListAdapter;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.LogUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.view.ItemDecoration.MyItemDecoration;
import com.summer.lib.view.recyclerview.GridRecyclerView;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListFGMUIOpe<A extends CommonUIFrag2> extends BaseNurseUIOpe<A> {

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    GridRecyclerView recyclerView;

    BedListAdapter bedListAdapter;


    public BedListFGMUIOpe(Context context, View convertView, A a) {
        super(context, convertView);
        this.frag = a;
        init();
    }

    private void init() {

        getMidTV().setSelected(true);
        setTitle(1, 0);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setSelected(true);
        getRightTV().setText("增加");
        getRefreshLayout().setMaterialRefreshListener(frag);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.addItemDecoration(new MyItemDecoration(context, 2));
    }

    public void setTitle(int index, int num) {

        switch (index) {
            case 0:
                getMidTV().setText("我的病人" + (num == 0 ? "" : num));
                getRightTV().setText("增加");
                getRightTV().setSelected(true);
                break;
            case 1:
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                getMidTV().setText(data.getWardname() + (num == 0 ? "" : num));
                getRightTV().setText("");
                getRightTV().setSelected(false);
                break;

        }
    }

    public void initBedList(ArrayList<PatientBedResBean> list) {
        bedListAdapter = new BedListAdapter(context, list);
        recyclerView.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                recyclerView.setMove(false);
                LogUtil.E("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                recyclerView.setMove(true);
                LogUtil.E("onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        recyclerView.setAdapter(bedListAdapter);
        recyclerView.scheduleLayoutAnimation();

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public BedListAdapter getBedListAdapter() {
        return bedListAdapter;
    }


}
