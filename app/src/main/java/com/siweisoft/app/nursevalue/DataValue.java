package com.siweisoft.app.nursevalue;


import com.siweisoft.lib.constant.UrlConstant;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class DataValue {

    public static final String ACITON_NURSE_GLOB_CAST = "action_nurse_glob_cast";

    /**
     * 请求网址
     */
    public static final String URL_NURSE = "http://192.168.1.204";

    public static final String URL_NURSE_OUTSIDE = "http://180.168.218.122:4080";

    public static final String URL_OTHER = "/api.cshtml?key=";

    //-------------------------------------------------------------------------------------------------------
    /**
     * 登录
     */
    public static final String URL_DOLOGIN = "dologin";

    /**
     * 修改密码
     */
    public static final String URL_CHANGE_PWD = "changePassword";

    /**
     * 用户注销
     */
    public static final String URL_DOLOGIN_OUT = "dologout";

    //-------------------------------------------------------------------------------------------------------

    //录入病房巡视数据
    public static final String URL_WRITE_WARD_INSPECTION_INOF = "writeWardInspectionInfo";

    /**
     * 获取病区
     */
    public static final String URL_GETALLREGIONBYUSER = "getallregionbyuser";

    /**
     * 获取我的病人列表
     */
    public static final String URL_GET_MYPATIENT_LIST2 = "getMyPatientList2";

    /**
     * 得到文书模板类别
     */
    public static final String URL_GET_DOCUMENT_FORM = "getFormList2";

    /**
     * 获取文书模板
     */
    public static final String URL_GET_DOCUMENT_DETAIL = "getFileTemplate";

    /**
     * 获取病人的文书数据
     */
    public static final String URL_GET_FILE_DATA_BY_PATIENT = "getFileDataByPatient02";

    /**
     * 获取指定医嘱的用药量
     */
    public static final String URL_GET_BYL_BY_ADVID = "getBYLbyAdvID";

    /**
     * 提交补液卡数据
     */
    public static final String URL_WIITE_ADDWATER_DATA = "writeFileData";


    public static final String URL_GETADDITION_LIST = "getAdditionList";

    //-------------------------------------------------------------------------------------------------------

    /**
     * 获取病区任务
     */
    public static final String URL_GET_AREA_TASK_HISTORY = "getMyTaskList2";


    /**
     * 获取病区历史未完成任务
     */
    public static final String URL_GET_MY_AREA_TASK_HISTORY_NOT_FINISHED = "getMyWardTaskOfHistory";

    /**
     * 获取今日病区任务
     */
    public static final String URL_GET_MY_AREA_TASK_TODAY = "getMyWardTaskOfToday";

    /**
     * 获取今日我的任务
     */
    public static final String URL_GET_MY_PATIENT_TASK_TODAY = "getMyPatientTaskOfToday";

    /**
     * 获取我的任务
     */
    public static final String URL_GET_MY_TASK_HISTORY = "getMyTaskList3";

    /**
     * 病人历史未完成任务
     */
    public static final String URL_GET_MY_PATIENT_TASK_HISTORY = "getPatientTaskOfHistory";


    /**
     * 更新任务状态
     */
    public static final String URL_UPDATE_TASK = "updateTask";

    //-------------------------------------------------------------------------------------------------------
    /**
     * 获取我的病人
     */
    public static final String URL_GET_MY_PATIENT_IN_BAD_LIST = "getMyPatientList2";

    /**
     * 获取病区病人
     */
    public static final String URL_GET_PATIENT_LIST_IN_AREA = "getRegion";

    /**
     * 获取病区病人
     */
    public static final String URL_UPDATE_Y_PATIENT_LIST = "updateMyPatientList";

    /**
     * 获取病人的过敏、手术、关怀、病情等数据（附加信息）
     */
    public static final String URL_GET_ADDITION = "getAdditionList";

    /**
     * 获取今日病人个人护理任务
     */
    public static final String URL_GET_PATIENT_TASK_TODAY = "getPatientTaskOfToday";


    /**
     * 获取病人个人护理任务
     */
    public static final String URL_GET_PATIENT_TASK = "getPatientTask2";

    /**
     * 获取病人医嘱数据
     */
    public static final String URL_GET_PATIENT_ADVICE = "getPatientAdvice";


    /**
     * 获取化验报告数据
     */
    public static final String URL_GET_LIST_RESULT_PATIENT = "getListResultByPatient";


//    /**获取病区病床交接数据*/
//    public static final String URL_GET_REPORT_DATA= "getReportData";


    /**
     * 获取病区病床交接数据
     */
    public static final String URL_GET_WORK_LOAD_BY_USER = "getWorkloadByUser";

    /**
     * 获取病区病床交接数据
     */
    public static final String URL_GET_REPORT_DATA = "getReportData";

    /**
     * 获取护理记录统计
     */
    public static final String URL_GET_SUMMARY_BY_PAITENT = "getTaskSummaryByPatient";

    /**
     * 根据医嘱类别获取任务详情
     */
    public static final String URL_GET_TASK_DETAIL_BY_CONDITION = "getTaskDetailByCondition";

    /**
     * 获取病人交接记录
     */
    public static final String URL_GET_PATIENT_REPORT = "getPatientReportData";

    /**
     * 录入点物本数据
     */
    public static final String URL_WRITE_INVENTORY_COUNT = "writeInventoryCountData";


    /**
     * 录入病人交接记录
     */
    public static final String URL_WRITE_PATIENT_REPORT = "writePatientReportData";

    /**
     * 获取我的排班表
     */
    public static final String URL_GET_WORK_SHIFTS = "getWorkShifts";

    /**
     * 获取紧急报告（当天的紧急报告）
     */
    public static final String URL_GET_ALARM_LOGS = "getAlarmLogs";

    /**
     * 获取配药核对的任务
     */
    public static final String URL_GET_CHECK_TASK = "getCheckTasks";


    /**
     * 更新配药核对状态
     */
    public static final String URL_UPDATE_CHECK_TASK = "updateCheckStatus";


    /**
     * 获取病区任务
     */
    public static final String URL_GET_MY_AREA_TASK_HISTORY = "getMyTaskList2";

    /**
     * 获取病人附加项目
     */
    public static final String URL_GET_PATIENT_ADDITION = "getPatientAdditionData";

    /**
     * 获取病区病人
     */
    public static final String URL_UPDATE_PATIENT_ADDITION = "writePatientAdditionData";

    //----------------------------------------------------------------------------------------------
    /**
     * 获取病人体征数据
     */
    public static final String URL_GET_MULTIPLE_RECORD_DATA = "getMultipleRecordData2";

    /**
     * 获取体征模板
     */
    public static final String URL_GET_RECORD_TEMPLETE = "getRecordTemplate";

    /**
     * 获取体征中某一项的所有数据
     */
    public static final String URL_GET_RECORD_DATA = "getRecordData2";

    /**
     * 录入体征数据
     */
    public static final String URL_WRITE_RECORD_DATA = "writeRecordData2";

    /**
     * 修改体征数据
     */
    public static final String URL_UPDATE_RECORD_DATA = "updateRecordData";

    //----------------------------------------------------------------------------------------------
    //信息模块
    /**
     * 获取点物本的项目
     */
    public static final String URL_CHECK_BOOK_DATA = "getInventoryFileItem";

    /**
     * 获取点物本数据
     */
    public static final String URL_GET_BOOK_DETAIL_DATA = "getInventoryCount";

    /**
     * 获取病区病床日报统计
     */
    public static final String URL_GET_DAILYBED_REPORT_BY_REGION = "getDailyBedReportByRegion";


    //
    public static final String URL_GET_PAT_AND_TASK_INFO_BY_DOC_ADVID = "getPatAndTaskInfoByDocAdvID";


    //----------------------------------------------------------------------------------------------

    /**
     * 更新紧急报告
     */
    public static final String URL_WRITE_ALARM_LOG = "writeAlarmLogs";

    /**
     * 定期读取紧急报告和床位呼叫
     */
    public static final String URL_KEEP_ALIVE = "keepAlive";

    //获取床位呼叫(一小时内)
    public static final String URL_GET_CALLING_LOGS = "getCallingLogs";

    //更新床位呼叫
    public static final String URL_UPDATE_CALLING_LOGS = "updateCallingLogs";


    //----------------------------------------------------------------------------------------------


    /**
     * 获取通知公告
     */
    public static final String URL_GET_HOSPITAL_ANNOUNCEMENT = "getHospitalAnnouncement";


    /**
     * 获取病房巡视数据
     */
    public static final String URL_GET_WARD_INSPECTION_LIST = "getWardInspectionList";


    /**
     * 录入病房巡视数据
     */
    public static final String URL_WRITE_WARD_INSPECTION_INFO = "writeWardInspectionInfo";


    public static final String STATUS_LONG_TIME = "长期";

    public static final String STATUS_SHORT_TIME = "临时";

    public static final String STATUS_CARE_TIME = "护嘱";


    public static ArrayList<String> STATUS_TYPE_TIME = new ArrayList<>();


    public static String PAITENT_AREA = "";


    public static final String LEVEL_NURSE_1 = "一级护理";

    public static final String LEVEL_NURSE_2 = "二级护理";

    public static final String LEVEL_NURSE_3 = "三级护理";

    public static final int W_O_1 = 111;
    public static final int W_O_2 = 112;
    public static final int W_O_3 = 113;
    public static final int W_M_1 = 121;
    public static final int W_M_2 = 122;
    public static final int W_M_3 = 123;
    public static final int W_Y_1 = 131;
    public static final int W_Y_2 = 132;
    public static final int W_Y_3 = 133;
    public static final int M_O_1 = 211;
    public static final int M_O_2 = 212;
    public static final int M_O_3 = 213;
    public static final int M_M_1 = 221;
    public static final int M_M_2 = 222;
    public static final int M_M_3 = 223;
    public static final int M_Y_1 = 231;
    public static final int M_Y_2 = 232;
    public static final int M_Y_3 = 233;


    //任务状态，A:已审核，F:未执行，T:已完成，N:病人不在，R:病人拒绝，S:删除


    public static HashMap<String, String> STATUS_MAPMAP = new HashMap<>();

    public static final String STATUS_YI_SENG_HE = "A";

    public static final String STATUS_WEI_ZHI_XING = "F";

    public static final String STATUS_YI_WAN_CHENG = "T";

    public static final String STATUS_BING_REN_BU_ZAI = "N";

    public static final String STATUS_BING_REN_JU_JUE = "R";

    public static final String SSTATUS_SHAN_CHU = "S";


    public static void init() {
        UrlConstant.URI = URL_NURSE_OUTSIDE + URL_OTHER;
        STATUS_TYPE_TIME.add(STATUS_LONG_TIME);
        STATUS_TYPE_TIME.add(STATUS_SHORT_TIME);
        STATUS_TYPE_TIME.add(STATUS_CARE_TIME);

        STATUS_MAPMAP.put(STATUS_YI_SENG_HE, "已审核");
        STATUS_MAPMAP.put(STATUS_WEI_ZHI_XING, "未执行");
        STATUS_MAPMAP.put(STATUS_YI_WAN_CHENG, "已完成");
        STATUS_MAPMAP.put(STATUS_BING_REN_BU_ZAI, "病人不在");
        STATUS_MAPMAP.put(STATUS_BING_REN_JU_JUE, "病人拒绝");
        STATUS_MAPMAP.put(SSTATUS_SHAN_CHU, "删除");
    }
}
