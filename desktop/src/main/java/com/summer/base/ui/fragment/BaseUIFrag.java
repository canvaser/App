package com.summer.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import com.summer.app.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.summer.nurse.ui.setting.setting.bean.dbbean.BackUIDBBean;
import com.summer.nurse.ui.setting.setting.ope.dbope.BackUIDBOpe;
import com.summer.util.BitmapUtil;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public abstract class BaseUIFrag extends BaseFrg {


    private Unbinder unbinder;

    protected BackUIDBOpe backUIDBOpe;

    public BaseUIFrag() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backUIDBOpe = new BackUIDBOpe(activity, new BackUIDBBean());
        backUIDBOpe.addOrUpdate(getClass().getSimpleName(), null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View group = (ViewGroup) inflater.inflate(getLayoutID(), null);
        ViewGroup parent = (ViewGroup) group.findViewById(R.id.rl_base_container);
        View view = inflater.inflate(getContainView(), container, false);
        parent.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        unbinder = ButterKnife.bind(this, group);
        return group;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        BackUIDBBean backUIDBBean = backUIDBOpe.get(getClass().getSimpleName());
        if (backUIDBBean != null) {
            ImageView imageView = (ImageView) getView().findViewById(R.id.iv_info);
            if (imageView != null && backUIDBBean.getBackUrl() != null) {
                BitmapUtil.getInstance().setBg(activity, imageView, backUIDBBean.getBackUrl());
            } else if (imageView != null && backUIDBBean.getBackUrl() == null) {
                imageView.setImageResource(R.drawable.bg);
            }
        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public abstract int getContainView();

    public int getLayoutID() {
        return R.layout.layout_baseui;
    }

}
