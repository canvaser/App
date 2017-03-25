package com.summer.app.ui.info.duteschedule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.info.duteschedule.bean.resbean.DuteScheDuleListResBean;
import com.summer.app.ui.info.duteschedule.ope.DuteScheDuleUIOpe;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.lib.bean.reqbean.BaseNurseReqBean;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;

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
        SimpleNetOpe.getWorkShifts(activity, baseReqBean, new UINetAdapter(activity) {
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
