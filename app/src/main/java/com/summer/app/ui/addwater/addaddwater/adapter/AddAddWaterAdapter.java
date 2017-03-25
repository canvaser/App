package com.summer.app.ui.addwater.addaddwater.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.summer.lib.base.ui.adapter.AppRecycleAdapter;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.listener.BaseTextWather;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.lib.util.dialog.DialogUtil;
import com.summer.lib.view.ItemDecoration.MyItemDecoration2;
import com.summer.app.ui.addwater.addaddwater.bean.uibean.AddAddWaterUIBean;
import com.summer.app.ui.dialog.dialog.adapter.DialogAdapter;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterAdapter extends AppRecycleAdapter<AddAddWaterUIBean> {


    AddAddWaterResBean addAddWaterResBean;

    public static final int TYPE_DATE = 0;

    public static final int TYPE_TEXT = 1;

    public static final int TYPE_READONLY = 2;

    public static final int TYPE_REDIO = 3;

    public AddAddWaterAdapter(Context context, AddAddWaterResBean addAddWaterResBean) {
        super(context);
        this.addAddWaterResBean = addAddWaterResBean;
    }

    @Override
    public int getItemViewType(int position) {
        int type = TYPE_TEXT;
        switch (addAddWaterResBean.getData().get(0).getData().get(position).getType()) {
            case "date":
                type = TYPE_DATE;
                break;
            case "text":
                type = TYPE_TEXT;
                break;
            case "readonly":
                type = TYPE_READONLY;
                break;
            case "radio":
                type = TYPE_REDIO;
                break;
        }
        return type;
    }

    @Override
    public AddAddWaterUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_DATE:
                return new AddAddWaterUIBean(context, parent, R.layout.list_addaddwater_date);
            case TYPE_TEXT:
                return new AddAddWaterUIBean(context, parent, R.layout.list_addaddwater);
            case TYPE_READONLY:
                return new AddAddWaterUIBean(context, parent, R.layout.list_addaddwater_date);
            case TYPE_REDIO:
                return new AddAddWaterUIBean(context, parent, R.layout.list_addaddwater_date);

        }
        return new AddAddWaterUIBean(context, parent, R.layout.list_addaddwater);
    }

    @Override
    public void onBindViewHolder(final AddAddWaterUIBean holder, final int position) {
        holder.getNameTV().setText(StringUtil.getStr(addAddWaterResBean.getData().get(0).getData().get(position).getTermname()));
        if (holder.getTxtET() != null) {
            holder.getTxtET().setText(StringUtil.getStr(addAddWaterResBean.getData().get(0).getData().get(position).getValue()));
            switch (addAddWaterResBean.getData().get(0).getData().get(position).getValuetype()) {
                case "string":
                    holder.getTxtET().setType(InputType.TYPE_CLASS_TEXT);
                    break;
                case "int":
                    holder.getTxtET().setType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
                    break;
                case "float":
                    holder.getTxtET().setType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    break;
            }
            holder.getTxtET().addTextChangedListener(new BaseTextWather() {
                @Override
                public void afterTextChanged(Editable s) {
                    super.afterTextChanged(s);
                    addAddWaterResBean.getData().get(0).getData().get(position).setValue(s.toString());
                }
            });
        }
        if (holder.getTxtTV() != null) {
            holder.getTxtTV().setText(StringUtil.getStr(addAddWaterResBean.getData().get(0).getData().get(position).getValue()));
            holder.getTxtTV().addTextChangedListener(new BaseTextWather() {
                @Override
                public void afterTextChanged(Editable s) {
                    super.afterTextChanged(s);
                    addAddWaterResBean.getData().get(0).getData().get(position).setValue(s.toString());
                }
            });
        }
        switch (addAddWaterResBean.getData().get(0).getData().get(position).getTermname()) {
            case "时间":
                holder.getTxtTV().setText(DateFormatUtil.getnowTimeHHmm());
                //addAddWaterResBean.getData().get(0).getData().get(position).setValue(holder.getTxtET().getText().toString());
                break;
            case "补液内容":
                break;
            case "补液情况":
                if (addAddWaterResBean.getData().get(0).getData().get(position).getItems() != null &&
                        addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0) != null
                        && addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).size() > 0) {
                    holder.getTxtTV().setText(addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).get(0));
                    holder.getTxtTV().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            View view = layoutInflater.inflate(R.layout.dialog_addaddwater_items, null);
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
                            final String[] strings = new String[addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).size()];
                            for (int i = 0; i < addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).size(); i++) {
                                strings[i] = addAddWaterResBean.getData().get(0).getData().get(position).getItems().get(0).get(i);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(context));
                            recyclerView.addItemDecoration(new MyItemDecoration2(context, 2));
                            recyclerView.setAdapter(new DialogAdapter(context, strings));
                            ((DialogAdapter) recyclerView.getAdapter()).setOnAppItemClickListener(new OnAppItemClickListener() {
                                @Override
                                public void onAppItemClick(View view, int position) {
                                    holder.getTxtTV().setText(strings[position]);
                                    DialogUtil.getInstance().dismiss();
                                }
                            });
                            DialogUtil.getInstance().showDialog(context, view, null);
                        }
                    });
                }
                break;
            case "剩余补液量":
            case "速度":
                holder.getTxtET().setSubTxt(addAddWaterResBean.getData().get(0).getData().get(position).getSuffix());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return addAddWaterResBean == null ? 0 : addAddWaterResBean.getData() == null ? 0 : addAddWaterResBean.getData().get(0) == null ? 0 : addAddWaterResBean.getData().get(0).getData() == null ? 0 : addAddWaterResBean.getData().get(0).getData().size();
    }

    @Override
    public void onClick(View v) {

    }
}
