package com.summer.app.ui.addwater.addaddwater.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ui.addwater.addaddwater.adapter.DiSuListAdapter;
import com.summer.app.ui.addwater.addaddwater.bean.dabean.DishuDABean;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.util.LogUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.view.ItemDecoration.MyItemDecoration2;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-17.
 */

public class CountDiShuUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.tv_sudu)
    TextView tvSudu;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.ftv_right1)
    TextView recountTV;

    public CountDiShuUIOpe(Context context, View containerView) {
        super(context, containerView);
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("测滴速");
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("确认");
        TextView textView = (TextView) containerView.findViewById(R.id.ftv_right1);
        textView.setVisibility(View.VISIBLE);
        textView.setText("重置");
        recycle.setLayoutManager(new LinearLayoutManager(context));
        recycle.addItemDecoration(new MyItemDecoration2(context, 2));
    }

    public void clear() {
        tvSudu.setText("速度：0");
        tvTime.setText("总时间：0s");
        tvStart.setText("请按此处重新计算滴速");

    }

    public void setTitle(int n, int num, long sudu, long alltiime) {
        tvSudu.setText("速度：" + StringUtil.getStr(sudu));
        tvTime.setText("总时间：" + StringUtil.getStr(alltiime) + "s");

        tvStart.setText(StringUtil.getStr("第" + (num - 1) + "滴"));
        LogUtil.E(n + ":" + num);
        if (num == (n + 1)) {
            tvStart.setText(StringUtil.getStr("第" + (num - 1) + "滴,此次测滴速已完成"));
        }
    }

    public void setTitle(int num) {
        tvStart.setText(StringUtil.getStr("第" + (num - 1) + "滴"));
    }

    public void initList(ArrayList<DishuDABean> data) {
        if (recycle.getAdapter() == null) {
            recycle.setAdapter(new DiSuListAdapter(context, data));
        } else {
            recycle.getAdapter().notifyDataSetChanged();
            recycle.smoothScrollToPosition((data.size() - 1) > 0 ? data.size() - 1 : 0);
        }
    }


    public TextView getRecountTV() {
        return recountTV;
    }

    public RecyclerView getRecycle() {
        return recycle;
    }

    public TextView getTvStart() {
        return tvStart;
    }

    public TextView getTvSudu() {
        return tvSudu;
    }

    public TextView getTvTime() {
        return tvTime;
    }
}
