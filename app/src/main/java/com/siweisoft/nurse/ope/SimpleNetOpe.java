package com.siweisoft.nurse.ope;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.bean.req.BaseReqBean;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterDataReqBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterReqBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.GetBylReqBean;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterReqBean;
import com.siweisoft.nurse.ui.bed.persontask.bean.reqbean.GetPatientTaskOfTodayReqBean;
import com.siweisoft.nurse.ui.bed.persontask.bean.reqbean.GetPatientTaskReqBean;
import com.siweisoft.nurse.ui.bed.additionlist.bean.reqbean.UpdateAdditionReqBean;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.JsonDataListReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.RecordDataReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateDataResBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateResBean;
import com.siweisoft.nurse.ui.bed.datachart.bean.reqbean.DataChartReqBean;
import com.siweisoft.nurse.ui.bed.inputdata.bean.reqbean.InputDataListReqBean;
import com.siweisoft.nurse.ui.bed.inputdata.bean.reqbean.InputDataReqBean;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.bean.reqbean.InputHORReqBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.bean.reqbean.NurseRecordReqBean;
import com.siweisoft.nurse.ui.bed.patient.bean.reqbean.PatientAdditionReqBean;
import com.siweisoft.nurse.ui.check.checklist.bean.reqbean.UpdateCheckListReqBean;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentDetailReqBean;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListReqBean;
import com.siweisoft.nurse.ui.home.bean.reqbean.UpdateCallingLogsReqBean;
import com.siweisoft.nurse.ui.home.bean.reqbean.WriteAlarmReqBean;
import com.siweisoft.nurse.ui.info.addcheckbook.bean.reqbean.AddCheckBookListReqBean;
import com.siweisoft.nurse.ui.info.bedcheck.bean.reqbean.WriteBedCheckReqBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.reqbean.CheckBookDetailReqBean;
import com.siweisoft.nurse.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.req.MyWardTaskTodayReqBean;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.nurse.ui.setting.updatepwd.bean.reqbean.UpdatePwdReqBean;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginReqBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserNetBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-24.
 */

public class SimpleNetOpe extends BaseNetOpe {

    private SimpleNetOpe(Context context) {
        super(context);
    }

