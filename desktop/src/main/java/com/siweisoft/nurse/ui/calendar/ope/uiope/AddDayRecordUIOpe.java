package com.siweisoft.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.image.adapter.ImagesAdapter;
import com.siweisoft.nurse.ui.image.bean.dabean.PicBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class AddDayRecordUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.et_addrecord)
    EditText addET;


    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public AddDayRecordUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getRightTV().setText("完成");
        getBackTV().setText("添加");
        getBackTV().setVisibility(View.VISIBLE);
    }

    public void initList(ArrayList<PicBean> data) {
        if (data == null) {
            recyclerView.setAdapter(null);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(new ImagesAdapter(context, data));
    }

    public boolean isFit() {
        return !TextUtils.isEmpty(addET.getText()) || recyclerView.getAdapter() != null;
    }


    public EditText getAddET() {
        return addET;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
