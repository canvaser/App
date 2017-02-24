package com.siweisoft.nurse.ui.addwater.addaddwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SheetDialogUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.GetBylResBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.ope.daope.AddAddWaterDAOpe;
import com.siweisoft.nurse.ui.addwater.addaddwater.ope.uiope.AddAddWaterUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.DelayUINetAdapter;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddAddWaterFrag extends BaseNurseFrag<AddAddWaterUIOpe,NurseNetOpe,BaseDBOpe,AddAddWaterDAOpe>{



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseDAOpe().setAreaMessionResBean((AreaMessionResBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(this);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    public void getData(final OnFinishListener onFinishListener){
        getOpe().getBaseNetOpe().document_documemtdetail("71", new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                getOpe().getBaseDAOpe().setAddAddWaterResBean(GsonUtil.getInstance().fromJson(o.toString(), AddAddWaterResBean.class));
                getOpe().getBaseDAOpe().fillcontent(getOpe().getBaseDAOpe().getAreaMessionResBean().getTitles().get(0).getTitle());
                getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getAddAddWaterResBean());
                getBYLbyId(onFinishListener);
            }
        });
    }

    public void getBYLbyId(final OnFinishListener onFinishListener){
        getOpe().getBaseNetOpe().getbylbyadvid(getOpe().getBaseDAOpe().getAreaMessionResBean().getTitles().get(0).get医嘱ID(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                getOpe().getBaseDAOpe().setGetBylResBean(GsonUtil.getInstance().fromJson(o.toString(), GetBylResBean.class));
                getOpe().getBaseNurseUIOpe().setleftBuyeLiang(getOpe().getBaseDAOpe().getGetBylResBean().getData().getResult());
                onFinishListener.onFinish(null);
            }
        });
    }

    public void wirteData(){

        getOpe().getBaseNetOpe().write_addwater_data(getOpe().getBaseDAOpe().getAreaMessionResBean().getTitles().get(0).getId(),
                getOpe().getBaseDAOpe().getAreaMessionResBean().getTitles().get(0).get医嘱ID(),
                getOpe().getBaseDAOpe().getAreaMessionResBean().getRegionId(),
                getOpe().getBaseDAOpe().getAreaMessionResBean().getZyh(),
                getOpe().getBaseDAOpe().getAddAddWaterResBean().getData().get(0).getData(),
                new DelayUINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity,new String[]{"稍后是否还需要新增补液卡记录","是","否","取消"});
                        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TextView textView = (TextView) v;
                                switch (textView.getText().toString()){
                                    case "是":

                                        break;
                                    case "否":

                                        break;
                                    case "取消":

                                        break;
                                }
                                SheetDialogUtil.getInstance().dismess();
                            }
                        });
                    }
                });
    }

    @OnClick({R.id.tv_start, BaseID.ID_RIGHT})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_start:
                getOpe().getBaseDAOpe().numPlus();
                if(getOpe().getBaseDAOpe().getNum()==0){
                    getOpe().getBaseNurseUIOpe().getStartTV().setText("已开始");
                }else{
                    getOpe().getBaseNurseUIOpe().getStartTV().setText("第"+StringUtil.getStr(getOpe().getBaseDAOpe().getNum())+"滴");
                }

                if(getOpe().getBaseDAOpe().getNum()==10){
                    getOpe().getBaseNurseUIOpe().setDishu(StringUtil.getStr(getOpe().getBaseDAOpe().getDisu()));
                    getOpe().getBaseNurseUIOpe().getStartTV().setText(StringUtil.getStr(getOpe().getBaseDAOpe().getTime()[1]-getOpe().getBaseDAOpe().getTime()[0]));
                }
                break;
            case BaseID.ID_RIGHT:
                wirteData();
                break;
        }
    }

    @Override
    public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
        getData(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                materialRefreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addaddwater;
    }

    @Override
    public BaseNurseOpes<AddAddWaterUIOpe, NurseNetOpe, BaseDBOpe, AddAddWaterDAOpe> getOpe() {
        if(baseNurseOpes ==null){
            baseNurseOpes = new BaseNurseOpes(new AddAddWaterUIOpe(activity,getView()),new NurseNetOpe(activity),null,new AddAddWaterDAOpe(activity));
        }
        return baseNurseOpes;
    }
}
