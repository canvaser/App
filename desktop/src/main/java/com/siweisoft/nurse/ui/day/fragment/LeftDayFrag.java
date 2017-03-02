package com.siweisoft.nurse.ui.day.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.siweisoft.nurse.ui.day.adapter.LeftDayAdapter;
import com.siweisoft.nurse.ui.day.bean.dbbean.DayDBBean;
import com.siweisoft.nurse.ui.day.ope.dbope.DayAddDBOpe;
import com.siweisoft.nurse.ui.day.ope.uiope.LeftDayUIOpe;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.SheetDialogUtil;
import com.siweisoft.util.data.FormatUtil;
import com.siweisoft.util.media.VoiceUtil;
import com.siweisoft.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

import butterknife.OnLongClick;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class LeftDayFrag extends BaseNurseFragWithoutTitle<LeftDayUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> implements OnAppItemLongClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            setArguments(new Bundle());
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().getBefore(FormatUtil.getInstance().getNowHHMMTime()));
        ((LeftDayAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(this);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().getBefore(FormatUtil.getInstance().getNowHHMMTime()));
                materialRefreshLayout.finishRefresh();
                ((LeftDayAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(LeftDayFrag.this);
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_leftday;
    }

    @Override
    public BaseNurseOpes<LeftDayUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new LeftDayUIOpe(activity, getView()), null, new DayAddDBOpe(activity, new DayDBBean()), null);
        }
        return baseNurseOpes;
    }

    @Override
    public void onAppItemLongClick(View view, int position) {
        final DayDBBean dayDBBean = (DayDBBean) view.getTag(R.id.data);
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, new String[]{"删除"});
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                switch (textView.getText().toString()) {
                    case "删除":
                        getOpe().getBaseDBOpe().delete(dayDBBean.getId());
                        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().getBefore(FormatUtil.getInstance().getNowHHMMTime()));
                        ((LeftDayAdapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(LeftDayFrag.this);
                        break;
                }
                SheetDialogUtil.getInstance().dismess();
            }
        });

    }
}
