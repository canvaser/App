package com.siweisoft.nurse.ui.addwater.addaddwater.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.activity.BaseActivity;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.listener.BaseTextWather;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.uibean.AddAddWaterUIBean;
import com.siweisoft.nurse.ui.dialog.dialog.adapter.DialogAdapter;
import com.siweisoft.nurse.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.util.Date;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterAdapter extends AppRecycleAdapter<AddAddWaterUIBean>{


    AddAddWaterResBean addAddWaterResBean;

    public static final int TYPE_DATE = 0;

    public static final int TYPE_TEXT = 1;

    public AddAddWaterAdapter(Context context,AddAddWaterResBean addAddWaterResBean) {
        super(context);
        this.addAddWaterResBean = addAddWaterResBean;
    }

    @Override
    public int getItemViewType(int position) {
        int type = TYPE_TEXT;
        switch (addAddWaterResBean.getData().get(0).getData().get(position).getType()){
            case "date":
                type=TYPE_DATE;
                break;
            case "text":
                type=TYPE_TEXT;
                break;
        }
        return type;
    }

    @Override
    public AddAddWaterUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_DATE:
                return new AddAddWaterUIBean(context,parent, R.layout.list_addaddwater_date);
            case TYPE_TEXT:
                return new AddAddWaterUIBean(context,parent, R.layout.list_addaddwater);
            default:
                return new AddAddWaterUIBean(context,parent, R.layout.list_addaddwater);
        }
    }

    @Override
    public void onBindViewHolder(final AddAddWaterUIBean holder, final int position) {
        holder.getNameTV().setText(StringUtil.getStr(addAddWaterResBean.getData().get(0).getData().get(position).getTermname()));
        switch (getItemViewType(position)){
            case TYPE_DATE:
                if( holder.getTxtTV()==null){
                    break;
                }
                holder.getTxtTV().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BaseActivity activity = (BaseActivity) context;
                        DialogUtil.showTimePick(context,activity.getSupportFragmentManager(),"date", Type.ALL, new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                holder.getTxtTV().setText(DateFormatUtil.convent_yyyyMMddHHMM(new Date(millseconds)));
                                addAddWaterResBean.getData().get(0).getData().get(position).setValue(holder.getTxtTV().getText().toString());
                            }
                        });
                    }
                });
                holder.getTxtTV().setText(StringUtil.getStr(addAddWaterResBean.getData().get(0).getData().get(position).getValue()));
                break;
            case TYPE_TEXT:
                switch (addAddWaterResBean.getData().get(0).getData().get(position).getValuetype()){
                    case "string":
                        holder.getTxtET().setType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case "int":
                        holder.getTxtET().setType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_VARIATION_NORMAL);
                        break;
                    case "float":
                        holder.getTxtET().setType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        break;
                }
                holder.getTxtET().setSubTxt(addAddWaterResBean.getData().get(0).getData().get(position).getSuffix());
                holder.getTxtET().setText(StringUtil.getStr(addAddWaterResBean.getData().get(0).getData().get(position).getValue()));
                holder.getTxtET().addTextChangedListener(new BaseTextWather(){
                    @Override
                    public void afterTextChanged(Editable s) {
                        super.afterTextChanged(s);
                        if(position>=addAddWaterResBean.getData().get(0).getData().size()){
                            return;
                        }
                        addAddWaterResBean.getData().get(0).getData().get(position).setValue(s.toString());
                    }
                });
                break;
        }
        if(addAddWaterResBean.getData().get(0).getData().get(position).getItems().size()==0
                ||addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0)==null
                ||addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).size()==0
                || NullUtil.isStrEmpty(addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).get(0))
                ){
            holder.getDownV().setVisibility(View.INVISIBLE);
            holder.getDownV().setEnabled(false);
        }else{
            holder.getDownV().setVisibility(View.VISIBLE);
            holder.getDownV().setEnabled(true);
            holder.getDownV().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View view = layoutInflater.inflate(R.layout.dialog_addaddwater_items, null);
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
                    final String[] strings = new String[addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).size()];
                   for(int i=0;i< addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).size();i++){
                       strings[i] = addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).get(i);
                   }
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.addItemDecoration(new MyItemDecoration2(context,2));
                    recyclerView.setAdapter(new DialogAdapter(context, strings));
                    ((DialogAdapter)recyclerView.getAdapter()).setOnAppItemClickListener(new OnAppItemClickListener() {
                        @Override
                        public void onAppItemClick(View view, int position) {
                            holder.getTxtET().setText(strings[position]);
                            DialogUtil.getInstance().dismiss();
                        }
                    });
                    DialogUtil.getInstance().showDialog(context, view,null);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return addAddWaterResBean==null?0:addAddWaterResBean.getData()==null?0:addAddWaterResBean.getData().get(0)==null?0:addAddWaterResBean.getData().get(0).getData()==null?0:addAddWaterResBean.getData().get(0).getData().size();
    }

    @Override
    public void onClick(View v) {

    }
}
