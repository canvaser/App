package com.siweisoft.nurse.ui.addwater.addaddwater.ope.daope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.activity.BaseActivity;
import com.siweisoft.lib.base.ui.bean.uibean.CommonUIBean;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.listener.BaseTextWather;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.lib.view.textview.AppEditText;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.GetBylResBean;
import com.siweisoft.nurse.ui.dialog.dialog.adapter.DialogAdapter;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.util.Date;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterDAOpe extends BaseDAOpe {

    AreaMessionListResBean.DataBean areaMessionResBean;

    AddAddWaterResBean addAddWaterResBean;

    GetBylResBean getBylResBean;

    int num = -1;

    int click = 0;

    long[] time = new long[]{0l, 0l};

    public static final int TYPE_DATE = 0;
    public static final int TYPE_TEXT = 1;

    public AddAddWaterDAOpe(Context context) {
        super(context);
    }

    public AreaMessionListResBean.DataBean getAreaMessionResBean() {
        return areaMessionResBean;
    }

    public void setAreaMessionResBean(AreaMessionListResBean.DataBean areaMessionResBean) {
        this.areaMessionResBean = areaMessionResBean;
    }

    public AddAddWaterResBean getAddAddWaterResBean() {
        return addAddWaterResBean;
    }

    public void setAddAddWaterResBean(AddAddWaterResBean addAddWaterResBean) {
        this.addAddWaterResBean = addAddWaterResBean;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public GetBylResBean getGetBylResBean() {
        return getBylResBean;
    }

    public void setGetBylResBean(GetBylResBean getBylResBean) {
        this.getBylResBean = getBylResBean;
    }

    public void fillcontent(String value) {
        for (int i = 0; i < addAddWaterResBean.getData().get(0).getData().size(); i++) {
            if (addAddWaterResBean.getData().get(0).getData().get(i).getTermname().equals("补液内容")) {
                addAddWaterResBean.getData().get(0).getData().get(i).setValue(value);
            }
        }
    }

    public void numPlus() {
        click++;
        if (click <= 11) {
            num++;
            if (num == 0) {
                time[0] = System.currentTimeMillis();
            }
            if (num == 10) {
                time[1] = System.currentTimeMillis();
            }
        }
    }

    public int getDisu() {
        float f = 600000l / (time[1] - time[0]);
        return Math.round(f);
    }

    public long[] getTime() {
        return time;
    }

    public void onBindViewHolder(final CommonUIBean holder, final int viewtype, final AddAddWaterResBean.DataBeanX.DataBean data, final int position) {
        holder.setText(R.id.tv_name, StringUtil.getStr(data.getTermname()));
        switch (viewtype) {
            case TYPE_DATE:
                if (holder.getView(R.id.tv_txt) == null) {
                    break;
                }
                holder.getView(R.id.tv_txt).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BaseActivity activity = (BaseActivity) context;
                        DialogUtil.showTimePick(context, activity.getSupportFragmentManager(), "date", Type.ALL, new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                holder.setText(R.id.tv_txt, DateFormatUtil.convent_yyyyMMddHHMM(new Date(millseconds)));
                                data.setValue(((TextView) holder.getView(R.id.tv_txt)).getText().toString());
                            }
                        });
                    }
                });
                holder.setText(R.id.tv_txt, StringUtil.getStr(data.getValue()));
                break;
            case TYPE_TEXT:
                switch (data.getValuetype()) {
                    case "string":
                        ((AppEditText) holder.getView(R.id.et_txt)).setType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case "int":
                        ((AppEditText) holder.getView(R.id.et_txt)).setType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
                        break;
                    case "float":
                        ((AppEditText) holder.getView(R.id.et_txt)).setType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        break;
                }
                ((AppEditText) holder.getView(R.id.et_txt)).setSubTxt(data.getSuffix());
                ((AppEditText) holder.getView(R.id.et_txt)).setText(StringUtil.getStr(data.getValue()));
                ((AppEditText) holder.getView(R.id.et_txt)).addTextChangedListener(new BaseTextWather() {
                    @Override
                    public void afterTextChanged(Editable s) {
                        super.afterTextChanged(s);
                        data.setValue(s.toString());
                    }
                });
                break;
        }
        if (data.getItems().size() == 0
                || data.getItems().get(0) == null
                || data.getItems().get(0).size() == 0
                || NullUtil.isStrEmpty(data.getItems().get(0).get(0))
                ) {
            holder.getView(R.id.down).setVisibility(View.INVISIBLE);
            holder.getView(R.id.down).setEnabled(false);
        } else {
            holder.getView(R.id.down).setVisibility(View.VISIBLE);
            holder.getView(R.id.down).setEnabled(true);
            holder.getView(R.id.down).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View view = LayoutInflater.from(holder.getmContext()).inflate(R.layout.dialog_addaddwater_items, null);
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
                    final String[] strings = new String[data.getItems().get(0).size()];
                    for (int i = 0; i < data.getItems().get(0).size(); i++) {
                        strings[i] = data.getItems().get(0).get(i);
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.addItemDecoration(new MyItemDecoration2(context, 2));
                    recyclerView.setAdapter(new DialogAdapter(context, strings));
                    ((DialogAdapter) recyclerView.getAdapter()).setOnAppItemClickListener(new OnAppItemClickListener() {
                        @Override
                        public void onAppItemClick(View view, int position) {
                            holder.setText(R.id.et_txt, strings[position]);
                            DialogUtil.getInstance().dismiss();
                        }
                    });
                    DialogUtil.getInstance().showDialog(context, view, null);
                }
            });
        }
    }
}
