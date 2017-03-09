package com.siweisoft.app.ui.bed.addmypatient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.bed.addmypatient.bean.AddMyPatientAdapterBean;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.app.ui.bed.addmypatient.bean.AddMyPatientUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientListAdapter extends AppRecycleAdapter {


    ArrayList<AddMyPatientAdapterBean> resBeen;

    OnAppItemClickListener onAppItemClickListener;

    public AddMyPatientListAdapter(Context context, ArrayList<AddMyPatientAdapterBean> resBeen) {
        super(context);
        this.resBeen = resBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_addmypatient, parent, false);
        AddMyPatientUIBean addMyPatientUIBean = new AddMyPatientUIBean(context, view);
        return addMyPatientUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AddMyPatientUIBean bean = (AddMyPatientUIBean) holder;
        bean.getNameTV().setText(StringUtil.getStr(resBeen.get(position).get姓名()));
        bean.getRootV().setSelected(resBeen.get(position).isSelect());
        bean.getSelectIV().setSelected(resBeen.get(position).isSelect());
        bean.getRootV().setOnClickListener(this);
        bean.getRootV().setTag(R.id.position, position);
    }

    @Override
    public int getItemCount() {
        return resBeen == null ? 0 : resBeen.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, position);
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }
}
