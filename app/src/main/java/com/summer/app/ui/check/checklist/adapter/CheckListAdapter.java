package com.summer.app.ui.check.checklist.adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.summer.app.ui.check.checklist.bean.CheckHeadUIBean;
import com.summer.app.ui.check.checklist.bean.CheckUIBean;
import com.summer.app.ui.check.checklist.bean.resbean.CheckResBean;
import com.summer.app.ui.mission.missionlist.ope.AreaMessionDAOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckListAdapter extends BaseExpandableListAdapter {


    Context context;

    LayoutInflater inflater;

    ArrayList<CheckResBean> data;

    OnAppItemsClickListener onAppItemsClickListener;

    AreaMessionDAOpe areaMessionDAOpe;

    public CheckListAdapter(Context context, ArrayList<CheckResBean> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        areaMessionDAOpe = new AreaMessionDAOpe(context);
    }


    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getData().size();
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
        CheckHeadUIBean checkHeadUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_head_check, null);
            checkHeadUIBean = new CheckHeadUIBean(context, convertView);
        }
        checkHeadUIBean = (CheckHeadUIBean) convertView.getTag();
        checkHeadUIBean.getCountTV().setText("总数: " + StringUtil.getStr(data.get(groupPosition).getData().size()));
        checkHeadUIBean.getNameTV().setText(StringUtil.getStr(data.get(groupPosition).getItemName()));
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        CheckUIBean checkUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_check, null);
            checkUIBean = new CheckUIBean(context, convertView);
        }
        checkUIBean = (CheckUIBean) convertView.getTag();
        checkUIBean.getTaskNameTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTaskname()));
        checkUIBean.getTitleView().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getTitle()));
        checkUIBean.getNameTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getName()));
        checkUIBean.getTimeTV().setText(StringUtil.getStr(DateFormatUtil.getMMDDHHMM(data.get(groupPosition).getData().get(childPosition).getChecktime())));
        checkUIBean.getBadIdTV().setText(StringUtil.getStr(data.get(groupPosition).getData().get(childPosition).getBedId()));
        checkUIBean.getGou().setSelected(false);
        checkUIBean.getSwipeView().clear();

        if (areaMessionDAOpe.isLin(data.get(groupPosition).getData().get(childPosition).get医嘱ID(), data.get(groupPosition).getData().get(childPosition).getKey())) {
            checkUIBean.getLinTV().setText("临");
            checkUIBean.getLinTV().setSelected(true);
        } else {
            checkUIBean.getLinTV().setText("长");
            checkUIBean.getLinTV().setSelected(false);
        }

        int[] i = areaMessionDAOpe.isInJecting(data.get(groupPosition).getData().get(childPosition).getCodename());
        checkUIBean.getTitleView().setTextColor(i[0]);
        BitmapUtil.getInstance().setBg(context, checkUIBean.getCodeName(), i[1]);

        if (data.get(groupPosition).getData().get(childPosition).getCheckStatus().equals("T")) {
            checkUIBean.getLeftView().setBackgroundColor(Color.parseColor("#FFC1C1"));
            checkUIBean.getFinishTV().setText("取消核对");
        } else {
            checkUIBean.getLeftView().setBackgroundColor(Color.WHITE);
            checkUIBean.getFinishTV().setText("配药核对");
        }
        checkUIBean.getSwipeView().setOnAppClickListener(new OnAppItemClickListener() {
            @Override
            public void onAppItemClick(View view, int position) {
                if (onAppItemsClickListener != null) {
                    onAppItemsClickListener.onAppItemClick(groupPosition, view, childPosition);
                }
            }
        });
        convertView.setTag(R.id.position, childPosition);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public ArrayList<CheckResBean> getData() {
        return data;
    }

    public void setOnAppItemsClickListener(OnAppItemsClickListener onAppItemsClickListener) {
        this.onAppItemsClickListener = onAppItemsClickListener;
    }

}
