package com.siweisoft.nurse.ui.bed.data.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.DatePickUitl;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.ScreenUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.data.adapter.DataAdapter3;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.JsonDataListReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.JsonDataReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.BodyDataResBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.TitleDataListResBean;
import com.siweisoft.nurse.ui.bed.data.ope.DataDAOpe;
import com.siweisoft.nurse.ui.bed.data.ope.DataUIOpe;
import com.siweisoft.nurse.ui.bed.datachart.activity.DataChartActivity;
import com.siweisoft.nurse.ui.bed.inputdata.fragment.InputDataFrag;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.nurse.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class DataFrag extends BaseNurseFrag implements PinnedHeaderExpandableListView.OnHeaderUpdateListener, View.OnClickListener {


    DataUIOpe dataUIOpe;

    NurseNetOpe dataNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        //dataUIOpe = new DataUIOpe3(activity,getView());
        dataNetOpe = new NurseNetOpe(activity);
        dataUIOpe = new DataUIOpe(activity, getView());
        dataUIOpe.initTitle(patientAdditionDAOpe);
        ScreenUtil.getInstance().getStatusBarHeight(activity);
        getMultipleRecordData(DateFormatUtil.getnowTimeYYYYMMdd(), DateFormatUtil.getTomorromTimeYYYYMMdd());

    }

    public void getMultipleRecordData(String begin, String end) {
        dataNetOpe.getMultipleRecordData(begin, end, patientAdditionDAOpe.getPatientBedResBean().get住院号(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    TitleDataListResBean titleDataListResBean = GsonUtil.getInstance().fromJson(o.toString(), TitleDataListResBean.class);
                    dataUIOpe.init(new DataDAOpe(activity).getData(new DataDAOpe(activity).sort(titleDataListResBean.getData())));
                    dataUIOpe.init2();
                    dataUIOpe.getListView().setOnHeaderUpdateListener(DataFrag.this);
                    dataUIOpe.initLeftListener(DataFrag.this);
                    for (int i = 0; i < dataUIOpe.getRecyclerViews().size(); i++) {
                        DataAdapter3 dataAdapter3 = (DataAdapter3) dataUIOpe.getRecyclerViews().get(i).getAdapter();
                        dataAdapter3.setOnClickListener(DataFrag.this);
                    }
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_data4;
    }

    @Override
    public View getPinnedHeader() {
        View headerView = layoutInflater.inflate(R.layout.list_data_head, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if (firstVisibleGroupPos < 0 || dataUIOpe.getList() == null) {
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView textView = (TextView) headerView.findViewById(R.id.tv_txt);
        textView.setText(dataUIOpe.getList().get(firstVisibleGroupPos).getHead());
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        getMultipleRecordData(DateFormatUtil.getnowTimeYYYYMMdd(), DateFormatUtil.getTomorromTimeYYYYMMdd());
    }

    @OnClick({R.id.tv_date, BaseID.ID_RIGHT, BaseID.ID_MID})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, patientAdditionDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {

                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        dataUIOpe.initTitle(patientAdditionDAOpe);
                        getMultipleRecordData(DateFormatUtil.getnowTimeYYYYMMdd(), DateFormatUtil.getTomorromTimeYYYYMMdd());
                    }
                });
                break;
            case R.id.tv_date:
                DialogUtil.showTimePick(activity, getFragmentManager(), "date", Type.ALL, new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date(millseconds));
                        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
                        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
                        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.setTime(new Date(millseconds));
                        calendar1.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
                        calendar1.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
                        calendar1.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
                        dataUIOpe.getDateTV().setText(DateFormatUtil.convent_YYYYMMDD(new Date(millseconds)));
                        getMultipleRecordData(DateFormatUtil.convent_YYYYMMDD(calendar.getTime()), DateFormatUtil.convent_YYYYMMDD(calendar1.getTime()));
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, patientAdditionDAOpe.getPatientBedResBean());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new InputDataFrag(), bundle, ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getTag(R.id.type) != null && v.getTag(R.id.type).equals("left")) {
            int groupid = (int) v.getTag(R.id.groupposition);
            int childid = (int) v.getTag(R.id.childposition);
            TextView textView = (TextView) v.findViewById(R.id.tv_txt);
            LogUtil.E(textView.getText());
            Intent intent = new Intent(activity, DataChartActivity.class);
            intent.putExtra(ValueConstant.DATA_DATA2, patientAdditionDAOpe);
            intent.putExtra(ValueConstant.DATA_DATA, dataUIOpe.getList().get(groupid).getTitleData().get(childid));
            // FragManager.getInstance().startFragment(getFragmentManager(),index,new DataChartFrag());
            startActivity(intent);
        }


        if (!(v instanceof TextView) || v.getTag(R.id.position) == null) {
            return;
        }

        final BodyDataResBean dataResBean = (BodyDataResBean) v.getTag(R.id.position);


        switch (dataResBean.getSignname()) {
            case "录入时间":
            case "图章时间":
                break;
            default:

                final View view = LayoutInflater.from(activity).inflate(R.layout.dialog_inputdata, null);
                TextView titleTV = (TextView) view.findViewById(R.id.tv_title);
                titleTV.setText("修改\"" + dataResBean.getSignname() + "\"记录值,请准确核对");

                DialogUtil.getInstance().showDialog(activity, view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.ok:
                                EditText inputEt = (EditText) view.findViewById(R.id.et_input);
                                JsonDataReqBean reqBean = new JsonDataReqBean();
                                reqBean.set_id(dataResBean.get_id());
                                reqBean.setValue(inputEt.getText().toString());
                                DialogUtil.getInstance().dismiss();
                                JsonDataListReqBean r = new JsonDataListReqBean();
                                List<HashMap> list = new ArrayList<HashMap>();
                                HashMap<String, String> map = new HashMap<String, String>();
                                map.put("_id", dataResBean.get_id());
                                map.put("value", inputEt.getText().toString());
                                list.add(map);
                                r.setJson_data(list);
                                dataNetOpe.updateRecordData(r, new UINetAdapter(activity) {
                                    @Override
                                    public void onNetWorkResult(boolean success, Object o) {
                                        if (success) {

                                        }
                                    }
                                });
                                break;
                            case R.id.cancle:
                                LogUtil.E("cancle");
                                DialogUtil.getInstance().dismiss();
                                break;
                        }
                    }
                }, R.id.ok, R.id.cancle);
                break;
        }


//        if(!(v instanceof TextView)){
//            return;
//        }
//        TextView textView = (TextView) v;
//
//
//
//        switch (textView.getText().toString()){
//            default:
//                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new DataChartFrag(),ValueConstant.CODE_REQUSET);
//                break;
//        }
    }
}
