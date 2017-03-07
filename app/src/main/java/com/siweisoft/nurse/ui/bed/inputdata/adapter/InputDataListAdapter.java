package com.siweisoft.nurse.ui.bed.inputdata.adapter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.listener.BaseTextWather;
import com.siweisoft.lib.util.DatePickUitl;
import com.siweisoft.lib.util.SheetDialogUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.util.file.TimePickUtil;
import com.siweisoft.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateResBean;
import com.siweisoft.nurse.ui.bed.inputdata.bean.uibean.InputDataUIBean;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class InputDataListAdapter extends AppRecycleAdapter {

    DataTemplateResBean data;

    FragmentActivity fragmentActivity;

    public InputDataListAdapter(Context context, DataTemplateResBean data) {
        super(context);
        this.data = data;
        fragmentActivity = (FragmentActivity) context;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.getData().get(position).getItems().size() > 0 && data.getData().get(position).getItems().get(0).size() > 0) {
            return 0;
        } else if (data.getData().get(position).getSignname().equals("录入时间") || data.getData().get(position).getSignname().equals("图章时间")) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        InputDataUIBean uiBean = null;
        switch (viewType) {
            case 0:
            case 1:
                View view = layoutInflater.inflate(R.layout.list_inputdata2, parent, false);
                uiBean = new InputDataUIBean(context, view);
                break;
            case 2:
                View view1 = layoutInflater.inflate(R.layout.list_inputdata, parent, false);
                uiBean = new InputDataUIBean(context, view1);
                break;
        }
        return uiBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final InputDataUIBean uiBean = (InputDataUIBean) holder;
        uiBean.getNameTV().setText(StringUtil.getStr(data.getData().get(position).getSignname()));
        switch (getItemViewType(position)) {
            case 0:
                uiBean.getValueTV().setText(StringUtil.getStr(data.getData().get(position).getItems().get(0).get(0)));
                data.getData().get(position).setValue(StringUtil.getStr(uiBean.getValueTV().getText()));
                uiBean.getValueTV().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(context, data.getData().get(position).getItems().get(0));
                        SheetDialogUtil.getInstance().showBottomSheet(context, bottomDialogMenuView, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TextView textView = (TextView) v;
                                uiBean.getValueTV().setText(textView.getText());
                                data.getData().get(position).setValue(StringUtil.getStr(textView.getText()));
                                SheetDialogUtil.getInstance().dismess();
                            }
                        });
                    }
                });
                break;
            case 1:
                uiBean.getValueTV().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        DialogUtil.showTimePick(context, fragmentActivity.getSupportFragmentManager(), "date", Type.ALL, new OnDateSetListener() {
                            @Override
                            public void onDateSet(com.siweisoft.lib.view.pickerview.TimePickerDialog timePickerView, long millseconds) {
                                data.getData().get(position).setValue(DateFormatUtil.convent_yyyyMMddHHmmss(new Date(millseconds)));
                                uiBean.getValueTV().setText(data.getData().get(position).getValue());

                            }
                        });
                    }
                });
                break;
            case 2:
                uiBean.getValueETV().addTextChangedListener(new BaseTextWather() {
                    @Override
                    public void afterTextChanged(Editable s) {
                        data.getData().get(position).setValue(s.toString());
                    }
                });
                break;
        }

//        switch (data.getData().get(position).getGroupname()){
//            case "录入时间":
//                break;
//            case "":
//                break;
//        }


    }

    @Override
    public int getItemCount() {
        return data.getData() == null ? 0 : data.getData().size();
    }

    @Override
    public void onClick(View v) {

    }
}
