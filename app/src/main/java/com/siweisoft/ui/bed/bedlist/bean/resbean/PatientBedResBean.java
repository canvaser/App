package com.siweisoft.ui.bed.bedlist.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class PatientBedResBean extends ResultResBean {

    private String 病床号;

    private String 病床名;

    private String 关联病区号;

    private String 关联病房号;

    private String 病人住院号;

    private String CPOEZYH;

    private String 状态;

    private String 流水号;

    private String 病历号;

    private String 姓名;

    private String 性别;

    private String 护理代码;

    private String 护理级别名称;

    private String 出生日期;

    private Integer patAge;

    private String 住院号;

    private String 就诊类型代码;

    private String 就诊类型名称;

    private String 入院时间;

    private String 出院时间;

    private String 就诊卡号;

    private String 病区代码;

    private String 病房号;

    private String 入院诊断代码;

    private String 诊断名称;

    private String diag_text;

    private String 医保分类代码;

    private ArrayList<AdditionCodeResBean> additionCodes;

    private String 联系电话;

    private String 危重级别;

    private String LS31;

    private ArrayList<String> LA54;

    private int resId;


    public ArrayList<AdditionCodeResBean> getAdditionCodes() {
        return additionCodes;
    }

    public void setAdditionCodes(ArrayList<AdditionCodeResBean> additionCodes) {
        this.additionCodes = additionCodes;
    }

    public String getCPOEZYH() {
        return CPOEZYH;
    }

    public void setCPOEZYH(String CPOEZYH) {
        this.CPOEZYH = CPOEZYH;
    }

    public String getDiag_text() {
        return diag_text;
    }

    public void setDiag_text(String diag_text) {
        this.diag_text = diag_text;
    }

    public ArrayList<String> getLA54() {
        return LA54;
    }

    public void setLA54(ArrayList<String> LA54) {
        this.LA54 = LA54;
    }

    public String getLS31() {
        return LS31;
    }

    public void setLS31(String LS31) {
        this.LS31 = LS31;
    }

    public Integer getPatAge() {
        return patAge;
    }

    public void setPatAge(Integer patAge) {
        this.patAge = patAge;
    }

    public String get住院号() {
        return 住院号;
    }

    public void set住院号(String 住院号) {
        this.住院号 = 住院号;
    }

    public String get入院时间() {
        return 入院时间;
    }

    public void set入院时间(String 入院时间) {
        this.入院时间 = 入院时间;
    }

    public String get入院诊断代码() {
        return 入院诊断代码;
    }

    public void set入院诊断代码(String 入院诊断代码) {
        this.入院诊断代码 = 入院诊断代码;
    }

    public String get关联病区号() {
        return 关联病区号;
    }

    public void set关联病区号(String 关联病区号) {
        this.关联病区号 = 关联病区号;
    }

    public String get关联病房号() {
        return 关联病房号;
    }

    public void set关联病房号(String 关联病房号) {
        this.关联病房号 = 关联病房号;
    }

    public String get出生日期() {
        return 出生日期;
    }

    public void set出生日期(String 出生日期) {
        this.出生日期 = 出生日期;
    }

    public String get出院时间() {
        return 出院时间;
    }

    public void set出院时间(String 出院时间) {
        this.出院时间 = 出院时间;
    }

    public String get医保分类代码() {
        return 医保分类代码;
    }

    public void set医保分类代码(String 医保分类代码) {
        this.医保分类代码 = 医保分类代码;
    }

    public String get危重级别() {
        return 危重级别;
    }

    public void set危重级别(String 危重级别) {
        this.危重级别 = 危重级别;
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public String get就诊卡号() {
        return 就诊卡号;
    }

    public void set就诊卡号(String 就诊卡号) {
        this.就诊卡号 = 就诊卡号;
    }

    public String get就诊类型代码() {
        return 就诊类型代码;
    }

    public void set就诊类型代码(String 就诊类型代码) {
        this.就诊类型代码 = 就诊类型代码;
    }

    public String get就诊类型名称() {
        return 就诊类型名称;
    }

    public void set就诊类型名称(String 就诊类型名称) {
        this.就诊类型名称 = 就诊类型名称;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    public String get护理代码() {
        return 护理代码;
    }

    public void set护理代码(String 护理代码) {
        this.护理代码 = 护理代码;
    }

    public String get护理级别名称() {
        return 护理级别名称;
    }

    public void set护理级别名称(String 护理级别名称) {
        this.护理级别名称 = 护理级别名称;
    }

    public String get流水号() {
        return 流水号;
    }

    public void set流水号(String 流水号) {
        this.流水号 = 流水号;
    }

    public String get状态() {
        return 状态;
    }

    public void set状态(String 状态) {
        this.状态 = 状态;
    }

    public String get病人住院号() {
        return 病人住院号;
    }

    public void set病人住院号(String 病人住院号) {
        this.病人住院号 = 病人住院号;
    }

    public String get病区代码() {
        return 病区代码;
    }

    public void set病区代码(String 病区代码) {
        this.病区代码 = 病区代码;
    }

    public String get病历号() {
        return 病历号;
    }

    public void set病历号(String 病历号) {
        this.病历号 = 病历号;
    }

    public String get病床号() {
        return 病床号;
    }

    public void set病床号(String 病床号) {
        this.病床号 = 病床号;
    }

    public String get病床名() {
        return 病床名;
    }

    public void set病床名(String 病床名) {
        this.病床名 = 病床名;
    }

    public String get病房号() {
        return 病房号;
    }

    public void set病房号(String 病房号) {
        this.病房号 = 病房号;
    }

    public String get联系电话() {
        return 联系电话;
    }

    public void set联系电话(String 联系电话) {
        this.联系电话 = 联系电话;
    }

    public String get诊断名称() {
        return 诊断名称;
    }

    public void set诊断名称(String 诊断名称) {
        this.诊断名称 = 诊断名称;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
