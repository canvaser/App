package com.summer.app.ui.bed.persontask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.summer.app.R;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.base.ui.interf.view.OnAppItemsClickListener;
import com.summer.lib.util.BitmapUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.app.ui.bed.persontask.bean.uibean.MyMissionHeadUIBean;
import com.summer.app.ui.bed.persontask.bean.uibean.MyMissionUIBean;
import com.summer.app.ui.bed.persontask.ope.MyMissionStatusOpe;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.app.ui.mission.missionlist.bean.uibean.MissionUIBean;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class MyMissionListAdapter extends BaseExpandableListAdapter implements View.OnClickListener {


    Context context;

    LayoutInflater inflater;

    HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> list;


    OnAppItemsClickListener onAppItemsClickListener;

    AreaMessionDAOpe areaMessionDAOpe;


    public MyMissionListAdapter(Context context, HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
        areaMessionDAOpe = new AreaMessionDAOpe(context);
    }


    @Override
    public int getGroupCount() {
        return MyMissionStatusOpe.STATUS_LIST.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)) == null ? 0 : list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public AreaMessionListResBean.DataBean getChild(int groupPosition, int childPosition) {
        return list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition);
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
        MyMissionHeadUIBean missionHeadUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_head_mymission, parent, false);
            missionHeadUIBean = new MyMissionHeadUIBean(context, convertView);
        }
        missionHeadUIBean = (MyMissionHeadUIBean) convertView.getTag();
        missionHeadUIBean.getTitleTV().setText(MyMissionStatusOpe.STATUS_LIST_STR.get(groupPosition));
        if (MyMissionStatusOpe.STATUS_LIST_STR.get(groupPosition).equals("未完成")) {
            missionHeadUIBean.getItemV().setSelected(true);
        } else {
            missionHeadUIBean.getItemV().setSelected(false);
        }
        missionHeadUIBean.getNumTV().setText(StringUtil.getStr(getChildrenCount(groupPosition)));
        return convertView;
    }


    @Override
    public int getChildType(int groupPosition, int childPosition) {
        switch (MyMissionStatusOpe.STATUS_LIST_STR.get(groupPosition)) {
            case "已完成":
                return 0;
            default:
                return 1;
        }
    }

    @Override
    public int getChildTypeCount() {
        return 2;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        switch (getChildType(groupPosition, childPosition)) {
            case 0:
                MyMissionUIBean myMissionUIBean = null;
                if (convertView != null && convertView.getTag() instanceof MyMissionUIBean) {
                    myMissionUIBean = (MyMissionUIBean) convertView.getTag();
                } else {
                    convertView = inflater.inflate(R.layout.list_patient_mission, parent, false);
                    myMissionUIBean = new MyMissionUIBean(context, convertView);
                }
                myMissionUIBean = (MyMissionUIBean) convertView.getTag();
                myMissionUIBean.getTitleView().setText(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getTitle()));
                myMissionUIBean.getTimeTV().setText(DateFormatUtil.getMMDDHHMM(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getStart())).trim());
                myMissionUIBean.getTaskNameTV().setText(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getTaskname()));

                if (areaMessionDAOpe.isLin(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).get医嘱ID(), list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getKey())) {
                    Object[] o = areaMessionDAOpe.getLin(true);
                    myMissionUIBean.getLinTV().setText(o[0].toString());
                    myMissionUIBean.getLinTV().setTextColor((Integer) o[1]);
                } else {
                    Object[] o = areaMessionDAOpe.getLin(false);
                    myMissionUIBean.getLinTV().setText(o[0].toString());
                    myMissionUIBean.getLinTV().setTextColor((Integer) o[1]);
                }

                int[] i = areaMessionDAOpe.isInJecting(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getCodename());
                myMissionUIBean.getTitleView().setTextColor(i[0]);
                BitmapUtil.getInstance().setBg(context, myMissionUIBean.getCodenameIV(), i[1]);

                myMissionUIBean.getTypeTV().setText(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getKey()));
                myMissionUIBean.getArrowIV().setVisibility(areaMessionDAOpe.getStatusIcon(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getStatus())[1]);
                myMissionUIBean.getArrowIV().setImageResource(areaMessionDAOpe.getStatusIcon(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getStatus())[0]);
                myMissionUIBean.getRootV().setTag(R.id.position, childPosition);
                myMissionUIBean.getRootV().setTag(R.id.groupposition, groupPosition);
                myMissionUIBean.getRootV().setOnClickListener(this);
                break;
            default:
                MissionUIBean missionUIBean = null;
                if (convertView != null && convertView.getTag() instanceof MissionUIBean) {
                    missionUIBean = (MissionUIBean) convertView.getTag();
                } else {
                    convertView = inflater.inflate(R.layout.list_patient_mission_not, parent, false);
                    missionUIBean = new MissionUIBean(context, convertView);
                }
                missionUIBean = (MissionUIBean) convertView.getTag();
                missionUIBean.getTitleView().setText(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getTitle()));
                missionUIBean.getTimeTV().setText(DateFormatUtil.getMMDDHHMM(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getStart())));
                missionUIBean.getTaskNameTV().setText(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getTaskname()));

                if (areaMessionDAOpe.isLin(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).get医嘱ID(), list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getKey())) {
                    Object[] o = areaMessionDAOpe.getLin(true);
                    missionUIBean.getLinTV().setText(o[0].toString());
                    missionUIBean.getLinTV().setTextColor((Integer) o[1]);
                } else {
                    Object[] o = areaMessionDAOpe.getLin(false);
                    missionUIBean.getLinTV().setText(o[0].toString());
                    missionUIBean.getLinTV().setTextColor((Integer) o[1]);
                }

                int[] j = areaMessionDAOpe.isInJecting(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getCodename());
                missionUIBean.getTitleView().setTextColor(j[0]);
                BitmapUtil.getInstance().setBg(context, missionUIBean.getCodenameIV(), j[1]);

                missionUIBean.getKeyTV().setText(StringUtil.getStr(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getKey()));
                missionUIBean.getArrowIV().setVisibility(areaMessionDAOpe.getStatusIcon(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getStatus())[1]);
                missionUIBean.getArrowIV().setImageResource(areaMessionDAOpe.getStatusIcon(list.get(MyMissionStatusOpe.STATUS_LIST.get(groupPosition)).get(childPosition).getTitles().get(0).getStatus())[0]);
                missionUIBean.getSwipeView().setOnAppClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        if (onAppItemsClickListener != null) {
                            onAppItemsClickListener.onAppItemClick(groupPosition, view, childPosition);
                        }
                    }
                });
                switch (MyMissionStatusOpe.STATUS_LIST_STR.get(groupPosition)) {
                    case "病人拒绝":
                        missionUIBean.getArrowIV().setVisibility(View.VISIBLE);
                        missionUIBean.getArrowIV().setImageResource(R.drawable.icon_refuse);
                        break;
                }
                break;
        }
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

    public HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> getList() {
        return list;
    }
}
