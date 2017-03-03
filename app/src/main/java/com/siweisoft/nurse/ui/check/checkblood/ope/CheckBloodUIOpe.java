package com.siweisoft.nurse.ui.check.checkblood.ope;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

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

    public CheckBloodUIOpe(Context context, View containerView) {
        super(context, containerView);
        getMidTV().setText("病人抽血核对");
        getMidTV().setVisibility(View.VISIBLE);
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
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
}
