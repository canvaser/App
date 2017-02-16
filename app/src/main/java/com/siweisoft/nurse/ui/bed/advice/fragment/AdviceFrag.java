package com.siweisoft.nurse.ui.bed.advice.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.DatePickUitl;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.MyMission.bean.uibean.MyMissionHeadUIBean;
import com.siweisoft.nurse.ui.bed.advice.bean.resbean.AdviceListResBean;
import com.siweisoft.nurse.ui.bed.advice.ope.AdviceUIOpe;
import com.siweisoft.nurse.ui.bed.advice.ope.GetPatientAdviceNetOpe;
import com.siweisoft.nurse.ui.bed.advice.ope.TimeSortOpe;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.util.Calendar;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class AdviceFrag extends BaseNurseFrag implements
        ExpandableListView.OnChildClickListener,
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener {


    AdviceUIOpe adviceUIOpe;

    GetPatientAdviceNetOpe getPatientAdviceNetOpe;

    PatientBedResBean resBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
           return;
        }
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        adviceUIOpe = new AdviceUIOpe(activity,getView());
        getPatientAdviceNetOpe = new GetPatientAdviceNetOpe(activity);
        BaseNurseReqBean reqBean =new BaseNurseReqBean();
        reqBean.setZyh(resBean.get住院号());
        getPatientAdviceNetOpe.getPatientTask(reqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    AdviceListResBean adviceListResBean = GsonUtil.getInstance().fromJson(o.toString(),AdviceListResBean.class);
                    adviceUIOpe.initAdviceList( new TimeSortOpe().sortTime(adviceListResBean.getData()));
                }
            }
        });
        adviceUIOpe.getDoubleExpandView().setOnHeaderUpdateListener(this);
        adviceUIOpe.getDoubleExpandView().setOnChildClickListener(this);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_advice;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    @Override
    public View getPinnedHeader() {
        View headerView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.list_head_advice, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if( firstVisibleGroupPos<0 ||adviceUIOpe ==null || adviceUIOpe.getAdviceListAdapter()==null){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        MyMissionHeadUIBean myMissionHeadUIBean = new MyMissionHeadUIBean(activity,headerView);
        myMissionHeadUIBean.getTitleTV().setText(DataValue.STATUS_TYPE_TIME.get(firstVisibleGroupPos));
        myMissionHeadUIBean.getNumTV().setText(StringUtil.getStr(adviceUIOpe.getAdviceListAdapter().getChildrenCount(firstVisibleGroupPos)));
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {

    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                DatePickUitl.getInstance().showDatePickDialog(activity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //myMissionDAOpe.setDate(DateFormatUtil.getYYYYMMDD(year,month,dayOfMonth));
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(Calendar.YEAR,year);
                        calendar1.set(Calendar.MONTH,month);
                        calendar1.set(Calendar.DAY_OF_MONTH,dayOfMonth+1);
                        ///myMissonUIOpe.getRefreshLayout().autoRefresh();
                    }
                });
                break;
        }
    }
}
