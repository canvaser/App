package com.siweisoft.nurse.nursenet;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.bean.req.BaseReqBean;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.lib.util.CalendarUtil;
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
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.bed.additionlist.bean.reqbean.UpdateAdditionReqBean;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentDetailReqBean;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListReqBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class NurseNetOpe extends BaseNetOpe{


    public NurseNetOpe(Context context) {
        super(context);
    }

    public void document_documemtList(String id,OnNetWorkReqInterf reqInterf) {
        DocumentListReqBean baseReqBean = new DocumentListReqBean();
        baseReqBean.setPid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_FORM, baseReqBean, reqInterf);
    }

    public void document_documemtdetail(String id,OnNetWorkReqInterf reqInterf) {
        DocumentDetailReqBean baseReqBean = new DocumentDetailReqBean();
        baseReqBean.setFid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_DETAIL, baseReqBean, reqInterf);
    }

    //补液卡列表
    public void addwater_list(String zyh,String fileid,String begin,String end,OnNetWorkReqInterf reqInterf){
        AddWaterReqBean baseReqBean = new AddWaterReqBean();
        baseReqBean.setZyh(zyh);
        baseReqBean.setFileid(fileid);
        baseReqBean.setBegin(begin);
        baseReqBean.setEnd(end);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_FILE_DATA_BY_PATIENT, baseReqBean, reqInterf);
    }

    /**获取指定医嘱的用药量*/
    public void getbylbyadvid(String id,OnNetWorkReqInterf reqInterf) {
        GetBylReqBean baseReqBean = new GetBylReqBean();
        baseReqBean.setAdvID(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_BYL_BY_ADVID, baseReqBean, reqInterf);
    }

    /**提交补液卡数据*/
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
        for(int i=0;i<data.size();i++){
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




    /**获取病区病人*/
    public void updateMyPatientList(MyPaitentUpdateListReqBean myPaitentUpdateListReqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_Y_PATIENT_LIST, myPaitentUpdateListReqBean, reqInterf);
    }

    ///**获取病区病人*/
    public void writePatientAdditionData(UpdateAdditionReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_PATIENT_ADDITION, reqBean, reqInterf);
    }

    /**获取护理记录统计*/
    public void getTaskSummaryByPatient(String zyh,OnNetWorkReqInterf reqInterf) {
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

}
