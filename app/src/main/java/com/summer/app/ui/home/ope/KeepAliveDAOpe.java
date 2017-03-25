package com.summer.app.ui.home.ope;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.home.bean.resbean.GetCallingLogsResBean;
import com.summer.lib.base.ui.activity.BaseActivity;
import com.summer.lib.bean.reqbean.BaseNurseReqBean;
import com.summer.lib.base.ui.ope.BaseDAOpe;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.LogUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.dialog.DialogUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.app.ui.bed.bedlist.fragment.BedListFGM;
import com.summer.app.ui.info.urgencyreport.bean.resbean.UrgencyReportListResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class KeepAliveDAOpe extends BaseDAOpe {

    //无新数据
    public static final int NO_NEW_DATA = 1;
    //有新床位呼叫
    public static final int HAVE_NEW_BED_CALL = 3;
    //有新紧急报告
    public static final int HAVE_NEW_REPORT_CALL = 5;
    //有新床位呼叫和新紧急报告
    public static final int HAVE_NEW_BED_REPORT_CALL = 7;


    public ArrayList<String> strdata = new ArrayList<>();

    public KeepAliveDAOpe(Context context) {
        super(context);
    }

    public void analysisData(Context context, final int data) {
        switch (data) {
            case NO_NEW_DATA:
                break;
            case HAVE_NEW_BED_CALL:
                SimpleNetOpe.getCallingLogs(context, new OnNetWorkReqAdapter(context) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        LogUtil.E(o.toString());
                        if (success) {

                            final GetCallingLogsResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), GetCallingLogsResBean.class);
//                            final GetCallingLogsResBean resBean = new GetCallingLogsResBean();
//                            resBean.setData(new ArrayList<GetCallingLogsResBean.DataBean>());
//                            resBean.getData().add(new GetCallingLogsResBean.DataBean());
//                            resBean.getData().get(0).setId("111");
//                            resBean.getData().get(0).setName("唐杰");
//                            resBean.getData().get(0).setBedid("12345");
//                            resBean.getData().get(0).setZyh("929443");
                            View view = LayoutInflater.from(context).inflate(R.layout.dialog_calling, null);
                            TextView textView = (TextView) view.findViewById(R.id.tv_msg);
                            textView.setText(StringUtil.getStr(resBean.getData() == null ? "" : resBean.getData().get(0) == null ? "" : resBean.getData().get(0).getBedid()) + "床位" +
                                    StringUtil.getStr(resBean.getData() == null ? "" : resBean.getData().get(0) == null ? "" : resBean.getData().get(0).getName()) + "正在呼叫");
                            if (DialogUtil.getInstance().getDialog(resBean.getData().get(0).getBedid()) != null) {
                                return;
                            }
                            DialogUtil.getInstance().showDialogWithTag(context, resBean.getData().get(0).getBedid(), view, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    switch (v.getId()) {
                                        case R.id.ok:
                                            Bundle bundle = new Bundle();
                                            bundle.putString(ValueConstant.DATA_POSITION, resBean.getData().get(0).getZyh());
                                            bundle.putString(ValueConstant.FARG_TYPE, ValueConstant.FARG_TYPE_CMD);
                                            DialogUtil.getInstance().dismiss();
                                            FragManager.getInstance().startFragment(((BaseActivity) context).getSupportFragmentManager(), 0, new BedListFGM(), bundle);
                                            break;
                                        case R.id.cancle:
                                            DialogUtil.getInstance().dismiss();
                                            break;
                                    }
                                    SimpleNetOpe.updateCallingLogs(context, resBean.getData().get(0).getId(), new OnNetWorkReqAdapter(context) {
                                        @Override
                                        public void onNetWorkResult(boolean success, Object o) {

                                        }
                                    });
                                }
                            }, R.id.ok, R.id.cancle);
                        }
                    }
                });
                break;
            case HAVE_NEW_REPORT_CALL:
                SimpleNetOpe.getAlarmLogs(context, new BaseNurseReqBean(), new OnNetWorkReqAdapter(context) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {

                            final UrgencyReportListResBean urgencyReportListResBean = GsonUtil.getInstance().fromJson(o.toString(), UrgencyReportListResBean.class);
                            View view = LayoutInflater.from(context).inflate(R.layout.dialog_calling, null);
                            TextView textView = (TextView) view.findViewById(R.id.tv_msg);
                            textView.setText(urgencyReportListResBean.getData().get(0).getPatname() + " ： " + urgencyReportListResBean.getData().get(0).getContent());
                            String s = urgencyReportListResBean.getData().get(0).getPatname() + urgencyReportListResBean.getData().get(0).getContent() + urgencyReportListResBean.getData().get(0).getCreate_time();
                            for (int i = 0; i < strdata.size(); i++) {
                                if (strdata.get(i).equals(s)) {
                                    return;
                                }
                            }
                            strdata.add(s);
                            DialogUtil.getInstance().showDialogWithTag(context, s, view, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    switch (v.getId()) {
                                        case R.id.ok:
                                            Bundle bundle = new Bundle();
                                            bundle.putString(ValueConstant.DATA_POSITION, urgencyReportListResBean.getData().get(0).getZyh());
                                            bundle.putString(ValueConstant.FARG_TYPE, ValueConstant.FARG_TYPE_CMD);
                                            DialogUtil.getInstance().dismiss();
                                            FragManager.getInstance().startFragment(((BaseActivity) context).getSupportFragmentManager(), 0, new BedListFGM(), bundle);
                                            break;
                                        case R.id.cancle:
                                            DialogUtil.getInstance().dismiss();
                                            break;
                                    }
//                                    WriteAlarmReqBean reqBean = new WriteAlarmReqBean();
//                                    reqBean.setZyh(urgencyReportListResBean.getData().get(0).getZyh());
//                                    reqBean.setContent(urgencyReportListResBean.getData().get(0).getContent());
//                                    switch (urgencyReportListResBean.getData().get(0).getUpdate_value()) {
//                                        case "0":
//                                            reqBean.setUpdate_value("1");
//                                            break;
//                                        default:
//                                            reqBean.setUpdate_value("0");
//                                            break;
//                                    }
//                                    reqBean.setLevel("1");
//                                    reqBean.setMode("update");
//                                    reqBean.setLogid(urgencyReportListResBean.getData().get(0).getId());
//                                    reqBean.setPatname(urgencyReportListResBean.getData().get(0).getPatname());
//                                    SimpleNetOpe.writeAlarmLogs(context,reqBean, new OnNetWorkReqAdapter(context) {
//                                        @Override
//                                        public void onNetWorkResult(boolean success, Object o) {
//                                            if (success) {
//
//                                            }
//                                        }
//                                    });
                                }
                            }, R.id.ok, R.id.cancle);
                        }
                    }
                });
                break;
            case HAVE_NEW_BED_REPORT_CALL:
                break;

        }
    }

}
