package com.siweisoft.nurse.ui.calendar.fragment;

import android.os.Bundle;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.OnProgressInterf;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.calendar.ope.daope.AddDayRecordDAOpe;
import com.siweisoft.nurse.ui.calendar.ope.netope.CalendarNetOpe;
import com.siweisoft.nurse.ui.calendar.ope.uiope.AddDayRecordUIOpe;
import com.siweisoft.nurse.ui.image.bean.dabean.PicBean;
import com.siweisoft.nurse.ui.image.fragment.ImagesFrag;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.LoadUtil;
import com.siweisoft.util.LogUtil;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-01-24.
 */

public class AddDayRecordFrag extends BaseNurseFrag<AddDayRecordUIOpe, CalendarNetOpe, BaseDBOpe, AddDayRecordDAOpe> {


    @Override
    public BaseNurseOpes<AddDayRecordUIOpe, CalendarNetOpe, BaseDBOpe, AddDayRecordDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AddDayRecordUIOpe(activity, getView()), new CalendarNetOpe(activity), null, new AddDayRecordDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public void onBackClick(View v) {

    }

    @OnClick({BaseID.ID_RIGHT, BaseID.ID_BACK})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                LogUtil.E(System.currentTimeMillis());
                if (!getOpe().getBaseNurseUIOpe().isFit()) {
                    return;
                }
                //LoadUtil.getInstance().onStartLoading(activity,AddDayRecordFrag.class.getName());
                getOpe().getBaseNurseUIOpe().getMidTV().setText("上传中...");
                if (getOpe().getBaseDAOpe().getPicBeen() == null || getOpe().getBaseDAOpe().getPicBeen().size() == 0) {
                    getOpe().getBaseNetOpe().addRecordtext(getOpe().getBaseNurseUIOpe().getAddET().getText().toString(), new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            LogUtil.E(System.currentTimeMillis());
                            DayRecordFrag dayRecordFrag = (DayRecordFrag) FragManager.getInstance().getFragMaps().get(3).get(0);
                            getOpe().getBaseNurseUIOpe().getAddET().setText("");
                            getOpe().getBaseDAOpe().setUrl(null);
                            getOpe().getBaseNurseUIOpe().initList(null);
                            dayRecordFrag.getOpe().getBaseNurseUIOpe().getViewPager().setCurrentItem(1);
                            //LoadUtil.getInstance().onStopLoading(AddDayRecordFrag.class.getName());
                            getOpe().getBaseNurseUIOpe().getMidTV().setText("上传完成");
                        }
                    });
                    return;
                }
                getOpe().getBaseNetOpe().i = 0;
                getOpe().getBaseNetOpe().addRecord(getOpe().getBaseNurseUIOpe().getAddET().getText().toString(), getOpe().getBaseDAOpe().getPicBeen(), new OnProgressInterf() {
                    @Override
                    public void onStart(Object o) {
                        getOpe().getBaseNurseUIOpe().getMidTV().setText("上传中");
                    }

                    @Override
                    public void onProgess(Object o) {
                        getOpe().getBaseNurseUIOpe().getMidTV().setText("上传中" + o);
                    }

                    @Override
                    public void onEnd(Object o) {
                        LogUtil.E(System.currentTimeMillis());
                        DayRecordFrag dayRecordFrag = (DayRecordFrag) FragManager.getInstance().getFragMaps().get(3).get(0);
                        getOpe().getBaseNurseUIOpe().getAddET().setText("");
                        getOpe().getBaseDAOpe().setUrl(null);
                        getOpe().getBaseNurseUIOpe().initList(null);
                        dayRecordFrag.getOpe().getBaseNurseUIOpe().getViewPager().setCurrentItem(1);
                        //LoadUtil.getInstance().onStopLoading(AddDayRecordFrag.class.getName());
                        getOpe().getBaseNurseUIOpe().getMidTV().setText("上传完成");
                    }
                });
                break;
            case BaseID.ID_BACK:
                FragManager.getInstance().startFragmentForResult(activity.getSupportFragmentManager(), index, new ImagesFrag(), new Bundle(), ValueConstant.CODE_REQUSET);
                LogUtil.E(index);
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        if (bundle.getSerializable(ValueConstant.DATA_DATA) == null && !(bundle.getSerializable(ValueConstant.DATA_DATA) instanceof ArrayList)) {
            return;
        }
        ArrayList<PicBean> picBeen = (ArrayList<PicBean>) bundle.getSerializable(ValueConstant.DATA_DATA);
        getOpe().getBaseDAOpe().setPicBeen(picBeen);
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getPicBeen());
    }


    @Override
    public int getContainView() {
        return R.layout.frag_addrecord;
    }
}
