package com.siweisoft.nurse.ui.bed.advice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.MyMission.bean.uibean.MyMissionHeadUIBean;
import com.siweisoft.nurse.ui.bed.advice.bean.resbean.AdviceResBean;
import com.siweisoft.nurse.ui.bed.advice.bean.uibean.AdviceUIBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.uibean.MissionUIBean;
import com.siweisoft.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class AdviceListAdapter extends BaseExpandableListAdapter implements View.OnClickListener{


    Context context;

    LayoutInflater inflater;

    HashMap<String,ArrayList<AdviceResBean>> resBean;

    OnAppItemsClickListener onAppItemsClickListener;

    public AdviceListAdapter(Context context, HashMap<String,ArrayList<AdviceResBean>> resBean) {
        this.context  = context;
        inflater = LayoutInflater.from(context);
        this.resBean = resBean;
    }


    @Override
    public int getGroupCount() {
        return DataValue.STATUS_TYPE_TIME.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return resBean==null?0:resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition))==null?0:resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).size();
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
        MyMissionHeadUIBean myMissionHeadUIBean =null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.list_head_advice,null);
            myMissionHeadUIBean = new MyMissionHeadUIBean(context,convertView);
        }
        myMissionHeadUIBean = (MyMissionHeadUIBean) convertView.getTag();
        myMissionHeadUIBean.getTitleTV().setText(DataValue.STATUS_TYPE_TIME.get(groupPosition));
        myMissionHeadUIBean.getNumTV().setText(StringUtil.getStr(getChildrenCount(groupPosition)));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        AdviceUIBean adviceUIBean = null;
        if(convertView == null){
            convertView= inflater.inflate(R.layout.list_advice,null);
            adviceUIBean = new AdviceUIBean(context, convertView);
        }
        adviceUIBean = (AdviceUIBean) convertView.getTag();
        adviceUIBean.getTitleView().setText(StringUtil.getStr(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get医嘱详情s()));
        adviceUIBean.getRootV().setTag(R.id.position,childPosition);
        adviceUIBean.getRootV().setTag(R.id.groupposition,groupPosition);
        adviceUIBean.getRootV().setOnClickListener(this);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onClick(View v) {
        int g = (int) v.getTag(R.id.groupposition);
        int p = (int) v.getTag(R.id.position);
        if(onAppItemsClickListener!=null){
            onAppItemsClickListener.onAppItemClick(g,v,p);
        }
    }

    public void setOnAppItemsClickListener(OnAppItemsClickListener onAppItemsClickListener) {
        this.onAppItemsClickListener = onAppItemsClickListener;
    }
}
