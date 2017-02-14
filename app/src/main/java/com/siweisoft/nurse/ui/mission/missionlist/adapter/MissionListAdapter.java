package com.siweisoft.nurse.ui.mission.missionlist.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.nurse.ui.mission.missionlist.bean.uibean.MissionHeadUIBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.uibean.MissionUIBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.util.BitmapUtil;
import com.siweisoft.util.StringUtil;
import com.siweisoft.util.data.DateFormatUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MissionListAdapter extends BaseExpandableListAdapter{


    Context context;

    LayoutInflater inflater;

    ArrayList<AreaMissionListAdapterBean> data;

    OnAppItemsClickListener onAppItemsClickListener;

    public MissionListAdapter(Context context,ArrayList<AreaMissionListAdapterBean> data) {
        this.context  = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public int getGroupCount() {
        return data ==null?0: data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data ==null?0: data.get(groupPosition).getData()==null?0: data.get(groupPosition).getData().size();
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
        MissionHeadUIBean missionHeadUIBean =null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.list_head_mission,null);
            missionHeadUIBean = new MissionHeadUIBean(context,convertView);
        }
        missionHeadUIBean = (MissionHeadUIBean) convertView.getTag();
        if(DateFormatUtil.isTodayMMDDHHMM(data.get(groupPosition).getYear(),data.get(groupPosition).getMonth(),data.get(groupPosition).getDay())){
            missionHeadUIBean.getTitleTV().setText("今日");
        }else{
            missionHeadUIBean.getTitleTV().setText(DateFormatUtil.getYYYYMMDD(data.get(groupPosition).getYear(),data.get(groupPosition).getMonth(),data.get(groupPosition).getDay()));
        }
        missionHeadUIBean.getStartTimeTV().setText(StringUtil.getStr((data.get(groupPosition).getHour())+":00"));
        missionHeadUIBean.getEndTimeTV().setText(StringUtil.getStr(data.get(groupPosition).getHour()+2)+":00");
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        MissionUIBean missionUIBean = null;
        if(convertView == null){
            convertView= inflater.inflate(R.layout.list_mission,null);
            missionUIBean = new MissionUIBean(context, convertView);
        }
        missionUIBean = (MissionUIBean) convertView.getTag();
        missionUIBean.getSwipeView().clear();
        missionUIBean.getTitleView().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getTitle()));
        missionUIBean.getBadIdTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getBedId()));
        missionUIBean.getNameTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getName()));
        missionUIBean.getTimeTV().setText(StringUtil.getStr(DateFormatUtil.getMMDDHHMM(data.get(groupPosition).getData().get(childPosition).getStart())));
        missionUIBean.getTaskNameTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getTaskname()));

        String timetype = "";
        if(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).get医嘱ID().toLowerCase().startsWith("cq")){
            timetype = "长期";
        }
        if(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).get医嘱ID().toLowerCase().startsWith("ls")){
            timetype = "临时";
        }

        if(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).get医嘱ID().toLowerCase().startsWith("hz")){
            if("st".equals(data.get(groupPosition).getData().get(childPosition).getTitles().get(0).getKey().toLowerCase())){
                timetype = "临时";
            }else{
                timetype = "长期";
            }
        }

        if(timetype.equals("临时")){
            missionUIBean.getLinTV().setText("临");
            missionUIBean.getLinTV().setTextColor(Color.parseColor("#A52A2A"));
        }

        if(timetype.equals("长期")) {
            missionUIBean.getLinTV().setText("长");
            missionUIBean.getLinTV().setTextColor(Color.parseColor("#7FFFD4"));
        }

        switch (data.get(groupPosition).getData().get(childPosition).getCodename()){
            case "出院带药":
            case "药品":
            case "输液":
                missionUIBean.getTitleView().setTextColor(R.color.light_blue);
                BitmapUtil.getInstance().setBg(context,missionUIBean.getCodenameIV(),R.drawable.icon_injecting);
                break;
            case "检查":
            case "化验":
                missionUIBean.getTitleView().setTextColor(R.color.light_blue);
                BitmapUtil.getInstance().setBg(context,missionUIBean.getCodenameIV(),R.drawable.icon_injecting);
                break;
            default:
                missionUIBean.getTitleView().setTextColor(R.color.black);
                BitmapUtil.getInstance().setBg(context,missionUIBean.getCodenameIV(),R.drawable.icon_medicine);
                break;
        }

        missionUIBean.getSwipeView().setOnAppClickListener(new OnAppItemClickListener() {
            @Override
            public void onAppItemClick(View view, int position) {
                if(onAppItemsClickListener!=null){
                    onAppItemsClickListener.onAppItemClick(groupPosition,view,childPosition);
                }
            }
        });
        return convertView;
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
