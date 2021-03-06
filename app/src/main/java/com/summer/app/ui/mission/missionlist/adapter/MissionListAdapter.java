package com.summer.app.ui.mission.missionlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.summer.app.R;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.util.BitmapUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.app.ui.mission.missionlist.bean.uibean.MissionHeadUIBean;
import com.summer.app.ui.mission.missionlist.bean.uibean.MissionUIBean;
import com.summer.app.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListAdapter extends BaseExpandableListAdapter {


    Context context;

    LayoutInflater inflater;

    ArrayList<AreaMissionListAdapterBean> data;

    OnAppItemsClickListener onAppItemsClickListener;

    AreaMessionDAOpe areaMessionDAOpe;

    public MissionListAdapter(Context context, ArrayList<AreaMissionListAdapterBean> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        areaMessionDAOpe = new AreaMessionDAOpe(context);
    }


    @Override
    public int getGroupCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data == null ? 0 : data.get(groupPosition).getData() == null ? 0 : data.get(groupPosition).getData().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 11;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 10;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        MissionHeadUIBean missionHeadUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_head_mission, null);
            missionHeadUIBean = new MissionHeadUIBean(context, convertView);
        }
        missionHeadUIBean = (MissionHeadUIBean) convertView.getTag();
        if (DateFormatUtil.isTodayMMDDHHMM(data.get(groupPosition).getYear(), data.get(groupPosition).getMonth(), data.get(groupPosition).getDay())) {
            missionHeadUIBean.getTitleTV().setText("今日");
        } else {
            missionHeadUIBean.getTitleTV().setText(DateFormatUtil.getYYYYMMDD(data.get(groupPosition).getYear(), data.get(groupPosition).getMonth(), data.get(groupPosition).getDay()));
        }
        missionHeadUIBean.getStartTimeTV().setText(StringUtil.getStr((data.get(groupPosition).getHour()) + ":00"));
        missionHeadUIBean.getEndTimeTV().setText(StringUtil.getStr(data.get(groupPosition).getHour() + 2) + ":00");
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        MissionUIBean missionUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_mission, null);
            missionUIBean = new MissionUIBean(context, convertView);
        }
        missionUIBean = (MissionUIBean) convertView.getTag();
        missionUIBean.getSwipeView().clear();
        missionUIBean.getTitleView().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getTitle()));
        missionUIBean.getBadIdTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getBedId()));
        missionUIBean.getNameTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getName()));
        missionUIBean.getTimeTV().setText(StringUtil.getStr(DateFormatUtil.getMMDDHHMM(data.get(groupPosition).getData().get(childPosition).getStart())));
        missionUIBean.getTaskNameTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getTaskname()));
        missionUIBean.getNumTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitles().size() == 1 ? "" : data.get(groupPosition).getData().get(childPosition).getTitles().size()));
        //missionUIBean.getKeyTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getKey()));
        missionUIBean.getArrowIV().setVisibility(areaMessionDAOpe.getStatusIcon(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getStatus())[1]);
        missionUIBean.getArrowIV().setImageResource(areaMessionDAOpe.getStatusIcon(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getStatus())[0]);

        if (areaMessionDAOpe.isLin(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).get医嘱ID(), data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getKey())) {
            Object[] o = areaMessionDAOpe.getLin(true);
            missionUIBean.getLinTV().setText(o[0].toString());
            missionUIBean.getLinTV().setTextColor((Integer) o[1]);
        } else {
            Object[] o = areaMessionDAOpe.getLin(false);
            missionUIBean.getLinTV().setText(o[0].toString());
            missionUIBean.getLinTV().setTextColor((Integer) o[1]);
        }

        int[] i = areaMessionDAOpe.isInJecting(data.get(groupPosition).getData().get(childPosition).getCodename());
        missionUIBean.getTitleView().setTextColor(i[0]);
        BitmapUtil.getInstance().setBg(context, missionUIBean.getCodenameIV(), i[1]);

        missionUIBean.getSwipeView().setOnAppClickListener(new OnAppItemClickListener() {
            @Override
            public void onAppItemClick(View view, int position) {
                if (onAppItemsClickListener != null) {
                    onAppItemsClickListener.onAppItemClick(groupPosition, view, childPosition);
                }
            }
        });
        return convertView;
    }

    public void setData(ArrayList<AreaMissionListAdapterBean> data) {
        this.data = data;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public ArrayList<AreaMissionListAdapterBean> getData() {
        return data;
    }

    public void setOnAppItemsClickListener(OnAppItemsClickListener onAppItemsClickListener) {
        this.onAppItemsClickListener = onAppItemsClickListener;
    }
}
