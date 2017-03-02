package com.siweisoft.nurse.ui.image.ope.uiope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.image.adapter.ImagesAdapter;
import com.siweisoft.nurse.ui.image.bean.dabean.PicBean;
import com.siweisoft.util.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-06.
 */

public class ImagesUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.recycle)
    RecyclerView recyclerView;


    public ImagesUIOpe(Context context, View containerView) {
        super(context, containerView);
        getRightTV().setText("完成");
    }

    public void initList(ArrayList<PicBean> data) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(new ImagesAdapter(context, data));
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
