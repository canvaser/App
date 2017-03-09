package com.siweisoft.ui.info.addcheckbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;
import com.siweisoft.lib.base.ui.listener.BaseTextWather;
import com.siweisoft.lib.util.SheetDialogUtil;
import com.siweisoft.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.ui.info.addcheckbook.bean.uibean.AddCheckBookHeadUIBean;
import com.siweisoft.ui.info.addcheckbook.bean.uibean.AddCheckBookUIBean;
import com.siweisoft.ui.info.checkbook.bean.resbean.CheckItemResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class AddCheckBookListAdapter extends AppRecycleAdapter {


    ArrayList<CheckItemResBean> data;

    String[] strings = new String[]{"早早班", "早班", "两头班(早)", "大夜班", "小夜班", "两头班"};


    public AddCheckBookListAdapter(Context context, ArrayList<CheckItemResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseUIBean baseUIBean = null;
        switch (viewType) {
            case 0:
                View view = layoutInflater.inflate(R.layout.list_head_addcheckbook, null);
                baseUIBean = new AddCheckBookHeadUIBean(context, view);
                break;
            case 1:
                View view1 = layoutInflater.inflate(R.layout.list_addcheckbook, null);
                baseUIBean = new AddCheckBookUIBean(context, view1);
                break;
        }

        return baseUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case 0:
                final AddCheckBookHeadUIBean addCheckBookHeadUIBean = (AddCheckBookHeadUIBean) holder;
                addCheckBookHeadUIBean.getNameTV().setText(data.get(position).getItemname());
                addCheckBookHeadUIBean.getValueETV().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(context, strings);
                        SheetDialogUtil.getInstance().showBottomSheet(context, bottomDialogMenuView, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TextView textView = (TextView) v;
                                addCheckBookHeadUIBean.getValueETV().setText(textView.getText());
                                data.get(position).setValue(textView.getText().toString());
                                SheetDialogUtil.getInstance().dismess();
                            }
                        });
                    }
                });
                break;
            case 1:
                AddCheckBookUIBean addCheckBookUIBean = (AddCheckBookUIBean) holder;
                addCheckBookUIBean.getNameTV().setText(data.get(position).getItemname());
                addCheckBookUIBean.getValueETV().setText(data.get(position).getValue());
                addCheckBookUIBean.getValueETV().addTextChangedListener(new BaseTextWather() {
                    @Override
                    public void afterTextChanged(Editable s) {
                        data.get(position).setValue(s.toString());
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
