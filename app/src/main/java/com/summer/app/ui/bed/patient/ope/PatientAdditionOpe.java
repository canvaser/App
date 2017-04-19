package com.summer.app.ui.bed.patient.ope;

import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.app.ui.bed.patient.bean.resbean.PatientAdditionListResBean;
import com.summer.app.ui.bed.patient.bean.resbean.PatientAdditionResBean;
import com.summer.app.ui.home.bean.resbean.AdditionListResBean;
import com.summer.app.ui.home.bean.resbean.AdditionResbean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class PatientAdditionOpe {

    ArrayList<String> strings = new ArrayList<>();

    public ArrayList<PatientAdditionResBean> getThispatientAdditionList(PatientAdditionListResBean res) {
        if (res == null) {
            return null;
        }
        strings.add("病重");
        strings.add("病危");
        strings.add("气管筒");
        strings.add("全喉筒");
        strings.add("防跌倒");
        String s = SPUtil.getInstance().getStr(ValueConstant.ADDITION_INFO);
        ArrayList<PatientAdditionResBean> patientAdditionResBeen = new ArrayList<>();
        AdditionListResBean resBean = GsonUtil.getInstance().fromJson(s, AdditionListResBean.class);
        HashMap<String, AdditionResbean> additionResbeanHashMap = new HashMap<>();
        for (int i = 0; i < resBean.getData().size(); i++) {
            additionResbeanHashMap.put(resBean.getData().get(i).getCode(), resBean.getData().get(i));
        }


        PatientAdditionResBean patientAdditionResBean = null;
        String[] ss = null;
        for (int i = 0; res != null && res.getData() != null && i < res.getData().size(); i++) {
            if (res.getData().get(i).getValue().contains(",")) {
                patientAdditionResBean = res.getData().get(i);
                ss = res.getData().get(i).getValue().split(",");
            }
        }

        if (ss == null) {
            for (int i = 0; res != null && res.getData() != null && i < res.getData().size(); i++) {
                if (!res.getData().get(i).getValue().contains(",")) {
                    AdditionResbean additionResbean = additionResbeanHashMap.get(res.getData().get(i).getValue());
                    if (additionResbean != null) {
                        if (additionResbean.getCanSet().equals("Y")) {
                            patientAdditionResBeen.add(new PatientAdditionResBean(additionResbean.getType(), additionResbean.getName(), true));
                        }
                    }

                }
            }
            for (int i = 0; i < patientAdditionResBeen.size(); i++) {
                for (int j = 0; j < strings.size(); j++) {
                    if (patientAdditionResBeen.get(i).getValue().equals(strings.get(j))) {
                        strings.remove(j);
                        j--;
                    }
                }
            }

            for (int i = 0; i < strings.size(); i++) {
                patientAdditionResBeen.add(new PatientAdditionResBean(strings.get(i), strings.get(i), false));
            }

            return patientAdditionResBeen;
        }


        for (int i = 0; i < ss.length; i++) {
            AdditionResbean additionResbean = additionResbeanHashMap.get(ss[i]);
            if (additionResbean != null) {
                if (additionResbean.getCanSet().equals("Y")) {
                    patientAdditionResBeen.add(new PatientAdditionResBean(additionResbean.getType(), additionResbean.getName(), true));
                }
            }
        }


        for (int i = 0; res != null && res.getData() != null && i < res.getData().size(); i++) {
            if (!res.getData().get(i).getValue().contains(",")) {
                AdditionResbean additionResbean = additionResbeanHashMap.get(res.getData().get(i).getValue());
                if (additionResbean != null) {
                    if (additionResbean.getCanSet().equals("Y")) {
                        patientAdditionResBeen.add(new PatientAdditionResBean(additionResbean.getType(), additionResbean.getName(), true));
                    }
                }

            }
        }
        for (int i = 0; i < patientAdditionResBeen.size(); i++) {
            for (int j = 0; j < strings.size(); j++) {
                if (patientAdditionResBeen.get(i).getValue().equals(strings.get(j))) {
                    strings.remove(j);
                    j--;
                }
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            patientAdditionResBeen.add(new PatientAdditionResBean(strings.get(i), strings.get(i), false));
        }


        return patientAdditionResBeen;
    }
}
