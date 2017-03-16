package com.siweisoft.app.ui.mission.missiondetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.app.nursevalue.DataValue;
import com.siweisoft.app.ui.mission.missiondetail.bean.MissionDetailListUIBean;
import com.siweisoft.app.ui.mission.missiondetail.bean.uibean.MissionDetailListUIBean2;

import java.util.List;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class MissionDetailListAdapter extends AppRecycleAdapter {

    OnAppItemClickListener onAppItemClickListener;

    List<AreaMessionListResBean.DataBean.TitlesBean> resBeen;

    AreaMessionDAOpe areaMessionDAOpe;

    public MissionDetailListAdapter(Context context, List<AreaMessionListResBean.DataBean.TitlesBean> resBeen) {
        super(context);
        this.resBeen = resBeen;
        areaMessionDAOpe = new AreaMessionDAOpe(context);
    }

    @Override
    public int getItemViewType(int position) {
        switch (resBeen.get(position).getStatus()) {
            case "F":
                return 0;
            default:
                return 1;

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = layoutInflater.inflate(R.layout.list_mission_detail_txt, parent, false);
                MissionDetailListUIBean missionDetailListUIBean = new MissionDetailListUIBean(context, view);
                return missionDetailListUIBean;
            default:
                View view2 = layoutInflater.inflate(R.layout.list_mission_detail_txt2, parent, false);
                MissionDetailListUIBean2 missionDetailListUIBean2 = new MissionDetailListUIBean2(context, view2);
                return missionDetailListUIBean2;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                MissionDetailListUIBean missionDetailListUIBean = (MissionDetailListUIBean) holder;
                missionDetailListUIBean.getTxtTV().setText(StringUtil.getStr(resBeen.get(position).getTitle()));
                missionDetailListUIBean.getTxtTV().setTag(R.id.position, position);
                missionDetailListUIBean.getDoneView().setTag(R.id.position, position);
                missionDetailListUIBean.getAbsentView().setTag(R.id.position, position);
                missionDetailListUIBean.getRefuseView().setTag(R.id.position, position);
                missionDetailListUIBean.getDeleteView().setTag(R.id.position, position);
                missionDetailListUIBean.getTxtTV().setOnClickListener(this);
                missionDetailListUIBean.getDoneView().setOnClickListener(this);
                missionDetailListUIBean.getAbsentView().setOnClickListener(this);
                missionDetailListUIBean.getRefuseView().setOnClickListener(this);
                missionDetailListUIBean.getDeleteView().setOnClickListener(this);
                break;
            default:

                MissionDetailListUIBean2 missionDetailListUIBean2 = (MissionDetailListUIBean2) holder;
                missionDetailListUIBean2.getNameView().setText(resBeen.get(position).get医嘱ID() + " " + resBeen.get(position).getDisplayname());
                missionDetailListUIBean2.getTitleTV().setText(resBeen.get(position).get医嘱ID() + " " + resBeen.get(position).getTitle());
                missionDetailListUIBean2.getPressView().setTag(R.id.position, position);
                missionDetailListUIBean2.getPressView().setOnClickListener(this);
                missionDetailListUIBean2.getCotainV().setTag(R.id.position, position);
                missionDetailListUIBean2.getStatusIV().setImageResource(areaMessionDAOpe.getStatusIcon(resBeen.get(position).getStatus())[0]);
                missionDetailListUIBean2.getStatusIV().setVisibility(areaMessionDAOpe.getStatusIcon(resBeen.get(position).getStatus())[1]);
                //missionDetailListUIBean2.getCotainV().setOnClickListener(this);
                switch (resBeen.get(position).getStatus()) {
                    case DataValue.STATUS_YI_SENG_HE:

                        break;
                    case DataValue.STATUS_WEI_ZHI_XING:

                        break;
                    case DataValue.STATUS_YI_WAN_CHENG:

                        break;
                    case DataValue.STATUS_BING_REN_BU_ZAI:

                        break;
                    case DataValue.STATUS_BING_REN_JU_JUE:

                        break;
                    case DataValue.SSTATUS_SHAN_CHU:

                        break;
                }
                break;
        }
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
