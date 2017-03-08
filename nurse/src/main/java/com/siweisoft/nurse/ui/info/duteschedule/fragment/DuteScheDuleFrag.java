package com.siweisoft.nurse.ui.info.duteschedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.ui.info.duteschedule.bean.resbean.DuteScheDuleListResBean;
import com.siweisoft.nurse.ui.info.duteschedule.ope.DuteScheDuleUIOpe;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class DuteScheDuleFrag extends BaseNurseFrag {


    NurseNetOpe duteScheduleNetOpe;


    DuteScheDuleUIOpe duteScheDuleUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        duteScheduleNetOpe = new NurseNetOpe(activity);
        duteScheDuleUIOpe = new DuteScheDuleUIOpe(activity, getView());
        getData();
    }

    public void getData() {
        BaseNurseReqBean baseReqBean = new BaseNurseReqBean();
        baseReqBean.setBegin(DateFormatUtil.getnowTimeYYYYMMdd());
        duteScheduleNetOpe.getWorkShifts(baseReqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    DuteScheDuleListResBean duteScheDuleListResBean = GsonUtil.getInstance().fromJson(o.toString(), DuteScheDuleListResBean.class);
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
