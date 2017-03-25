package com.summer.base.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.summer.app.R;
import com.summer.constant.color.ColorConstant;
import com.summer.util.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by summer on 2016/4/16 0016 11:51.
 */
public abstract class BaseUIActivity extends BaseActivity {

    /**
     * 添加内容界面的容器
     */
    private ViewGroup containerVG;

    /**
     * 最底层的布局
     */
    private ViewGroup rootVG;

    protected Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isFullScreen(isFullScreen());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        rootVG = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.layout_baseui, null);
        setContentView(rootVG);
        haveTitle(haveTitle());
        StatusBarUtil.getInstance().setStatusBarColorResId(activity, ColorConstant.COLOR_STATUS);
        containerVG = (ViewGroup) findViewById(R.id.rl_base_container);
        containerVG.addView(getLayoutInflater().inflate(onCreateContainerView(), null), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(activity);
    }

    /**
     * 设置界面布局
     *
     * @return 界面布局id
     */
    protected abstract int onCreateContainerView();


    public boolean haveTitle() {
        return true;
    }

    private void haveTitle(boolean have) {
        if (!have) {
            View view = findViewById(R.id.rl_base_titlecontainer);
            ViewGroup vg = (ViewGroup) view.getParent();
            vg.removeView(view);
            rootVG.requestLayout();
        }
    }


    public boolean isFullScreen() {
        return false;
    }

    private void isFullScreen(boolean is) {
        if (is) {
            // 隐藏标题栏
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            // 隐藏状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }
    }


    @Optional
    @OnClick(value = {R.id.ftv_back})
    public void onBaseUIClickEvent(View view) {
        switch (view.getId()) {
            case R.id.ftv_back:
                this.finish();
                break;
        }
    }


    public ViewGroup getContainerVG() {
        return containerVG;
    }

    public ViewGroup getRootVG() {
        return rootVG;
    }
}
