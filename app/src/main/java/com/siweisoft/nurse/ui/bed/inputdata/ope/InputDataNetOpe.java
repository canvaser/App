package com.siweisoft.nurse.ui.bed.inputdata.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateDataResBean;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateResBean;
import com.siweisoft.nurse.ui.bed.inputdata.bean.reqbean.InputDataListReqBean;
import com.siweisoft.nurse.ui.bed.inputdata.bean.reqbean.InputDataReqBean;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.data.DateFormatUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class InputDataNetOpe extends BaseNetOpe{


    public InputDataNetOpe(Context context) {
        super(context);
    }


    public void writeRecordData(ArrayList<DataTemplateResBean> list,String zyh,String wardid, OnNetWorkReqInterf reqInterf) {
        ArrayList<InputDataReqBean> inputDataReqBeen = new ArrayList<>();
        for(int i=0;i< list.size();i++){
            ArrayList<DataTemplateDataResBean> ll = list.get(i).getData();
            for(int j=0;j<ll.size();j++){
                if(ll.get(j).getValue()!=null && !ll.get(j).getValue().equals("")){
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

    public void writeRecordData(DataTemplateResBean data,String zyh,String wardid, OnNetWorkReqInterf reqInterf) {
        ArrayList<InputDataReqBean> inputDataReqBeen = new ArrayList<>();
        ArrayList<DataTemplateDataResBean> ll = data.getData();
        boolean update = false;
        for(int i=0;i<ll.size();i++){
            if(!ll.get(i).getValue().equals("")){
                update = true;
                break;
            }
        }
        for(int j=0;j<ll.size();j++){
            if(ll.get(j).getValue()!=null && !ll.get(j).getValue().equals("")){
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
        inputDataListReqBean.setJson_data(GsonUtil.getInstance().toJson(inputDataReqBeen));
        if(update){
            NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_RECORD_DATA, inputDataListReqBean, reqInterf);
        }else{
            NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_RECORD_DATA, inputDataListReqBean, reqInterf);
        }

    }
}
