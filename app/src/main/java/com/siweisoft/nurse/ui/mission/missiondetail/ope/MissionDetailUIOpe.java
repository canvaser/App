package com.siweisoft.nurse.ui.mission.missiondetail.ope;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.util.BitmapUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.mission.missiondetail.adapter.MissionDetailListAdapter;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MissionDetailUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.lin)
    TextView linTv;


    @BindView(R.id.iv_codename)
    ImageView codenameIV;

    @BindView(R.id.tv_yzid)
    TextView yzIdTV;


    @BindView(R.id.tv_date)
    TextView dateTV;

    @BindView(R.id.type)
    TextView typeTV;



    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    MissionDetailListAdapter missionDetailListAdapter;

    public MissionDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){


        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
    }


    public void initData(AreaMessionResBean resBean){

        getMidTV().setText(resBean.getName());


        getTypeTV().setText(resBean.getBedId()+" "+resBean.getCodename());
        if("st".equals(resBean.getTitles().get(0).getKey().toLowerCase())|| resBean.getCodename().equals("出院带药")){
            getLinTv().setText("临");
            getLinTv().setTextColor(Color.parseColor("#A52A2A"));
        }else{
            getLinTv().setText("长");
            getLinTv().setTextColor(Color.parseColor("#7FFFD4"));
        }

        switch (resBean.getCodename()){
            case "护理":
                BitmapUtil.getInstance().setBg(context,getCodenameIV(),R.drawable.icon_medicine);
                break;
            case "药品":
                BitmapUtil.getInstance().setBg(context,getCodenameIV(),R.drawable.icon_injecting);
                break;
        }

        getYzIdTV().setText("医嘱ID:  "+ StringUtil.getStr(resBean.getTitles().get(0)==null?"":resBean.getTitles().get(0).get医嘱ID()));
        getDateTV().setText("任务时间:"+StringUtil.getStr(resBean.getStart()));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        missionDetailListAdapter = new MissionDetailListAdapter(context,resBean.getTitles());
        recyclerView.setAdapter(missionDetailListAdapter);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MissionDetailListAdapter getMissionDetailListAdapter() {
        return missionDetailListAdapter;
    }

    public ImageView getCodenameIV() {
        return codenameIV;
    }

    public TextView getDateTV() {
        return dateTV;
    }

    public TextView getLinTv() {
        return linTv;
    }

    public TextView getYzIdTV() {
        return yzIdTV;
    }

    public TextView getTypeTV() {
        return typeTV;
    }
}
