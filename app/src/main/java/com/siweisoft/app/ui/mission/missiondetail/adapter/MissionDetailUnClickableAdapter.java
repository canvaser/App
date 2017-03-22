package com.siweisoft.app.ui.mission.missiondetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.mission.missiondetail.bean.uibean.MissionDetailUnclickUIBean;
import com.siweisoft.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-03-21.
 */

public class MissionDetailUnClickableAdapter extends AppRecycleAdapter<MissionDetailUnclickUIBean> {


    List<AreaMessionListResBean.DataBean.TitlesBean> data;

    AreaMessionDAOpe areaMessionDAOpe;

    public MissionDetailUnClickableAdapter(Context context, List<AreaMessionListResBean.DataBean.TitlesBean> data) {
        super(context);
        this.data = data;
        areaMessionDAOpe = new AreaMessionDAOpe(context);
    }


    @Override
    public MissionDetailUnclickUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MissionDetailUnclickUIBean(context, parent, R.layout.list_missiondetail_unclick);
    }

    @Override
    public void onBindViewHolder(MissionDetailUnclickUIBean holder, int position) {
        holder.getTvTxt().setText("任务Id：" + StringUtil.getStr(data.get(position).getId()) + " " + StringUtil.getStr(data.get(position).getExectime()));
        holder.getIvStatus().setImageResource(areaMessionDAOpe.getStatusIcon(data.get(position).getStatus())[0]);
        holder.getIvStatus().setVisibility(areaMessionDAOpe.getStatusIcon(data.get(position).getStatus())[1]);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {

    }
}
