package com.siweisoft.app.ui.info.addcheckbook.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.app.nursevalue.MethodValue;
import com.siweisoft.app.ui.info.addcheckbook.bean.reqbean.AddCheckBookReqBean;
import com.siweisoft.app.ui.info.checkbook.bean.resbean.CheckBookResBean;
import com.siweisoft.app.ui.info.checkbook.bean.resbean.CheckItemResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class AddCheckBookDAOpe extends BaseOpe {

    ArrayList<CheckBookResBean> data;


    CheckBookResBean checkBookResBean;

    int position;

    public CheckBookResBean getCheckBookResBean() {
        return data.get(position);
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public AddCheckBookDAOpe(Context context) {
        super(context);
    }

    public ArrayList<CheckBookResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckBookResBean> data) {
        this.data = data;
    }

    public ArrayList<String> getNames() {
        ArrayList<String> strings = new ArrayList<>();
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                strings.add(data.get(i).getFilename());
            }
        }
        return strings;
    }

    public void addHead() {
        for (int i = 0; i < data.size(); i++) {
            CheckItemResBean checkItemResBean = new CheckItemResBean();
            checkItemResBean.setItemname("班次");
            checkItemResBean.setValue("");
            data.get(i).getItems().add(0, checkItemResBean);
        }
    }


    public String getJsonData(CheckBookResBean bean) {
        ArrayList<AddCheckBookReqBean> addCheckBookReqBeen = new ArrayList<>();
        for (int i = 1; i < bean.getItems().size(); i++) {
            AddCheckBookReqBean addCheckBookReqBean = new AddCheckBookReqBean();
            addCheckBookReqBean.setValue(bean.getItems().get(i).getValue());
            addCheckBookReqBean.setFilename(bean.getFilename());
            addCheckBookReqBean.setFileid(bean.getFileid());
            addCheckBookReqBean.setType("1");
            addCheckBookReqBean.setInstrumentid(bean.getItems().get(i).getItemid());
            addCheckBookReqBean.setInstrumentname(bean.getItems().get(i).getItemname());
            addCheckBookReqBean.setShift(bean.getItems().get(0).getValue());
            addCheckBookReqBean.setUsername(MethodValue.getUserInfo(context).getData().getUser().getDisplayname());
            addCheckBookReqBeen.add(addCheckBookReqBean);
        }

        return GsonUtil.getInstance().toJson(addCheckBookReqBeen);
    }
}
