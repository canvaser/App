package com.summer.base.ui.ope;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;

/**
 * Created by ${viwmox} on 2017-01-23.
 */

public class BaseActivityUIOpe extends BaseUIOpe {

    /**
     * 添加内容界面的容器
     */
    private ViewGroup containerVG;

    public BaseActivityUIOpe(Context context, View containerView) {
        super(context, containerView);
        containerVG = (ViewGroup) containerView.findViewById(R.id.frag_base_container);
        View rootV = inflater.inflate(onCreateContainerView(), null);
        containerVG.addView(rootV, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    /**
     * 设置界面布局
     *
     * @return 界面布局id
     */
    protected int onCreateContainerView() {
        return -1;
    }

    public ViewGroup getContainerVG() {
        return containerVG;
    }
}
