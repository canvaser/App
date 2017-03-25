package com.summer.app.ui.bed.advice.ope;

import android.content.Context;

import com.summer.app.ui.bed.advice.bean.resbean.AdviceTaskResBean;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.lib.base.ui.ope.BaseDAOpe;
import com.summer.lib.util.NullUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.app.ui.bed.advice.bean.resbean.AdviceResBean;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-12-02.
 */
public class AdviceDAOpe extends BaseDAOpe {

    private int position;

    private String begin = null;

    private HashMap<String, ArrayList<AdviceResBean>> hashMap;


    ArrayList<PatientBedResBean> patientBedResBeen;


    PatientBedResBean patientBedResBean;

    public AdviceDAOpe(Context context) {
        super(context);
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<PatientBedResBean> getPatientBedResBeen() {
        return patientBedResBeen;
    }

    public void setPatientBedResBeen(ArrayList<PatientBedResBean> patientBedResBeen) {
        this.patientBedResBeen = patientBedResBeen;
    }

    public PatientBedResBean getPatientBedResBean() {
        if (position != -1) {
            return patientBedResBeen.get(position);
        }
        return patientBedResBean;
    }


    public void cutTime(ArrayList<AdviceResBean> data) {
        if (data == null) {
            return;
        }
        for (int i = 0; i < data.size(); i++) {
            if (NullUtil.isStrEmpty(data.get(i).get结束时间s())) {
                continue;
            }
            try {
                data.get(i).set开始时间(DateFormatUtil.convent_MMddHHMM(DateFormatUtil.convent_yyyyMMddHHmmss(data.get(i).get开始时间s())).trim());
                data.get(i).set结束时间(DateFormatUtil.convent_MMddHHMM(DateFormatUtil.convent_yyyyMMddHHmmss(data.get(i).get结束时间s())).trim());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


    public ArrayList<String> getNames() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < getPatientBedResBeen().size(); i++) {
            strings.add(getPatientBedResBeen().get(i).get病床号() + " " + getPatientBedResBeen().get(i).get姓名());
        }
        return strings;
    }

    public void setPatientBedResBean(PatientBedResBean patientBedResBean) {
        this.patientBedResBean = patientBedResBean;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public HashMap<String, ArrayList<AdviceResBean>> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, ArrayList<AdviceResBean>> hashMap) {
        this.hashMap = hashMap;
    }

    public AreaMessionListResBean.DataBean getData(AdviceTaskResBean adviceTaskResBean, String name) {
        AreaMessionListResBean.DataBean resBean = new AreaMessionListResBean.DataBean();
        resBean.setBedId(adviceTaskResBean.getData().get(0).getBedno());
        resBean.setCodename(adviceTaskResBean.getData().get(0).get医嘱类别名称());
        resBean.setEnd(adviceTaskResBean.getData().get(0).get结束时间());
        resBean.setName(name);
        resBean.setStart(adviceTaskResBean.getData().get(0).get开始时间());
        resBean.setZyh(adviceTaskResBean.getData().get(0).get住院号());
        resBean.setTitles(new ArrayList<AreaMessionListResBean.DataBean.TitlesBean>());
        resBean.setClickable(false);
        for (int i = 0; i < adviceTaskResBean.getData().size(); i++) {
            AreaMessionListResBean.DataBean.TitlesBean titlesBean = new AreaMessionListResBean.DataBean.TitlesBean();
            titlesBean.setId(adviceTaskResBean.getData().get(i).getId());
            titlesBean.setContents(adviceTaskResBean.getData().get(i).get医嘱详情());
            titlesBean.setExectime((adviceTaskResBean.getData().get(i).get开始时间().trim()));
            titlesBean.setKey(adviceTaskResBean.getData().get(i).getKey());
            titlesBean.setStatus(adviceTaskResBean.getData().get(i).getStatus());
            titlesBean.set医嘱ID(adviceTaskResBean.getData().get(i).get医嘱ID());
            titlesBean.setTitle(adviceTaskResBean.getData().get(i).get医嘱详情());
            titlesBean.setTaskname(adviceTaskResBean.getData().get(i).getName());
            resBean.getTitles().add(titlesBean);
        }
        return resBean;
    }
}
