package com.summer.app.ui.scan.ope;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.summer.app.db.ope.ScanDBOpe;
import com.summer.app.ui.bed.patient.fragment.PatientFrag;
import com.summer.app.ui.check.checklist.fragment.CheckListFGM;
import com.summer.app.ui.check.patientcheck.fragment.PatientCheckFarg;
import com.summer.app.ui.home.activity.IndexActivity;
import com.summer.app.ui.info.bedcheck.bean.reqbean.WriteBedCheckReqBean;
import com.summer.app.ui.scan.bean.PatientScanInfoAResBean;
import com.summer.app.ui.scan.bean.RoomInfoResBean;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.ope.BaseDAOpe;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.LogUtil;
import com.summer.lib.util.NullUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.app.db.bean.ScanDBBean;
import com.summer.app.ui.bed.bedlist.fragment.BedListFGM;
import com.summer.app.ui.check.checkblood.fragment.CheckBloodFrag2;
import com.summer.app.ui.info.bedcheck.fragment.BedCheckFrag;
import com.summer.app.ui.scan.bean.DrugInfoResBean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class ScanResultDAOpe extends BaseDAOpe {

    private static ScanResultDAOpe instance;

    //条形码
    //{\"qrtype\":\"pat\",\"qrseat\":\"wd\",\"pno\": \"830135\", \"zyh\": \"830591\"}
    //{pat#zywd#864871#840176}
    //{\"qrtype\":\"room\",\"region\":\"0250040\",\"room\":\"01\"}
    //{"qrtype":"drug","pno":"住院号","zyh":"住院流水号","advno":"医嘱ID","time":"用药时间"} {"qrtype":"drug","pno":"929443","zyh":"929443","advno":"cq_2747691","time":"2016-12-08 10:10"}
    String rule0 = "\\d{12}";//条形码
    String rule1 = "\"(?=.*qrtype)(?=.*pat)(?=.*qrseat)(?=.*wd)(?=.*pno)(?=.*zyh)^.*$\"";//病人基本信息
    String rule2 = "\\{.*pat#zywd#\\d{6}#\\d{6}.*\\}"; // zywd=住院腕带，mzwd=门诊腕带
    String rule3 = "(?=.*qrtype)(?=.*region)(?=.*room)^.*$";//查房
    String rule4 = "(?=.*qrtype)(?=.*pno)(?=.*zyh)(?=.*advno)(?=.*time)^.*$";//用药核对
    String[] rule = new String[]{rule0, rule1, rule2, rule3, rule4};


    public static ScanResultDAOpe getInstance() {
        if (instance == null) {
            instance = new ScanResultDAOpe();
        }
        return instance;
    }

    private ScanResultDAOpe(Context context) {
        super(context);
    }

    private ScanResultDAOpe() {
        super(null);
    }

    public void sortResult(FragmentActivity activity, String result) {
        LogUtil.E(result);
        if (NullUtil.isStrEmpty(result)) {
            return;
        }
        ScanDBBean scanDBBean = new ScanDBBean();
        scanDBBean.setTime(DateFormatUtil.getnowTime());
        scanDBBean.setResult(result);
        new ScanDBOpe(activity, scanDBBean).save(scanDBBean);


        IndexActivity baseActivity = (IndexActivity) activity;
        if (baseActivity.getHomeUIOpe().getDrawerLayout().isShown()) {

        }

        //病人用药核对
        if (FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex()).getClass().getName().equals(PatientCheckFarg.class.getName())) {
            PatientCheckFarg patientCheckFarg = (PatientCheckFarg) FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex());
            if (Pattern.compile(rule[1]).matcher(result).matches()) {
                PatientScanInfoAResBean resBean = GsonUtil.getInstance().fromJson(result, PatientScanInfoAResBean.class);
                patientCheckFarg.Checked(resBean.getPno());
                return;
            }

            if (Pattern.compile(rule[2]).matcher(result).matches()) {
                Matcher matcher = Pattern.compile(rule[2]).matcher(result);
                patientCheckFarg.Checked(result.split("#")[3].replace("}", ""));
                return;
            }
            return;
        }

        //病房巡视
        if (FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex()).getClass().getName().equals(BedCheckFrag.class.getName())) {
            BedCheckFrag bedCheckFrag = (BedCheckFrag) FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex());
            if (Pattern.compile(rule[1]).matcher(result).matches()) {
                PatientScanInfoAResBean resBean = GsonUtil.getInstance().fromJson(result, PatientScanInfoAResBean.class);
                WriteBedCheckReqBean writeBedCheckReqBean = new WriteBedCheckReqBean();
                writeBedCheckReqBean.setZyh(resBean.getPno());
                bedCheckFrag.writeData(writeBedCheckReqBean);
                return;
            }
            if (Pattern.compile(rule[2]).matcher(result).matches()) {
                Matcher matcher = Pattern.compile(rule[2]).matcher(result);
                WriteBedCheckReqBean writeBedCheckReqBean = new WriteBedCheckReqBean();
                writeBedCheckReqBean.setZyh(result.split("#")[3].replace("}", ""));
                bedCheckFrag.writeData(writeBedCheckReqBean);
                return;
            }
            if (Pattern.compile(rule[3]).matcher(result).matches()) {
                RoomInfoResBean roomInfoResBean = GsonUtil.getInstance().fromJson(result, RoomInfoResBean.class);
                WriteBedCheckReqBean writeBedCheckReqBean = new WriteBedCheckReqBean();
                writeBedCheckReqBean.setRoom(roomInfoResBean.getRoom());
                writeBedCheckReqBean.setRegion(roomInfoResBean.getRegion());
                bedCheckFrag.writeData(writeBedCheckReqBean);
                return;
            }
            return;
        }


        //病人抽血核对
        if (FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex()).getClass().getName().equals(CheckBloodFrag2.class.getName())) {
            CheckBloodFrag2 frag2 = (CheckBloodFrag2) FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex());
            if (Pattern.compile(rule[0]).matcher(result).matches()) {
                if (frag2.getBaseOpes().getDaOpe().getPno() != null) {
                    frag2.checkPatAndPipeCode(result, null);
                    return;
                }
                frag2.getBaseOpes().getUiOpe().showFristInfo(result);
                return;
            }
            if (Pattern.compile(rule[1]).matcher(result).matches()) {
                PatientScanInfoAResBean resBean = GsonUtil.getInstance().fromJson(result, PatientScanInfoAResBean.class);
                frag2.checkPatAndPipeCode(null, resBean.getPno());
                return;
            }

            if (Pattern.compile(rule[2]).matcher(result).matches()) {
                Matcher matcher = Pattern.compile(rule[2]).matcher(result);
                //patientCheckFarg.Checked(result.split("#")[3].replace("}", ""));
                frag2.checkPatAndPipeCode(null, result.split("#")[3].replace("}", ""));
                return;
            }
            return;
        }
        if (FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex()).getClass().getName().equals(CheckListFGM.class.getName())) {
            CheckListFGM frag2 = (CheckListFGM) FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex());
            if (Pattern.compile(rule[4]).matcher(result).matches()) {
                DrugInfoResBean resBean1 = GsonUtil.getInstance().fromJson(result, DrugInfoResBean.class);
                IndexActivity indexActivity1 = (IndexActivity) activity;
                indexActivity1.getHomeUIOpe().getViewPager().setCurrentItem(2);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable(ValueConstant.DATA_DATA, resBean1);
                FragManager.getInstance().startFragment(indexActivity1.getSupportFragmentManager(), 2, new PatientCheckFarg(), bundle1);
                return;
            }
        }

        //非特殊界面
        for (int i = 0; i < rule.length; i++) {
            if (Pattern.compile(rule[i]).matcher(result).matches()) {
                switch (i) {
                    case 0:
                        IndexActivity indexActivity = (IndexActivity) activity;
                        indexActivity.getHomeUIOpe().getViewPager().setCurrentItem(2);
                        Bundle bundle = new Bundle();
                        bundle.putString(ValueConstant.DATA_DATA, result);
                        FragManager.getInstance().startFragment(indexActivity.getSupportFragmentManager(), 2, new CheckBloodFrag2(), bundle);
                        break;
                    case 1:
                        PatientScanInfoAResBean resBean = GsonUtil.getInstance().fromJson(result, PatientScanInfoAResBean.class);
                        goToPatient(activity, resBean.getPno());
                        break;
                    case 2:
                        Matcher matcher = Pattern.compile(rule[2]).matcher(result);
                        goToPatient(activity, result.split("#")[3].replace("}", ""));
                        break;
                    case 3:
                        break;
                    case 4:
                        DrugInfoResBean resBean1 = GsonUtil.getInstance().fromJson(result, DrugInfoResBean.class);
                        IndexActivity indexActivity1 = (IndexActivity) activity;
                        indexActivity1.getHomeUIOpe().getViewPager().setCurrentItem(2);
                        Bundle bundle1 = new Bundle();
                        bundle1.putSerializable(ValueConstant.DATA_DATA, resBean1);
                        FragManager.getInstance().startFragment(indexActivity1.getSupportFragmentManager(), 2, new PatientCheckFarg(), bundle1);
                        break;
                }
            }
        }

    }

    /**
     * 直接跳转到病人
     *
     * @param pno 住院号
     */
    public void goToPatient(final FragmentActivity activity, final String pno) {
        FragManager.getInstance().clearTopWith(activity.getSupportFragmentManager(), 0);
        Fragment fragment = FragManager.getInstance().getFragMaps().get(0).get(FragManager.getInstance().getFragMaps().get(0).size() - 1);
        if (fragment != null && fragment instanceof BedListFGM) {
            final BedListFGM bedListFGM = (BedListFGM) fragment;
            if (bedListFGM.getBaseOpes().getDaOpe().getAllList() == null) {
                bedListFGM.getData(3, new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(ValueConstant.DATA_DATA, bedListFGM.getBaseOpes().getDaOpe().getValidList());
                        bundle.putSerializable(ValueConstant.DATA_DATA2, bedListFGM.getBaseOpes().getDaOpe().getPatientBedResBean(bedListFGM.getBaseOpes().getDaOpe().getAllList(), pno));
                        if (bundle.getSerializable(ValueConstant.DATA_DATA2) == null) {
                            ToastUtil.getInstance().show(activity, "没有查找到此人");
                            return;
                        }
                        FragManager.getInstance().startFragment(activity.getSupportFragmentManager(), bedListFGM.getIndex(), new PatientFrag(), bundle);
                    }
                });
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA, bedListFGM.getBaseOpes().getDaOpe().getValidList());
                bundle.putSerializable(ValueConstant.DATA_DATA2, bedListFGM.getBaseOpes().getDaOpe().getPatientBedResBean(bedListFGM.getBaseOpes().getDaOpe().getAllList(), pno));
                if (bundle.getSerializable(ValueConstant.DATA_DATA2) == null) {
                    ToastUtil.getInstance().show(activity, "没有查找到此人");
                    return;
                }
                FragManager.getInstance().startFragment(activity.getSupportFragmentManager(), bedListFGM.getIndex(), new PatientFrag(), bundle);
            }
        }
    }


    public String getPno(String result) {
        if (Pattern.compile(rule[1]).matcher(result).matches()) {
            PatientScanInfoAResBean resBean = GsonUtil.getInstance().fromJson(result, PatientScanInfoAResBean.class);
            return resBean.getPno();
        }

        if (Pattern.compile(rule[2]).matcher(result).matches()) {
            Matcher matcher = Pattern.compile(rule[2]).matcher(result);
            for (int i = 0; i < matcher.groupCount(); i++) {
                LogUtil.E(matcher.group(i));
            }
            return "";
        }

        if (Pattern.compile(rule[4]).matcher(result).matches()) {
            DrugInfoResBean resBean = GsonUtil.getInstance().fromJson(result, DrugInfoResBean.class);
            return resBean.getPno();
        }

        return null;
    }

    public DrugInfoResBean getDrugInfoResBean(String result) {
        if (Pattern.compile(rule[3]).matcher(result).matches()) {
            DrugInfoResBean resBean = GsonUtil.getInstance().fromJson(result, DrugInfoResBean.class);
            return resBean;
        }
        return null;
    }


}
