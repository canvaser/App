package com.siweisoft.nurse.ui.home.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.joybar.librarycalendar.utils.DateUtils;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.home.ope.HomeUIOpe;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.data.DateFormatUtil;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class HomeFrag extends BaseNurseFrag<HomeUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onStart() {
        super.onStart();
        View imageView = (ImageView) getView().findViewById(R.id.iv_info);
        imageView.setAlpha(1);
    }

    @Override
    public int getContainView() {
        return R.layout.index_home;
    }

    @Override
    public BaseNurseOpes<HomeUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new HomeUIOpe(activity, getView()), null, null, null);
        }
        return baseNurseOpes;
    }
}
