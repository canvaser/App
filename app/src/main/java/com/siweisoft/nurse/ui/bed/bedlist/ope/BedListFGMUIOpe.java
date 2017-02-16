package com.siweisoft.nurse.ui.bed.bedlist.ope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.lib.view.recyclerview.GridRecyclerView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.bedlist.adapter.BedListAdapter;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListFGMUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    @BindView(R.id.recycle)
    GridRecyclerView recyclerView;

    BedListAdapter bedListAdapter;



    public BedListFGMUIOpe(Context context, View convertView) {
        super(context, convertView);
        init();
    }

    private void init(){

        getMidTV().setSelected(true);
        setTitle(1,0);


        getRightTV().setSelected(true);
        getRightTV().setText("增加");

    }

    public void setTitle(int index , int num){

        switch (index){
            case 0:
                getMidTV().setText("我的病人"+(num==0?"":num));
                getRightTV().setText("增加");
                getRightTV().setSelected(true);
                break;
            case 1:
                GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
                getMidTV().setText(data.getWardname()+(num==0?"":num));
                getRightTV().setText("");
                getRightTV().setSelected(false);
                break;

        }
    }

    public void initBedList(ArrayList<PatientBedResBean> list){
        recyclerView.setLayoutManager(new GridLayoutManager(context,4));
        //recyclerView.addItemDecoration(new MyItemDecoration(context,3* ValueConstant.DIMEN_1));
        bedListAdapter = new BedListAdapter(context,list);
        recyclerView.setAdapter(bedListAdapter);
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
