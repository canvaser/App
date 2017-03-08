package com.siweisoft.nurse.ui.check.patientcheck.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.nurse.ui.check.patientcheck.bean.PatAndTaskInfoResBean;
import com.siweisoft.nurse.ui.check.patientcheck.bean.PatientCheckHeadUIBean;
import com.siweisoft.nurse.ui.check.patientcheck.bean.PatientCheckUIBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-03-08.
 */

public class PatientCheckAdapter extends AppRecycleAdapter {


    List<AreaMessionListResBean.DataBean> taskInfo;

    OnAppItemClickListener itemClickListener;

    boolean show = false;

    public PatientCheckAdapter(Context context, List<AreaMessionListResBean.DataBean> taskInfo) {
        super(context);
        this.taskInfo = taskInfo;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PatientCheckUIBean(context, parent, R.layout.list_patientcheck);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PatientCheckUIBean checkUIBean = (PatientCheckUIBean) holder;
        checkUIBean.getTaskNameTV().setText(taskInfo.get(position).getTitles().get(0).getTaskname());
        checkUIBean.getTimeTV().setText(taskInfo.get(position).getTitles().get(0).getExectime());
        checkUIBean.itemView.setOnClickListener(this);
        checkUIBean.itemView.setTag(R.id.position, position);
        checkUIBean.itemView.setTag(R.id.data, taskInfo.get(position));
        checkUIBean.getCheckIV().setVisibility(View.GONE);
        checkUIBean.getGouIV().setVisibility(View.GONE);

        if (show) {
            checkUIBean.getCheckIV().setVisibility(View.VISIBLE);
            checkUIBean.getGouIV().setVisibility(View.GONE);
            if (taskInfo.get(position).getTitles().get(0).isSelect()) {
                checkUIBean.getCheckIV().setVisibility(View.GONE);
                checkUIBean.getGouIV().setVisibility(View.VISIBLE);
            } else {
                checkUIBean.getCheckIV().setVisibility(View.VISIBLE);
                checkUIBean.getGouIV().setVisibility(View.GONE);
            }
        } else {
            checkUIBean.getCheckIV().setVisibility(View.GONE);
            checkUIBean.getGouIV().setVisibility(View.GONE);
        }
        checkUIBean.getCheckIV().setOnClickListener(this);
        checkUIBean.getCheckIV().setTag(R.id.position, position);
        checkUIBean.getCheckIV().setTag(R.id.data, taskInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return taskInfo == null ? 0 : taskInfo.size();
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            itemClickListener.onAppItemClick(v, (Integer) v.getTag(R.id.position));
        }
    }

    public void setItemClickListener(OnAppItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
