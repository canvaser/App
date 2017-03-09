package com.siweisoft.ui.check.checkblood.ope;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.lib.util.StringUtil;

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
    }

    public void showFristInfo(String num) {
        getInfoV().setVisibility(View.GONE);
        getShowNumTV().setVisibility(View.VISIBLE);
        getShowNumTV().setText("请扫描病人腕带与试管" + StringUtil.getStr(num) + "进行匹配");
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
