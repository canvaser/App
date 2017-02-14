package com.siweisoft.nurse.ui.info.duteschedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.info.duteschedule.bean.resbean.DuteScheDuleListResBean;
import com.siweisoft.nurse.ui.info.duteschedule.ope.DuteScheDuleUIOpe;
import com.siweisoft.nurse.ui.info.duteschedule.ope.DuteScheduleNetOpe;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.data.DateFormatUtil;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleFrag extends BaseNurseFrag{


    DuteScheduleNetOpe duteScheduleNetOpe;


    DuteScheDuleUIOpe duteScheDuleUIOpe;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        duteScheduleNetOpe= new DuteScheduleNetOpe(activity);
        duteScheDuleUIOpe= new DuteScheDuleUIOpe(activity,getView());
        getData();
    }

    public void getData(){
        BaseNurseReqBean baseReqBean  = new BaseNurseReqBean();
        baseReqBean.setBegin(DateFormatUtil.getnowTimeYYYYMMdd());
        duteScheduleNetOpe.getWorkShifts(baseReqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    DuteScheDuleListResBean duteScheDuleListResBean = GsonUtil.getInstance().fromJson(o.toString(),DuteScheDuleListResBean.class);
                    duteScheDuleUIOpe.initList(duteScheDuleListResBean.getData());
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_duteschedule;
    }
}
