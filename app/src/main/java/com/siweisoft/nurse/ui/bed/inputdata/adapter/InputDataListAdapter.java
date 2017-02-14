package com.siweisoft.nurse.ui.bed.inputdata.adapter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.base.ui.listener.BaseTextWather;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.DataTemplateResBean;
import com.siweisoft.nurse.ui.bed.inputdata.bean.uibean.InputDataUIBean;
import com.siweisoft.util.DatePickUitl;
import com.siweisoft.util.SheetDialogUtil;
import com.siweisoft.util.StringUtil;
import com.siweisoft.util.data.DateFormatUtil;
import com.siweisoft.util.file.TimePickUtil;
import com.siweisoft.view.bottomdialogmenuview.BottomDialogMenuView;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class InputDataListAdapter extends AppRecycleAdapter{

    DataTemplateResBean data;

    public InputDataListAdapter(Context context,DataTemplateResBean data) {
        super(context);
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if(data.getData().get(position).getItems().size()>0 &&data.getData().get(position).getItems().get(0).size()>0 ){
            return 0;
        }else if(data.getData().get(position).getSignname().equals("录入时间") || data.getData().get(position).getSignname().equals("图章时间")){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        InputDataUIBean uiBean = null;
        switch (viewType){
            case 0:
            case 1:
                View view = layoutInflater.inflate(R.layout.list_inputdata2,parent,false);
                 uiBean = new InputDataUIBean(context,view);
                break;
            case 2:
                View view1 = layoutInflater.inflate(R.layout.list_inputdata,parent,false);
                 uiBean = new InputDataUIBean(context,view1);
                break;
        }
        return uiBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final InputDataUIBean uiBean = (InputDataUIBean) holder;
        uiBean.getNameTV().setText(StringUtil.getStr(data.getData().get(position).getSignname()));
        switch (getItemViewType(position)){
            case 0:
                uiBean.getValueTV().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(context,data.getData().get(position).getItems().get(0));
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
                        DatePickUitl.getInstance().showDatePickDialog(context, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, final int year, final int month, final int dayOfMonth) {
                                TimePickUtil.getInstance().showTimePickDialog(context, new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        data.getData().get(position).setValue(DateFormatUtil.getYYYYMMDDHHMM(year,month,dayOfMonth,hourOfDay,minute));
                                        uiBean.getValueTV().setText(data.getData().get(position).getValue());
                                    }
                                });
                            }
                        });
                    }
                });
                break;
            case 2:
                uiBean.getValueETV().addTextChangedListener(new BaseTextWather(){
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
        return data.getData()==null?0:data.getData().size();
    }

    @Override
    public void onClick(View v) {

    }
}