    public static void document_documemtList(Context context, String id, OnNetWorkReqInterf reqInterf) {
        DocumentListReqBean baseReqBean = new DocumentListReqBean();
        baseReqBean.setPid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_FORM, baseReqBean, reqInterf);
    }

    public static void document_documemtdetail(Context context, String id, OnNetWorkReqInterf reqInterf) {
        DocumentDetailReqBean baseReqBean = new DocumentDetailReqBean();
        baseReqBean.setFid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_DETAIL, baseReqBean, reqInterf);
    }

    //补液卡列表
    public static void addwater_list(Context context, String zyh, String fileid, String begin, String end, OnNetWorkReqInterf reqInterf) {
        AddWaterReqBean baseReqBean = new AddWaterReqBean();
        baseReqBean.setZyh(zyh);
        baseReqBean.setFileid(fileid);
        baseReqBean.setBegin(begin);
        baseReqBean.setEnd(end);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_FILE_DATA_BY_PATIENT, baseReqBean, reqInterf);
    }

    /**
     * 获取指定医嘱的用药量
     */
    public static void getbylbyadvid(Context context, String id, OnNetWorkReqInterf reqInterf) {
        GetBylReqBean baseReqBean = new GetBylReqBean();
        baseReqBean.setAdvID(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_BYL_BY_ADVID, baseReqBean, reqInterf);
    }

    /**
     * 提交补液卡数据
     */
    public static void write_addwater_data(Context context, String id, String yizhuid, String regionId, String zyh, List<AddAddWaterResBean.DataBeanX.DataBean> data, OnNetWorkReqInterf reqInterf) {
        AddAddWaterDataReqBean reqBean = new AddAddWaterDataReqBean();
        reqBean.setPid("0");
        reqBean.setPname("");
        reqBean.setFileid("71");
        reqBean.setFilename("补液卡");
        reqBean.setTaskid(id);
        reqBean.setAdvid(yizhuid);
        reqBean.setType("byk");
        reqBean.setWardid(regionId);

        List<AddAddWaterReqBean> d = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            AddAddWaterReqBean a = new AddAddWaterReqBean();
            a.setCoeff(data.get(i).getCoeff());
            a.setFileid(data.get(i).getFileid());
            a.setFilename(data.get(i).getFilename());
            a.setInitstring(data.get(i).getInitstring());
            a.setItems("");
            a.setItemvalues(data.get(i).getItemvalues());
            a.setLower(data.get(i).getLower());
            a.setNid(data.get(i).getNid());
            a.setParenttermid(data.get(i).getParenttermid());
            a.setPrefix(data.get(i).getPrefix());
            a.setSuffix(data.get(i).getSuffix());
            a.setTermid(data.get(i).getTermid());
            a.setTermname(data.get(i).getTermname());
            a.setTextalign(data.get(i).getTextalign());
            a.setType(data.get(i).getType());
            a.setUpper(data.get(i).getUpper());
            a.setValidrange(data.get(i).getValidrange());
            a.setValue(data.get(i).getValue());
            a.setValuetype(data.get(i).getValuetype());
            a.setZyh(zyh);
            a.setWardid(regionId);
            a.setTimestamp(StringUtil.getStr(System.currentTimeMillis() / 1000l));
            d.add(a);
        }

        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).getTermname().equals("时间")) {
                data.remove(i);
            }
            d.get(i).setValue(d.get(i).getValue().replace(d.get(i).getSuffix(), ""));
            //data.get(i).setItems(null);
        }
        reqBean.setJson_data(JSONArray.toJSONString(d));
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WIITE_ADDWATER_DATA, reqBean, reqInterf);
    }


    /**
     * 获取病区病人
     */
    public static void updateMyPatientList(Context context, MyPaitentUpdateListReqBean myPaitentUpdateListReqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_Y_PATIENT_LIST, myPaitentUpdateListReqBean, reqInterf);
    }

    ///**获取病区病人*/
    public static void writePatientAdditionData(Context context, UpdateAdditionReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_PATIENT_ADDITION, reqBean, reqInterf);
    }

    /**
     * 获取护理记录统计
     */
    public static void getTaskSummaryByPatient(Context context, String zyh, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_SUMMARY_BY_PAITENT, baseNurseReqBean, reqInterf);
    }

    /**
     * 获取病人医嘱数据
     */
    public static void getPatientAdviceData(Context context, String zyh, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_ADVICE, reqBean, reqInterf);
    }

    /**
     * 获取化验报告数据
     */
    public static void getAssayDataList(Context context, String zyh, String begin, OnNetWorkReqInterf reqInterf) {
        Date date = null;
        Calendar beginCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        String end = null;
        try {
            date = DateFormatUtil.convent_yyyyMMdd(begin);
            beginCalendar.setTime(date);
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, beginCalendar.get(Calendar.DAY_OF_MONTH) + 1);
            end = DateFormatUtil.convent_yyyyMMdd(endCalendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setPatientid(zyh);
        baseNurseReqBean.setBegin(begin);
        baseNurseReqBean.setEnd(end);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_LIST_RESULT_PATIENT, baseNurseReqBean, reqInterf);
    }

    /**
     * 获取我的病人列表
     */
    public static void getMyPatientList(Context context, OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MYPATIENT_LIST2, baseReqBean, reqInterf);
    }


    public static void getAdditionList(Context context, OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GETADDITION_LIST, baseReqBean, reqInterf);
    }

    /**
     * 获取病区病人l列表
     */
    public static void getRegion(Context context, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean baseReqBean = new BaseNurseReqBean();
        baseReqBean.setRid(MethodValue.getUserInfo(context).getData().getUser().getRegions().get(0));
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_LIST_IN_AREA, baseReqBean, reqInterf);
    }

    public static void getMyPatientList(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_LIST_RESULT_PATIENT, reqBean, reqInterf);
    }


    public static void getMultipleRecordData(Context context, String begin, String end, String zyh, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setBegin(begin);
        reqBean.setEnd(end);
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MULTIPLE_RECORD_DATA, reqBean, reqInterf);
    }

    public static void getRecordTemplate(Context context, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_TEMPLETE, new BaseReqBean(), reqInterf);
    }

    public static void getRecordData(Context context, RecordDataReqBean req, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_DATA, req, reqInterf);
    }


    public static void updateRecordData(Context context, JsonDataListReqBean req, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_RECORD_DATA, req, reqInterf);
    }

    public static void getRecordDetailData(Context context, DataChartReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_DATA, reqBean, reqInterf);
    }

    public static void getPatientReportData(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_REPORT, reqBean, reqInterf);
    }

    public static void writeRecordData(Context context, ArrayList<DataTemplateResBean> list, String zyh, String wardid, OnNetWorkReqInterf reqInterf) {
        ArrayList<InputDataReqBean> inputDataReqBeen = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<DataTemplateDataResBean> ll = list.get(i).getData();
            for (int j = 0; j < ll.size(); j++) {
                if (ll.get(j).getValue() != null && !ll.get(j).getValue().equals("")) {
                    InputDataReqBean reqBean = new InputDataReqBean();
                    reqBean.setValue(ll.get(j).getValue());
                    reqBean.setZyh(zyh);
                    reqBean.setCoeff(ll.get(j).getCoeff());
                    reqBean.setGroupid(ll.get(j).getGroupid());
                    reqBean.setGroupname(ll.get(j).getGroupname());
                    reqBean.setSignid(ll.get(j).getSignid());
                    reqBean.setSignname(ll.get(j).getSignname());
                    reqBean.setTimestamp(DateFormatUtil.getnowTimeYYYYMMdd());
                    reqBean.setWardid(wardid);
                    inputDataReqBeen.add(reqBean);
                }
            }
        }
        InputDataListReqBean inputDataListReqBean = new InputDataListReqBean();
        inputDataListReqBean.setJson_data(GsonUtil.getInstance().toJson(inputDataReqBeen));
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_RECORD_DATA, inputDataListReqBean, reqInterf);
    }

    public static void writeRecordData(Context context, DataTemplateResBean data, String zyh, String wardid, OnNetWorkReqInterf reqInterf) {
        ArrayList<InputDataReqBean> inputDataReqBeen = new ArrayList<>();
        ArrayList<DataTemplateDataResBean> ll = data.getData();
        boolean update = false;
        for (int i = 0; i < ll.size(); i++) {
            if (!ll.get(i).getValue().equals("")) {
                update = true;
                break;
            }
        }
        for (int j = 0; j < ll.size(); j++) {
            if (ll.get(j).getValue() != null && !ll.get(j).getValue().equals("")) {
                InputDataReqBean reqBean = new InputDataReqBean();
                reqBean.setValue(ll.get(j).getValue());
                reqBean.setZyh(zyh);
                reqBean.setCoeff(ll.get(j).getCoeff());
                reqBean.setGroupid(ll.get(j).getGroupid());
                reqBean.setGroupname(ll.get(j).getGroupname());
                reqBean.setSignid(ll.get(j).getSignid());
                reqBean.setSignname(ll.get(j).getSignname());
                reqBean.setTimestamp(DateFormatUtil.getnowTimeYYYYMMdd());
                reqBean.setWardid(wardid);
                inputDataReqBeen.add(reqBean);
            }
        }
        InputDataListReqBean inputDataListReqBean = new InputDataListReqBean();
        inputDataListReqBean.setGroupid(data.getGroupid());
        inputDataListReqBean.setJson_data(JSONArray.toJSONString(inputDataReqBeen));
        if (update) {
            NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_RECORD_DATA, inputDataListReqBean, reqInterf);
        } else {
            NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_RECORD_DATA, inputDataListReqBean, reqInterf);
        }

    }

    public static void writePatientReportData(Context context, InputHORReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_PATIENT_REPORT, reqBean, reqInterf);
    }

    public static void getPatientTask(Context context, String zyh, OnNetWorkReqInterf reqInterf) {
        GetPatientTaskReqBean reqBean = new GetPatientTaskReqBean();
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_TASK, reqBean, reqInterf);
    }


    public static void GetPatientTaskOfToday(Context context, GetPatientTaskOfTodayReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_TASK_TODAY, reqBean, reqInterf);
    }

    public static void getTaskSummaryByPatient(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_SUMMARY_BY_PAITENT, reqBean, reqInterf);
    }

    public static void getTaskDetailByCondition(Context context, NurseRecordReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_TASK_DETAIL_BY_CONDITION, reqBean, reqInterf);
    }

    public static void getPatientAdditionData(Context context, PatientBedResBean resBean, OnNetWorkReqInterf reqInterf) {

        PatientAdditionReqBean patientAdditionReqBean = new PatientAdditionReqBean();
        patientAdditionReqBean.setZyh(resBean.get住院号());
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_ADDITION, patientAdditionReqBean, reqInterf);
    }

    public static void getlistResultPatient(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_LIST_RESULT_PATIENT, reqBean, reqInterf);
    }

    public static void getCheckTasks(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_CHECK_TASK, reqBean, reqInterf);
    }


    public static void updateCheckStatus(Context context, UpdateCheckListReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_CHECK_TASK, reqBean, reqInterf);
    }


    public static void writeAlarmLogs(Context context, WriteAlarmReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_ALARM_LOG, reqBean, reqInterf);
    }


    public static void keepAlive(Context context, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_KEEP_ALIVE, new BaseReqBean(), reqInterf);
    }

    public static void writeInventoryCount(Context context, AddCheckBookListReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_INVENTORY_COUNT, reqBean, reqInterf);
    }

    public static void getHospitalAnnounceMent(Context context, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_HOSPITAL_ANNOUNCEMENT, new BaseReqBean(), reqInterf);
    }

    public static void getWardInspectionList(Context context, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WARD_INSPECTION_LIST, new BaseReqBean(), reqInterf);
    }


    public static void writeWardInspectionInfo(Context context, WriteBedCheckReqBean req, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_WARD_INSPECTION_INFO, req, reqInterf);
    }


    public static void getDailyBedReportByRegion(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DAILYBED_REPORT_BY_REGION, reqBean, reqInterf);
    }

    public static void getInstrumentFileItem(Context context, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_CHECK_BOOK_DATA, new BaseReqBean(), reqInterf);
    }

    public static void getInstrumentCountData(Context context, CheckBookDetailReqBean checkBookDetailReqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_BOOK_DETAIL_DATA, checkBookDetailReqBean, reqInterf);
    }

    public static void getWorkShifts(Context context, BaseNurseReqBean baseReqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WORK_SHIFTS, baseReqBean, reqInterf);
    }


    public static void getReportData(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_REPORT_DATA, reqBean, reqInterf);
    }

    public static void getAlarmLogs(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_ALARM_LOGS, reqBean, reqInterf);
    }


    public static void getWorkloadByUser(Context context, BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WORK_LOAD_BY_USER, reqBean, reqInterf);
    }

    public static void updateTask(Context context, MissisonDetailReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_TASK, reqBean, reqInterf);
    }


    public static void getMyWardTaskOfToday(Context context, OnNetWorkReqInterf reqInterf) {

        MyWardTaskTodayReqBean myWardTaskTodayReqBean = new MyWardTaskTodayReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_AREA_TASK_TODAY, myWardTaskTodayReqBean, reqInterf);
    }

    public static void getMyPatientTaskOfToday(Context context, OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_PATIENT_TASK_TODAY, baseReqBean, reqInterf);
    }

    public static void getMyWardTaskOfHistory(Context context, OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_AREA_TASK_HISTORY_NOT_FINISHED, baseReqBean, reqInterf);
    }

    public static void getMyPatientTaskOfHistory(Context context, OnNetWorkReqInterf reqInterf) {
        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_PATIENT_TASK_HISTORY, baseReqBean, reqInterf);
    }

    public static void getMissionData(Context context, String type, OnNetWorkReqInterf reqInterf) {
        switch (type) {
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_AREA:
                getMyWardTaskOfToday(context, reqInterf);
                break;
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                getMyPatientTaskOfToday(context, reqInterf);
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_AREA:
                getMyWardTaskOfHistory(context, reqInterf);
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                getMyPatientTaskOfHistory(context, reqInterf);
                break;
        }
    }

    public static void changePassword(Context context, UpdatePwdReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_CHANGE_PWD, reqBean, reqInterf);
    }

    public static void onGetallregionbyuser(Context context, String account, OnNetWorkReqInterf reqInterf) {

        GetallregionbyuserNetBean getallregionbyuserNetBean = new GetallregionbyuserNetBean();
        getallregionbyuserNetBean.setUid(account);
        NetWork.getInstance(context).doHttpRequset(context, DataValue.URL_GETALLREGIONBYUSER, getallregionbyuserNetBean, reqInterf);
    }

    public static void onLogin(Context context, String account, String pwd, OnNetWorkReqInterf reqInterf) {

        DoLoginReqBean doLoginReqBean = new DoLoginReqBean();
        doLoginReqBean.setDeviceid(ValueConstant.UUUID);
        doLoginReqBean.setPassword(pwd);
        doLoginReqBean.setUsername(account);
        NetWork.getInstance(context).dologin(context, DataValue.URL_DOLOGIN, doLoginReqBean, reqInterf);
    }

    public static void onDologout(Context context, OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_DOLOGIN_OUT, baseReqBean, reqInterf);
    }

    public static void writeWardInspectionInfo(Context context, String zyh, String region, String room, String bed, OnNetWorkReqInterf reqInterf) {

        WriteBedCheckReqBean reqBean = new WriteBedCheckReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_WARD_INSPECTION_INFO, reqBean, reqInterf);
    }


    public static void getCallingLogs(Context context, OnNetWorkReqInterf reqInterf) {
        BaseReqBean reqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_CALLING_LOGS, reqBean, reqInterf);
    }

    public static void updateCallingLogs(Context context, String id, OnNetWorkReqInterf reqInterf) {
        UpdateCallingLogsReqBean reqBean = new UpdateCallingLogsReqBean();
        reqBean.setId(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_CALLING_LOGS, reqBean, reqInterf);
    }


}
