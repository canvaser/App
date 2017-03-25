package com.summer.app.ui.info.adddutereport.ope;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ui.info.shiftdutereport.bean.resbean.ShiftDuteReportResBean;
import com.summer.lib.base.ui.ope.BaseNurseUIOpe;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.NullUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.system.HandleUtil;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AddDuteReportUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.tv_zs)
    EditText zsTV;

    @BindView(R.id.tv_ry)
    EditText ryTV;

    @BindView(R.id.tv_zc)
    EditText zcTV;

    @BindView(R.id.tv_cy)
    EditText cyTV;


    @BindView(R.id.tv_zr)
    EditText zrTV;

    @BindView(R.id.tv_sw)
    EditText swTV;

    @BindView(R.id.tv_gy)
    EditText gyTV;

    @BindView(R.id.tv_js)
    EditText jsTV;

    @BindView(R.id.tv_bw)
    EditText bwTV;

    @BindView(R.id.tv_banci)
    TextView banCiTV;


    public AddDuteReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("交班本");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("提交");
        getRightTV().setSelected(true);
    }

    public String getData() {

        String[] strings = new String[]{"早早班", "早班", "两头班(早)", "大夜班", "小夜班", "两头班"};
        ShiftDuteReportResBean resBean = new ShiftDuteReportResBean();
        resBean.set总数(StringUtil.getStr(Integer.parseInt(getZsTV().getText().toString())));
        resBean.set入院(StringUtil.getStr(Integer.parseInt(getRyTV().getText().toString())));
        resBean.set转出(StringUtil.getStr(Integer.parseInt(getZcTV().getText().toString())));
        resBean.set出院(StringUtil.getStr(Integer.parseInt(getCyTV().getText().toString())));
        resBean.set转入(StringUtil.getStr(Integer.parseInt(getZrTV().getText().toString())));
        resBean.set死亡(StringUtil.getStr(Integer.parseInt(getSwTV().getText().toString())));
        resBean.set割症(StringUtil.getStr(Integer.parseInt(getGyTV().getText().toString())));
        resBean.set接生(StringUtil.getStr(Integer.parseInt(getJsTV().getText().toString())));
        resBean.set病危(StringUtil.getStr(Integer.parseInt(getBwTV().getText().toString())));
        for (int i = 0; i < strings.length; i++) {
            if (getBanCiTV().getText().toString().equals(strings[i])) {
                resBean.set班次((i + 1) + "");
                break;
            }
        }
        return GsonUtil.getInstance().toJson(resBean);

    }

    public void setInputType() {
        HandleUtil.getInstance().postDelayed(new Runnable() {
            @Override
            public void run() {
                getZsTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getRyTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getZcTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getCyTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getZrTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getSwTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getGyTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getJsTV().setInputType(InputType.TYPE_CLASS_NUMBER);
                getBwTV().setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        }, context.getResources().getInteger(R.integer.integer_time_short));
    }

    public boolean check() {
        if (NullUtil.isStrEmpty(getZsTV().getText().toString()) ||
                NullUtil.isStrEmpty(getZsTV().getText().toString()) ||
                NullUtil.isStrEmpty(getRyTV().getText().toString()) ||
                NullUtil.isStrEmpty(getZcTV().getText().toString()) ||
                NullUtil.isStrEmpty(getCyTV().getText().toString()) ||
                NullUtil.isStrEmpty(getZrTV().getText().toString()) ||
                NullUtil.isStrEmpty(getSwTV().getText().toString()) ||
                NullUtil.isStrEmpty(getGyTV().getText().toString()) ||
                NullUtil.isStrEmpty(getJsTV().getText().toString()) ||
                NullUtil.isStrEmpty(getBwTV().getText().toString())) {
            return false;
        }
        return true;
    }

    public EditText getBwTV() {
        return bwTV;
    }

    public EditText getCyTV() {
        return cyTV;
    }

    public EditText getGyTV() {
        return gyTV;
    }

    public EditText getJsTV() {
        return jsTV;
    }


    public EditText getRyTV() {
        return ryTV;
    }

    public EditText getSwTV() {
        return swTV;
    }

    public EditText getZcTV() {
        return zcTV;
    }

    public EditText getZrTV() {
        return zrTV;
    }

    public EditText getZsTV() {
        return zsTV;
    }

    public TextView getBanCiTV() {
        return banCiTV;
    }


}
