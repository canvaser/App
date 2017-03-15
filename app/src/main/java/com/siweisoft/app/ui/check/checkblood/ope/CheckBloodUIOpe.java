package com.siweisoft.app.ui.check.checkblood.ope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.check.checkblood.adapter.CheckbloodAdpter;
import com.siweisoft.app.ui.check.checkblood.bean.CheckPatAndPipeResBean;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class CheckBloodUIOpe<A extends CommonUIFrag2> extends BaseNurseUIOpe<A> {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_bedid)
    TextView tvBedid;
    @BindView(R.id.tv_zyh)
    TextView tvZyh;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.ll_info)
    View infoV;
    @BindView(R.id.tv_shownum)
    TextView showNumTV;

    public CheckBloodUIOpe(Context context, View containerView) {
        super(context, containerView);
        getMidTV().setText("病人抽血核对");
        getMidTV().setVisibility(View.VISIBLE);
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        recycle.setLayoutManager(new LinearLayoutManager(context));
        recycle.addItemDecoration(new MyItemDecoration2(context, 1));
    }

    public void showFristInfo(String num) {
        getInfoV().setVisibility(View.GONE);
        getShowNumTV().setVisibility(View.VISIBLE);
        getShowNumTV().setText("请扫描病人腕带与试管" + StringUtil.getStr(num) + "进行匹配");
    }

    public void showPatientInfo(CheckPatAndPipeResBean.DataBean data) {
        if (data == null) {
            return;
        }
        getInfoV().setVisibility(View.VISIBLE);
        getShowNumTV().setVisibility(View.GONE);
        getTvName().setText("姓名：" + StringUtil.getStr(data.getName()));
        getTvBedid().setText("床号：" + StringUtil.getStr(data.getBedno()));
        getTvZyh().setText("住院号：" + StringUtil.getStr(data.getZyh()));
    }

    public void initList(ArrayList<CheckPatAndPipeResBean> data) {
        recycle.setAdapter(new CheckbloodAdpter(context, data));
    }



    public RecyclerView getRecycle() {
        return recycle;
    }

    public TextView getTvBedid() {
        return tvBedid;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvZyh() {
        return tvZyh;
    }

    public TextView getShowNumTV() {
        return showNumTV;
    }

    public View getInfoV() {
        return infoV;
    }
}
