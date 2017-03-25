package com.summer.app.ui.info.shiftdutereport.ope;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ui.info.shiftdutereport.bean.resbean.ShiftDuteReportResBean;
import com.summer.lib.util.StringUtil;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteReportUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.tv_displayname)
    TextView nameTV;


    @BindView(R.id.tv_bcTitle)
    TextView titleTV;

    @BindView(R.id.create_time)
    TextView timeTV;

    @BindView(R.id.tv_zs)
    TextView zsTV;

    @BindView(R.id.tv_ry)
    TextView ryTV;

    @BindView(R.id.tv_zc)
    TextView zcTV;

    @BindView(R.id.tv_cy)
    TextView cyTV;


    @BindView(R.id.tv_zr)
    TextView zrTV;

    @BindView(R.id.tv_sw)
    TextView swTV;

    @BindView(R.id.tv_gy)
    TextView gyTV;

    @BindView(R.id.tv_js)
    TextView jsTV;

    @BindView(R.id.tv_bw)
    TextView bwTV;


    public ShiftDuteReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("交班本");
        getRightTV().setSelected(true);
        getRightTV().setText("填写");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
    }

    public void initData(ShiftDuteReportResBean res) {
        getBwTV().setText(StringUtil.getStr(res.get病危()));
        getCyTV().setText(StringUtil.getStr(res.get出院()));
        getGyTV().setText(StringUtil.getStr(res.get割症()));
        getJsTV().setText(StringUtil.getStr(res.get接生()));
        getNameTV().setText(StringUtil.getStr(res.getDisplayname()));
        getRyTV().setText(StringUtil.getStr(res.get出院()));
        getSwTV().setText(StringUtil.getStr(res.get死亡()));
        getTimeTV().setText(StringUtil.getStr(res.getCreate_time()));
        getTitleTV().setText(StringUtil.getStr(res.getBcTitle()));
        getZcTV().setText(StringUtil.getStr(res.get转出()));
        getZrTV().setText(StringUtil.getStr(res.get转入()));
        getZsTV().setText(StringUtil.getStr(res.get总数()));
    }

    public TextView getBwTV() {
        return bwTV;
    }

    public TextView getCyTV() {
        return cyTV;
    }

    public TextView getGyTV() {
        return gyTV;
    }

    public TextView getJsTV() {
        return jsTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public TextView getRyTV() {
        return ryTV;
    }

    public TextView getSwTV() {
        return swTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public TextView getTitleTV() {
        return titleTV;
    }

    public TextView getZcTV() {
        return zcTV;
    }

    public TextView getZrTV() {
        return zrTV;
    }

    public TextView getZsTV() {
        return zsTV;
    }
}
