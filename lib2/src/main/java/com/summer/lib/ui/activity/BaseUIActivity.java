package com.summer.lib.ui.activity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.summer.lib.R;
import com.summer.lib.constant.color.ColorConstant;
import com.summer.lib.util.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * Created by summer on 2016/4/16 0016 11:51.
 */
public abstract class BaseUIActivity extends BaseActivity {

    //添加内容界面的容器
    private ViewGroup containerVG;

    //最底层的布局
    private ViewGroup rootVG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        isFullScreen(isFullScreen());
        super.onCreate(savedInstanceState);
        if (isLandScape()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentView(R.layout.layout_baseui_withouttitle);
        if (!isLandScape()) {
            StatusBarUtil.getInstance().setStatusBarColorResId(activity, getStatusColor());
        }
        containerVG = (ViewGroup) findViewById(R.id.rl_base_container);
        View rootV = getLayoutInflater().inflate(onCreateContainerView(), null);
        containerVG.addView(rootV, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootVG = (ViewGroup) findViewById(R.id.ll_base_root);
        ButterKnife.bind(activity);
    }

    public int getStatusColor() {
        return ColorConstant.COLOR_STATUS;
    }

    //设置界面布局
    protected abstract int onCreateContainerView();


    public boolean isLandScape() {
        return false;
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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

    public ViewGroup getRootVG() {
        return rootVG;
    }
}
