package com.siweisoft.nurse.ui.mission.missiondetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.nurse.ui.mission.missiondetail.ope.MissionDetailNetOpe;
import com.siweisoft.nurse.ui.mission.missiondetail.ope.MissionDetailUIOpe;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.SPUtil;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MissionDetailFrag extends BaseNurseFrag implements OnAppItemClickListener{


    MissionDetailUIOpe missionDetailUIOpe;

    AreaMessionResBean resBean;

    MissionDetailNetOpe missionDetailNetOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        resBean = (AreaMessionResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        missionDetailUIOpe = new MissionDetailUIOpe(activity,getView());
        missionDetailNetOpe= new MissionDetailNetOpe(activity);
        missionDetailUIOpe.initData(resBean);
        missionDetailUIOpe.getMissionDetailListAdapter().setOnAppItemClickListener(this);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_missiondetail;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        String status = DataValue.STATUS_WEI_ZHI_XING;
        switch (view.getId()){
            case R.id.tv_txt:
                View menu = ((View)view.getParent()).findViewById(R.id.ll_menu);
                if(menu.getVisibility()==View.VISIBLE){
                    menu.setVisibility(View.GONE);
                }else{
                    menu.setVisibility(View.VISIBLE);
                }
                return;
            case R.id.ll_content:
                View mm = ((View)view.getParent()).findViewById(R.id.tv_press);
                if(mm.getVisibility()==View.VISIBLE){
                    mm.setVisibility(View.GONE);
                }else{
                    mm.setVisibility(View.VISIBLE);
                }
                return;
            case R.id.rl_done:
                status = DataValue.STATUS_YI_WAN_CHENG;
                break;
            case R.id.rl_absent:
                status = DataValue.STATUS_BING_REN_BU_ZAI;
                break;
            case R.id.rl_refuse:
                status = DataValue.STATUS_BING_REN_JU_JUE;
                break;
            case R.id.rl_delete:
                status = DataValue.SSTATUS_SHAN_CHU;
                break;
            case R.id.tv_press:
                status = DataValue.STATUS_WEI_ZHI_XING;
                break;
        }
        MissisonDetailReqBean reqBean = new MissisonDetailReqBean();
        GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.AREA_INFO), GetallregionbyuserResBean.Data.class);
        reqBean.setRegion(data.getWardcode());
        reqBean.setId(resBean.getTitles().get(position).getId());
        reqBean.setStatus(status);
        missionDetailNetOpe.updateTask(reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    FragManager.getInstance().finish(getFragmentManager(),index,null);

                }
            }
        });

    }
}
