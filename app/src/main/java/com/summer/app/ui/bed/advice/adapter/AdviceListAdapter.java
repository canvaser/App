package com.summer.app.ui.bed.advice.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.summer.app.R;
import com.summer.app.nursevalue.DataValue;
import com.summer.app.ui.bed.advice.bean.resbean.AdviceResBean;
import com.summer.app.ui.bed.advice.bean.uibean.AdviceUIBean;
import com.summer.app.ui.bed.persontask.bean.uibean.MyMissionHeadUIBean;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.util.BitmapUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.data.DateFormatUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class AdviceListAdapter extends BaseExpandableListAdapter implements View.OnClickListener {


    Context context;

    LayoutInflater inflater;

    HashMap<String, ArrayList<AdviceResBean>> resBean;

    OnAppItemsClickListener onAppItemsClickListener;

    AreaMessionDAOpe areaMessionDAOpe;

    public AdviceListAdapter(Context context, HashMap<String, ArrayList<AdviceResBean>> resBean) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.resBean = resBean;
        areaMessionDAOpe = new AreaMessionDAOpe(context);
    }


    @Override
    public int getGroupCount() {
        return DataValue.STATUS_TYPE_TIME.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return resBean == null ? 0 : resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)) == null ? 0 : resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).size();
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
        MyMissionHeadUIBean myMissionHeadUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_head_advice, null);
            myMissionHeadUIBean = new MyMissionHeadUIBean(context, convertView);
        }
        myMissionHeadUIBean = (MyMissionHeadUIBean) convertView.getTag();
        myMissionHeadUIBean.getTitleTV().setText(DataValue.STATUS_TYPE_TIME.get(groupPosition));
        myMissionHeadUIBean.getNumTV().setText(StringUtil.getStr(getChildrenCount(groupPosition)));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        AdviceUIBean adviceUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_advice, null);
            adviceUIBean = new AdviceUIBean(context, convertView);
        }
        adviceUIBean = (AdviceUIBean) convertView.getTag();
        adviceUIBean.getBeforeView().setVisibility(View.VISIBLE);
        adviceUIBean.getAfterView().setVisibility(View.GONE);
        int[] i = areaMessionDAOpe.isInJecting(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).getCodename());
        BitmapUtil.getInstance().setBg(context, adviceUIBean.getCodeNameIV(), i[1]);
        adviceUIBean.getTvTitle().setText(StringUtil.getStr(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get医嘱详情s()));
        adviceUIBean.getTypeTV().setText(StringUtil.getStr(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).getKey()));
        adviceUIBean.getStartTV().setText(StringUtil.getStr(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get开始时间()));
        adviceUIBean.getEndTV().setText(StringUtil.getStr(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get结束时间()));
        adviceUIBean.getNumTV().setText(StringUtil.getStr(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get医嘱IDs()));
        if (resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get医嘱详情s().contains("手术后医嘱")) {
            adviceUIBean.getBeforeView().setVisibility(View.GONE);
            adviceUIBean.getAfterView().setVisibility(View.VISIBLE);
        }
        if (DateFormatUtil.isTodayMMDDHHMM(resBean.get(DataValue.STATUS_TYPE_TIME.get(groupPosition)).get(childPosition).get开始时间s())) {
            adviceUIBean.getBeforeView().setBackgroundColor(Color.parseColor("#FFC1C1"));
        } else {
            adviceUIBean.getBeforeView().setBackgroundResource(R.drawable.drawable_press_black_while);
        }
        adviceUIBean.getRootV().setTag(R.id.position, childPosition);
        adviceUIBean.getRootV().setTag(R.id.groupposition, groupPosition);
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
        if (onAppItemsClickListener != null) {
            onAppItemsClickListener.onAppItemClick(g, v, p);
        }
    }

    public void setOnAppItemsClickListener(OnAppItemsClickListener onAppItemsClickListener) {
        this.onAppItemsClickListener = onAppItemsClickListener;
    }
}
