package com.siweisoft.base.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.siweisoft.app.R;
import com.siweisoft.constant.color.ColorConstant;
import com.siweisoft.util.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by summer on 2016/4/16 0016 11:51.
 */
public abstract class BaseUIActivity extends BaseActivity{

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
        setContentView(R.layout.layout_baseui_withouttitle);
        //StatusBarUtil.getInstance().setStatusBarColorResId(activity, ColorConstant.COLOR_STATUS);
        containerVG= (ViewGroup) findViewById(R.id.rl_base_container);
        View rootV = getLayoutInflater().inflate(onCreateContainerView(), null);
        containerVG.addView(rootV, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        rootVG= (ViewGroup) findViewById(R.id.ll_base_root);
        ButterKnife.bind(activity);
    }

    /**
     * 设置界面布局
     * @return 界面布局id
     */
    protected abstract int onCreateContainerView();


    public boolean isFullScreen(){
        return false;
    }

    private void isFullScreen(boolean is){
        if(is){
            // 隐藏标题栏
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            // 隐藏状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }
    }


    @Optional@OnClick(value = {R.id.ftv_back})
    public void onBaseUIClickEvent(View view){
        switch (view.getId()){
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
