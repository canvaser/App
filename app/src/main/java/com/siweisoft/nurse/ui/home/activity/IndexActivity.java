package com.siweisoft.nurse.ui.home.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.activity.BaseUIWithOutTitleActivity;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemSelectListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.home.bean.resbean.KeepAliveResBean;
import com.siweisoft.nurse.ui.home.ope.HomeDataOpe;
import com.siweisoft.nurse.ui.home.ope.HomeUIOpe;
import com.siweisoft.nurse.ui.home.ope.KeepAliveDAOpe;
import com.siweisoft.nurse.ui.scan.ope.ScanResultDAOpe;
import com.siweisoft.nurse.ui.user.login.activity.LoginActivity;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.lib.uuzuche.lib_zxing.activity.CaptureActivity;
import com.siweisoft.lib.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class IndexActivity extends BaseUIWithOutTitleActivity implements OnAppItemSelectListener, OnAppItemLongClickListener, View.OnLongClickListener {


    HomeUIOpe homeUIOpe;

    HomeDataOpe homeDataOpe;

    NurseNetOpe homeNetOpe;

    KeepLive keepLive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeUIOpe = new HomeUIOpe(activity, getRootVG());
        homeDataOpe = new HomeDataOpe(activity);
        homeNetOpe = new NurseNetOpe(activity);
        homeUIOpe.getHomeBottomView().setOnAppItemSelectListener(this);
        homeUIOpe.getHomeBottomView().setOnAppItemLongClickListener(this);
        homeUIOpe.getHomeBottomView().setOnLongClick(this);
        homeNetOpe.getAdditionList(new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    SPUtil.getInstance().saveStr(ValueConstant.ADDITION_INFO, o.toString());
                }
            }
        });
        keepLive = new KeepLive();
        registerReceiver(keepLive, new IntentFilter(getPackageName() + ValueConstant.ACITON_GLOB_CAST));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(keepLive);
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_home;
    }

    @Override
    public void onAppItemSelect(ViewGroup viewGroup, View view, int position) {
        homeDataOpe.setIndex(position);
        homeUIOpe.getViewPager().setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        if (FragManager.getInstance().getFragMaps().get(homeDataOpe.getIndex()).size() > 1) {

            FragManager.getInstance().finish(getSupportFragmentManager(), homeDataOpe.getIndex());
        } else {
//            FragManager.getInstance().finish(activity);
//            activity.finish();
        }

    }

    public HomeUIOpe getHomeUIOpe() {
        return homeUIOpe;
    }

    public HomeDataOpe getHomeDataOpe() {
        return homeDataOpe;
    }

    @Override
    public void onAppItemLongClick(View view, int position) {
        FragManager.getInstance().clearTop(getSupportFragmentManager(), position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ValueConstant.CODE_REQUSET:
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    switch (bundle.getInt(CodeUtils.RESULT_TYPE)) {
                        case CodeUtils.RESULT_SUCCESS:
                            String result = bundle.getString(CodeUtils.RESULT_STRING);
                            //Toast.makeText(activity, "解析结果:" + result, Toast.LENGTH_LONG).show();
                            ScanResultDAOpe.getInstance().sortResult(activity, result);

//                            WriteBedCheckReqBean reqBean = GsonUtil.getInstance().fromJson(result,WriteBedCheckReqBean.class);
//
//
//                            new NurseNetOpe(activity).writeWardInspectionInfo(reqBean, new UINetAdapter(activity) {
//                                @Override
//                                public void onNetWorkResult(boolean success, Object o) {
//                                    if(success){
//                                        FragManager.getInstance().clearTop(getSupportFragmentManager(),3);
//                                        homeUIOpe.getViewPager().setCurrentItem(3);
//                                        FragManager.getInstance().startFragment(getSupportFragmentManager(),3,new BedCheckFrag());
//                                    }
//                                }
//                            });


                            break;
                        default:
                            Toast.makeText(activity, "解析二维码失败", Toast.LENGTH_LONG).show();
                            break;
                    }
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        startActivityForResult(new Intent(activity, CaptureActivity.class), ValueConstant.CODE_REQUSET);
        return true;
    }

    class KeepLive extends BroadcastReceiver {

        KeepAliveDAOpe keepAliveDAOpe = new KeepAliveDAOpe(activity);
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent == null && intent.getIntExtra(ValueConstant.DATA_DATA, -1) == -1) {
                return;
            }
            homeNetOpe.keepAlive(new OnNetWorkReqAdapter(activity) {
                @Override
                public void onNetWorkResult(boolean success, Object o) {
                    LogUtil.E(DataValue.URL_KEEP_ALIVE + "-" + o);
                    if (success) {
                        KeepAliveResBean keepAliveResBean = GsonUtil.getInstance().fromJson(o.toString(), KeepAliveResBean.class);
                        keepAliveDAOpe.analysisData(activity, keepAliveResBean.getData());
                    } else {
                        startActivity(new Intent(activity, LoginActivity.class));
                        finish();
                    }
                }
            });
        }
    }
}
