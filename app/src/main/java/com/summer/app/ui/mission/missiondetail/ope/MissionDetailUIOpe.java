package com.summer.app.ui.mission.missiondetail.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ui.mission.missiondetail.adapter.MissionDetailListAdapter;
import com.summer.app.ui.mission.missiondetail.adapter.MissionDetailUnClickableAdapter;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.summer.lib.util.BitmapUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.view.ItemDecoration.MyItemDecoration2;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MissionDetailUIOpe extends BaseNurseUIOpe {


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

    private void init() {


        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MyItemDecoration2(context, 2));
    }


    public void initData(AreaMessionListResBean.DataBean resBean) {

        getMidTV().setText(resBean.getBedId() + " " + resBean.getName());
        AreaMessionDAOpe areaMessionDAOpe = new AreaMessionDAOpe(context);
        if (areaMessionDAOpe.isLin(resBean.getTitles().get(0).get医嘱ID(), resBean.getTitles().get(0).getKey())) {
            Object[] o = areaMessionDAOpe.getLin(true);
            getLinTv().setText(o[0].toString());
            getLinTv().setTextColor((Integer) o[1]);
        } else {
            Object[] o = areaMessionDAOpe.getLin(false);
            getLinTv().setText(o[0].toString());
            getLinTv().setTextColor((Integer) o[1]);
        }
        int[] i = areaMessionDAOpe.isInJecting(resBean.getCodename());
        getTypeTV().setTextColor(i[0]);
        BitmapUtil.getInstance().setBg(context, getCodenameIV(), i[1]);
        getTypeTV().setText(resBean.getCodename().trim());

        getYzIdTV().setText("医嘱ID:  " + StringUtil.getStr(resBean.getTitles().get(0) == null ? "" : resBean.getTitles().get(0).get医嘱ID()));
        getDateTV().setText("任务时间:" + StringUtil.getStr(resBean.getStart()));

        if (resBean.isClickable()) {
            if (missionDetailListAdapter == null) {
                missionDetailListAdapter = new MissionDetailListAdapter(context, resBean.getTitles());
                recyclerView.setAdapter(missionDetailListAdapter);
            } else {
                missionDetailListAdapter.notifyDataSetChanged();
            }
        } else {
            recyclerView.setAdapter(new MissionDetailUnClickableAdapter(context, resBean.getTitles()));
        }


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
