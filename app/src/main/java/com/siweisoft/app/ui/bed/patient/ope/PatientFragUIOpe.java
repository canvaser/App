package com.siweisoft.app.ui.bed.patient.ope;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.app.ui.bed.patient.adapter.CareListAdapter;
import com.siweisoft.lib.util.AnimUtil;
import com.siweisoft.lib.util.BitmapUtil;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.string.TextUtil;
import com.siweisoft.lib.view.recyclerview.GridRecyclerView;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.app.ui.bed.patient.bean.resbean.PatientAdditionResBean;

import java.text.ParseException;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class PatientFragUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.ll_baseinfo)
    View baseInfoView;


    @BindView(R.id.ll_some)
    View someView;


    @BindView(R.id.ll_infodetail)
    View infoDetailView;

    @BindView(R.id.rcv_rcv)
    RecyclerView recyclerView;

    CareListAdapter careListAdapter;

    ArrayList<PatientAdditionResBean> resBeen;

    @BindView(R.id.tv_name)
    TextView nameTV;


    @BindView(R.id.tv_sex)
    TextView sexTV;


    @BindView(R.id.tv_age)
    TextView ageTV;

    @BindView(R.id.tv_eat)
    TextView eatTV;

    @BindView(R.id.tv_zyh)
    TextView zyhTV;


    @BindView(R.id.tv_brithday)
    TextView brithTV;


    @BindView(R.id.tv_type)
    TextView typeTV;


    @BindView(R.id.tv_what)
    TextView whatTV;

    @BindView(R.id.tv_starttime)
    TextView startTimeTV;

    @BindView(R.id.tv_sstime)
    TextView ssTimeTV;

    @BindView(R.id.tv_outtime)
    TextView outTimeTV;

    @BindView(R.id.tv_tel)
    TextView telTV;

    @BindView(R.id.tv_guoming)
    TextView guoMingTV;

    @BindView(R.id.iv_head)
    ImageView headIV;


    @BindView(R.id.iv_arrow)
    ImageView arrowIV;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;


    public PatientFragUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
        anim();
    }

    public void anim() {
        AnimUtil.getInstance().startAnim(context, getHeadIV(), R.anim.anim_scale_in_1000);
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("病区");
        getBackTV().setVisibility(View.VISIBLE);


        getRightTV().setSelected(true);
        getRightTV().setText("设置");
        getRightTV().setVisibility(View.VISIBLE);


    }

    public void initTitle(String title) {
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setSelected(true);
        getMidTV().setText(title);
    }

    public void initInfo(PatientBedResBean resBean) {


        getNameTV().setText(StringUtil.getStr(resBean.get姓名()));
        TextUtil.getInstance().setText(getAgeTV(), "年龄:  " + StringUtil.getStr(resBean.getPatAge()) + "岁", "年龄:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getSexTV(), "性别:  " + StringUtil.getStr(resBean.get性别()), "性别:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getTelTV(), "电话号码:  " + resBean.get联系电话(), "电话号码:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getEatTV(), "膳食信息:  " + StringUtil.getStr(resBean.getLS31()), "膳食信息:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getTelTV(), "电话号码:  " + resBean.get联系电话(), "电话号码:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getZyhTV(), "住院号  :  " + resBean.getCPOEZYH(), "住院号  :  ".length(), Color.GRAY, Color.GRAY);
        try {
            TextUtil.getInstance().setText(getBrithTV(), "出生日期:  " + DateFormatUtil.convent_YYYYMMDD(DateFormatUtil.convent_yyyyMMddHHmmss(resBean.get出生日期())), "出生日期:  ".length(), Color.GRAY, Color.GRAY);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TextUtil.getInstance().setText(getTypeTV(), "就诊类型:  " + resBean.get就诊类型名称(), "就诊类型:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getStartTimeTV(), "入院时间:  " + resBean.get入院时间(), "入院时间:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getWhatTV(), "入院诊断:  " + StringUtil.getStr(resBean.get诊断名称()), "入院诊断:  ".length(), Color.GRAY, Color.GRAY);

        String srt = "";
        for (int i = 0; i < resBean.getLA54().size(); i++) {
            srt += resBean.getLA54().get(i) + "\n\t";
        }
        if (srt.endsWith("\n\t")) {
            srt = srt.substring(0, srt.length() - "\n\t".length());
        }
        TextUtil.getInstance().setText(getSsTimeTV(), "手术记录:  " + (srt.equals("") ? "无" : srt), "手术记录:  ".length(), Color.GRAY, Color.GRAY);
        TextUtil.getInstance().setText(getOutTimeTV(), "预出院日:  " + (NullUtil.isStrEmpty(resBean.get出院时间()) ? "暂无" : resBean.get出院时间()), "预出院日:  ".length(), Color.GRAY, Color.GRAY);

        BitmapUtil.getInstance().setBg(context, getHeadIV(), resBean.getResId());


    }

    public void setGuoMing(ArrayList<PatientAdditionResBean> resBeen) {
        String value = "无";
        for (int i = 0; i < resBeen.size(); i++) {
            if (resBeen.get(i).getType().equals("过敏")) {
                value = resBeen.get(i).getValue();
                TextUtil.getInstance().setText(getGuoMingTV(), "药物过敏:  " + value, "药物过敏:  ".length(), Color.RED, Color.RED);
                return;
            }
        }
        TextUtil.getInstance().setText(getGuoMingTV(), "药物过敏:  " + value, "药物过敏:  ".length(), Color.GRAY, Color.BLACK);
    }

    public void initAddionList(ArrayList<PatientAdditionResBean> resBeen) {
        this.resBeen = resBeen;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        careListAdapter = new CareListAdapter(context, resBeen);
        recyclerView.setAdapter(careListAdapter);
    }

    public ArrayList<PatientAdditionResBean> getSelectAddition() {
        ArrayList<PatientAdditionResBean> list = new ArrayList<>();
        for (int i = 0; i < this.resBeen.size(); i++) {
            if (this.resBeen.get(i).isSelect()) {
                list.add(resBeen.get(i));
            }
        }
        return list;
    }


    public View getBaseInfoView() {
        return baseInfoView;
    }

    public CareListAdapter getCareListAdapter() {
        return careListAdapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public View getSomeView() {
        return someView;
    }

    public View getInfoDetailView() {
        return infoDetailView;
    }

    public TextView getEatTV() {
        return eatTV;
    }

    public TextView getGuoMingTV() {
        return guoMingTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public ArrayList<PatientAdditionResBean> getResBeen() {
        return resBeen;
    }

    public TextView getAgeTV() {
        return ageTV;
    }

    public TextView getBrithTV() {
        return brithTV;
    }

    public TextView getOutTimeTV() {
        return outTimeTV;
    }

    public TextView getSsTimeTV() {
        return ssTimeTV;
    }

    public TextView getStartTimeTV() {
        return startTimeTV;
    }

    public TextView getTypeTV() {
        return typeTV;
    }

    public TextView getWhatTV() {
        return whatTV;
    }

    public TextView getZyhTV() {
        return zyhTV;
    }

    public TextView getTelTV() {
        return telTV;
    }

    public ImageView getHeadIV() {
        return headIV;
    }

    public ImageView getArrowIV() {
        return arrowIV;
    }

    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public TextView getSexTV() {
        return sexTV;
    }
}
