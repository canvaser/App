package com.siweisoft.nurse.ui.setting.scanlist.ope;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-09.
 */
public class ScanListUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    public ScanListUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("二维码记录");

        getRightTV().setSelected(true);
        getRightTV().setText("清空");
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
