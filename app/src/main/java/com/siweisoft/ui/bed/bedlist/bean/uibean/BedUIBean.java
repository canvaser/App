package com.siweisoft.ui.bed.bedlist.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;
import com.siweisoft.lib.util.ScreenUtil;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedUIBean extends BaseUIBean {

    @BindView(R.id.tv_numname)
    TextView numAndNameTV;

    @BindView(R.id.iv_sex)
    ImageView sexIV;

    @BindView(R.id.iv_level)
    ImageView levelIV;


    @BindView(R.id.tv_empty)
    TextView emptyTV;

    @BindView(R.id.iv_ming)
    ImageView mingIV;

    @BindView(R.id.iv_shu)
    ImageView shuIV;

    @BindView(R.id.iv_ru)
    ImageView ruIV;

    @BindView(R.id.iv_chu)
    ImageView chuIV;

    @BindView(R.id.ll_r)
    View rV;

    @BindView(R.id.rl_item)
    View itemV;

    public BedUIBean(Context context, View convertView) {
        super(context, convertView);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLevelIV().getLayoutParams();
        LinearLayout linearLayout = (LinearLayout) getLevelIV().getParent();
        params.width = (int) ((ScreenUtil.w / 5) - params.leftMargin - params.rightMargin) - linearLayout.getPaddingLeft() - linearLayout.getPaddingRight();
        params.height = params.width;
        getLevelIV().setLayoutParams(params);
    }

    public ImageView getChuIV() {
        return chuIV;
    }

    public TextView getEmptyTV() {
        return emptyTV;
    }

    public ImageView getLevelIV() {
        return levelIV;
    }

    public ImageView getMingIV() {
        return mingIV;
    }

    public TextView getNumAndNameTV() {
        return numAndNameTV;
    }

    public ImageView getRuIV() {
        return ruIV;
    }

    public View getrV() {
        return rV;
    }

    public ImageView getSexIV() {
        return sexIV;
    }

    public ImageView getShuIV() {
        return shuIV;
    }

    public View[] getStatus() {
        return new View[]{shuIV, mingIV, ruIV, chuIV};
    }

    public View getItemV() {
        return itemV;
    }
}
