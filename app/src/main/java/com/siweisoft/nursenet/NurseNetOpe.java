package com.siweisoft.nursenet;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.bean.req.BaseReqBean;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.nursevalue.DataValue;
import com.siweisoft.nursevalue.MethodValue;
import com.siweisoft.ui.addwater.addaddwater.bean.netbean.AddAddWaterDataReqBean;
import com.siweisoft.ui.addwater.addaddwater.bean.netbean.AddAddWaterReqBean;
import com.siweisoft.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.ui.addwater.addaddwater.bean.netbean.GetBylReqBean;
import com.siweisoft.ui.addwater.addwater.bean.netbean.AddWaterReqBean;
import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.ui.bed.persontask.bean.reqbean.GetPatientTaskOfTodayReqBean;
import com.siweisoft.ui.bed.persontask.bean.reqbean.GetPatientTaskReqBean;
import com.siweisoft.ui.bed.additionlist.bean.reqbean.UpdateAdditionReqBean;
import com.siweisoft.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;
import com.siweisoft.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.ui.bed.data.bean.reqbean.JsonDataListReqBean;
import com.siweisoft.ui.bed.data.bean.reqbean.RecordDataReqBean;
import com.siweisoft.ui.bed.data.bean.resbean.DataTemplateDataResBean;
import com.siweisoft.ui.bed.data.bean.resbean.DataTemplateResBean;
import com.siweisoft.ui.bed.datachart.bean.reqbean.DataChartReqBean;
import com.siweisoft.ui.bed.inputdata.bean.reqbean.InputDataListReqBean;
import com.siweisoft.ui.bed.inputdata.bean.reqbean.InputDataReqBean;
import com.siweisoft.ui.bed.inputhandoverreport.bean.reqbean.InputHORReqBean;
import com.siweisoft.ui.bed.nurserecorddetail.bean.reqbean.NurseRecordReqBean;
import com.siweisoft.ui.bed.patient.bean.reqbean.PatientAdditionReqBean;
import com.siweisoft.ui.check.checklist.bean.reqbean.UpdateCheckListReqBean;
import com.siweisoft.ui.document.document.bean.netbean.DocumentDetailReqBean;
import com.siweisoft.ui.document.document.bean.netbean.DocumentListReqBean;
import com.siweisoft.ui.home.bean.reqbean.WriteAlarmReqBean;
import com.siweisoft.ui.info.addcheckbook.bean.reqbean.AddCheckBookListReqBean;
import com.siweisoft.ui.info.bedcheck.bean.reqbean.WriteBedCheckReqBean;
import com.siweisoft.ui.info.checkbookdetail.bean.reqbean.CheckBookDetailReqBean;
import com.siweisoft.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;
import com.siweisoft.ui.mission.missionlist.bean.req.MyWardTaskTodayReqBean;
import com.siweisoft.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.ui.setting.updatepwd.bean.reqbean.UpdatePwdReqBean;
import com.siweisoft.ui.user.login.bean.DoLoginReqBean;
import com.siweisoft.ui.user.login.bean.GetallregionbyuserNetBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class NurseNetOpe extends BaseNetOpe {


    public NurseNetOpe(Context context) {
        super(context);
    }

    public void document_documemtList(String id, OnNetWorkReqInterf reqInterf) {
        DocumentListReqBean baseReqBean = new DocumentListReqBean();
        baseReqBean.setPid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_FORM, baseReqBean, reqInterf);
    }

    public void document_documemtdetail(String id, OnNetWorkReqInterf reqInterf) {
        DocumentDetailReqBean baseReqBean = new DocumentDetailReqBean();
        baseReqBean.setFid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_DETAIL, baseReqBean, reqInterf);
    }

    //补液卡列表
    public void addwater_list(String zyh, String fileid, String begin, String end, OnNetWorkReqInterf reqInterf) {
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
    public void getbylbyadvid(String id, OnNetWorkReqInterf reqInterf) {
        GetBylReqBean baseReqBean = new GetBylReqBean();
        baseReqBean.setAdvID(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_BYL_BY_ADVID, baseReqBean, reqInterf);
    }

    /**
     * 提交补液卡数据
     */
    public void write_addwater_data(String id, String yizhuid, String regionId, String zyh, List<AddAddWaterResBean.DataBeanX.DataBean> data, OnNetWorkReqInterf reqInterf) {
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
    public void updateMyPatientList(MyPaitentUpdateListReqBean myPaitentUpdateListReqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_Y_PATIENT_LIST, myPaitentUpdateListReqBean, reqInterf);
    }

    ///**获取病区病人*/
    public void writePatientAdditionData(UpdateAdditionReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_PATIENT_ADDITION, reqBean, reqInterf);
    }

    /**
     * 获取护理记录统计
     */
    public void getTaskSummaryByPatient(String zyh, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_SUMMARY_BY_PAITENT, baseNurseReqBean, reqInterf);
    }

    /**
     * 获取病人医嘱数据
     */
    public void getPatientAdviceData(String zyh, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_ADVICE, reqBean, reqInterf);
    }

    /**
     * 获取化验报告数据
     */
    public void getAssayDataList(String zyh, String begin, OnNetWorkReqInterf reqInterf) {
        Date date = null;
        Calendar beginCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        String end = null;
        if (begin != null) {
            try {
                date = DateFormatUtil.convent_yyyyMMdd(begin);
                beginCalendar.setTime(date);
                endCalendar.setTime(date);
                endCalendar.set(Calendar.DAY_OF_MONTH, beginCalendar.get(Calendar.DAY_OF_MONTH) + 1);
                end = DateFormatUtil.convent_yyyyMMdd(endCalendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
    public void getMyPatientList(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MYPATIENT_LIST2, baseReqBean, reqInterf);
    }


    public void getAdditionList(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GETADDITION_LIST, baseReqBean, reqInterf);
    }

    /**
     * 获取病区病人l列表
     */
    public void getRegion(OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean baseReqBean = new BaseNurseReqBean();
        baseReqBean.setRid(MethodValue.getUserInfo(context).getData().getUser().getRegions().get(0));
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_LIST_IN_AREA, baseReqBean, reqInterf);
    }

    public void getMyPatientList(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_LIST_RESULT_PATIENT, reqBean, reqInterf);
    }


    public void getMultipleRecordData(String begin, String end, String zyh, OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setBegin(begin);
        reqBean.setEnd(end);
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MULTIPLE_RECORD_DATA, reqBean, reqInterf);
    }

    public void getRecordTemplate(OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_TEMPLETE, new BaseReqBean(), reqInterf);
    }

    public void getRecordData(RecordDataReqBean req, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_DATA, req, reqInterf);
    }


    public void updateRecordData(JsonDataListReqBean req, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_RECORD_DATA, req, reqInterf);
    }

    public void getRecordDetailData(DataChartReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_DATA, reqBean, reqInterf);
    }

    public void getPatientReportData(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_REPORT, reqBean, reqInterf);
    }

    public void writeRecordData(ArrayList<DataTemplateResBean> list, String zyh, String wardid, OnNetWorkReqInterf reqInterf) {
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

    public void writeRecordData(DataTemplateResBean data, String zyh, String wardid, OnNetWorkReqInterf reqInterf) {
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

    public void writePatientReportData(InputHORReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_PATIENT_REPORT, reqBean, reqInterf);
    }

    public void getPatientTask(String zyh, OnNetWorkReqInterf reqInterf) {
        GetPatientTaskReqBean reqBean = new GetPatientTaskReqBean();
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_TASK, reqBean, reqInterf);
    }


    public void GetPatientTaskOfToday(GetPatientTaskOfTodayReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_TASK_TODAY, reqBean, reqInterf);
    }

    public void getTaskSummaryByPatient(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_SUMMARY_BY_PAITENT, reqBean, reqInterf);
    }

    public void getTaskDetailByCondition(NurseRecordReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_TASK_DETAIL_BY_CONDITION, reqBean, reqInterf);
    }

    public void getPatientAdditionData(PatientBedResBean resBean, OnNetWorkReqInterf reqInterf) {

        PatientAdditionReqBean patientAdditionReqBean = new PatientAdditionReqBean();
        patientAdditionReqBean.setZyh(resBean.get住院号());
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_ADDITION, patientAdditionReqBean, reqInterf);
    }

    public void getlistResultPatient(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_LIST_RESULT_PATIENT, reqBean, reqInterf);
    }

    public void getCheckTasks(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_CHECK_TASK, reqBean, reqInterf);
    }


    public void updateCheckStatus(UpdateCheckListReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_CHECK_TASK, reqBean, reqInterf);
    }


    public void writeAlarmLogs(WriteAlarmReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_ALARM_LOG, reqBean, reqInterf);
    }


    public void keepAlive(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_KEEP_ALIVE, new BaseReqBean(), reqInterf);
    }

    public void writeInventoryCount(AddCheckBookListReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_INVENTORY_COUNT, reqBean, reqInterf);
    }

    public void getHospitalAnnounceMent(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_HOSPITAL_ANNOUNCEMENT, new BaseReqBean(), reqInterf);
    }

    public void getWardInspectionList(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WARD_INSPECTION_LIST, new BaseReqBean(), reqInterf);
    }


    public void writeWardInspectionInfo(WriteBedCheckReqBean req, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_WARD_INSPECTION_INFO, req, reqInterf);
    }


    public void getDailyBedReportByRegion(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DAILYBED_REPORT_BY_REGION, reqBean, reqInterf);
    }

    public void getInstrumentFileItem(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_CHECK_BOOK_DATA, new BaseReqBean(), reqInterf);
    }

    public void getInstrumentCountData(CheckBookDetailReqBean checkBookDetailReqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_BOOK_DETAIL_DATA, checkBookDetailReqBean, reqInterf);
    }

    public void getWorkShifts(BaseNurseReqBean baseReqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WORK_SHIFTS, baseReqBean, reqInterf);
    }


    public void getReportData(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_REPORT_DATA, reqBean, reqInterf);
    }

    public void getAlarmLogs(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_ALARM_LOGS, reqBean, reqInterf);
    }


    public void getWorkloadByUser(BaseNurseReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WORK_LOAD_BY_USER, reqBean, reqInterf);
    }

    public void updateTask(MissisonDetailReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_TASK, reqBean, reqInterf);
    }


    public void getMyWardTaskOfToday(OnNetWorkReqInterf reqInterf) {

        MyWardTaskTodayReqBean myWardTaskTodayReqBean = new MyWardTaskTodayReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_AREA_TASK_TODAY, myWardTaskTodayReqBean, reqInterf);
    }

    public void getMyPatientTaskOfToday(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_PATIENT_TASK_TODAY, baseReqBean, reqInterf);
    }

    public void getMyWardTaskOfHistory(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_AREA_TASK_HISTORY_NOT_FINISHED, baseReqBean, reqInterf);
    }

    public void getMyPatientTaskOfHistory(OnNetWorkReqInterf reqInterf) {
        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_PATIENT_TASK_HISTORY, baseReqBean, reqInterf);
    }

    public void getMissionData(String type, OnNetWorkReqInterf reqInterf) {
        switch (type) {
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_AREA:
                getMyWardTaskOfToday(reqInterf);
                break;
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                getMyPatientTaskOfToday(reqInterf);
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_AREA:
                getMyWardTaskOfHistory(reqInterf);
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                getMyPatientTaskOfHistory(reqInterf);
                break;
        }
    }

    public void changePassword(UpdatePwdReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_CHANGE_PWD, reqBean, reqInterf);
    }

    public void onGetallregionbyuser(String account, OnNetWorkReqInterf reqInterf) {

        GetallregionbyuserNetBean getallregionbyuserNetBean = new GetallregionbyuserNetBean();
        getallregionbyuserNetBean.setUid(account);
        NetWork.getInstance(context).doHttpRequset(context, DataValue.URL_GETALLREGIONBYUSER, getallregionbyuserNetBean, reqInterf);
    }

    public void onLogin(String account, String pwd, OnNetWorkReqInterf reqInterf) {

        DoLoginReqBean doLoginReqBean = new DoLoginReqBean();
        doLoginReqBean.setDeviceid(ValueConstant.UUUID);
        doLoginReqBean.setPassword(pwd);
        doLoginReqBean.setUsername(account);
        NetWork.getInstance(context).dologin(context, DataValue.URL_DOLOGIN, doLoginReqBean, reqInterf);
    }

    public void onDologout(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_DOLOGIN_OUT, baseReqBean, reqInterf);
    }


}
