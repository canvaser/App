package com.siweisoft.nurse.ui.info.checkbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.nurse.ui.check.checklist.bean.resbean.CheckResBean;
import com.siweisoft.nurse.ui.info.checkbook.bean.resbean.CheckBookResBean;
import com.siweisoft.nurse.ui.info.checkbook.bean.uibean.CheckBookUIBean;
import com.siweisoft.nurse.ui.info.infolist.bean.InfoListUIBean;
import com.siweisoft.util.BitmapUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckBookAdapter extends AppRecycleAdapter{


    OnAppItemClickListener onAppItemClickListener;


    ArrayList<CheckBookResBean> data ;
    public CheckBookAdapter(Context context,ArrayList<CheckBookResBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_checkbook,parent,false);
        CheckBookUIBean checkBookUIBean = new CheckBookUIBean(context,view);
        return checkBookUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CheckBookUIBean checkBookUIBean =(CheckBookUIBean) holder;
        checkBookUIBean.getNameTV().setText(data.get(position).getFilename());
        checkBookUIBean.getRootV().setOnClickListener(this);
        checkBookUIBean.getRootV().setTag(R.id.position,position);

    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if(onAppItemClickListener!=null){
            onAppItemClickListener.onAppItemClick(v,p);
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }
}
