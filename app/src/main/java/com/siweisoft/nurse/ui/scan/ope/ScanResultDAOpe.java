package com.siweisoft.nurse.ui.scan.ope;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.ToastUtil;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.nurse.ui.bed.bedlist.fragment.BedListFGM;
import com.siweisoft.nurse.ui.bed.patient.fragment.PatientFrag;
import com.siweisoft.nurse.ui.check.checkblood.fragment.CheckBloodFrag2;
import com.siweisoft.nurse.ui.home.activity.IndexActivity;
import com.siweisoft.nurse.ui.info.bedcheck.fragment.BedCheckFrag;
import com.siweisoft.nurse.ui.scan.bean.DrugInfoResBean;
import com.siweisoft.nurse.ui.scan.bean.PatientScanInfoAResBean;

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
    String[] rule = new String[]{"\\d{12}", "(?=.*qrtype)(?=.*pat)(?=.*qrseat)(?=.*wd)(?=.*pno)(?=.*zyh)^.*$", "\\{.*pat#zywd#\\d{6}#\\d{6}.*\\}", "(?=.*qrtype)(?=.*region)(?=.*room)^.*$", "(?=.*qrtype)(?=.*pno)(?=.*zyh)(?=.*advno)(?=.*time)^.*$"};


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


        IndexActivity baseActivity = (IndexActivity) activity;
        if (baseActivity.getHomeUIOpe().getDrawerLayout().isShown()) {

        }

        if (FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex()).getClass().getName().equals(BedCheckFrag.class.getSimpleName())) {

            return;
        }


        //病人抽血核对
        if (FragManager.getInstance().getCurrentClass(baseActivity.getHomeDataOpe().getIndex()).getClass().getName().equals(CheckBloodFrag2.class.getSimpleName())) {

            return;
        }


        if (Pattern.compile(rule[1]).matcher(result).matches()) {
            PatientScanInfoAResBean resBean = GsonUtil.getInstance().fromJson(result, PatientScanInfoAResBean.class);
            goToPatient(activity, resBean.getPno());
            return;
        }

        if (Pattern.compile(rule[2]).matcher(result).matches()) {
            Matcher matcher = Pattern.compile(rule[2]).matcher(result);
            goToPatient(activity, result.split("#")[3].replace("}", ""));
            return;
        }

        if (Pattern.compile(rule[4]).matcher(result).matches()) {
            DrugInfoResBean resBean = GsonUtil.getInstance().fromJson(result, DrugInfoResBean.class);
            goToPatient(activity, resBean.getPno());
            return;
        }


        for (int i = 0; i < rule.length; i++) {
            if (Pattern.compile(rule[i]).matcher(result).matches()) {
                switch (i) {
                    case 0:
                        baseActivity.getHomeUIOpe().getViewPager().setCurrentItem(0);
                        FragManager.getInstance().clearTop(activity.getSupportFragmentManager(), 0);
                        Bundle bundle = new Bundle();
                        bundle.putString(ValueConstant.DATA_DATA, result);
                        FragManager.getInstance().startFragment(activity.getSupportFragmentManager(), 0, new CheckBloodFrag2());
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
            return;
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
                bedListFGM.getRegion2(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(ValueConstant.DATA_DATA, bedListFGM.getBaseOpes().getDaOpe().getAllList());
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
                bundle.putSerializable(ValueConstant.DATA_DATA, bedListFGM.getBaseOpes().getDaOpe().getAllList());
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
