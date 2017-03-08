package com.siweisoft.nurse.ui.info.checkbookdetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.siweisoft.app.R;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.check.checklist.bean.CheckHeadUIBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.resbean.CheckBookDetailItemsListResBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.uibean.CheckBookDetailHeadUIBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.uibean.CheckBookDetailUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckBookDetailListAdapter extends BaseExpandableListAdapter {


    Context context;

    LayoutInflater inflater;

    ArrayList<CheckBookDetailItemsListResBean> data;

    public CheckBookDetailListAdapter(Context context, ArrayList<CheckBookDetailItemsListResBean> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getItems().size();
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
        CheckBookDetailHeadUIBean checkHeadUIBean = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_head_checkbookdetail, parent, false);
            checkHeadUIBean = new CheckBookDetailHeadUIBean(context, convertView);
        }
        checkHeadUIBean = (CheckBookDetailHeadUIBean) convertView.getTag();
        checkHeadUIBean.getTimeTV().setText(StringUtil.getStr(data.get(groupPosition).getExectime()));
        checkHeadUIBean.getDuteTV().setText(StringUtil.getStr(data.get(groupPosition).getShift()));
        checkHeadUIBean.getNameTV().setText(StringUtil.getStr(data.get(groupPosition).getUsername()));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CheckBookDetailUIBean uiBean = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_checkbookdetail, null);
            uiBean = new CheckBookDetailUIBean(context, convertView);
        }
        uiBean = (CheckBookDetailUIBean) convertView.getTag();
        uiBean.getNameTV().setText(StringUtil.getStr(data.get(groupPosition).getItems().get(childPosition).getItemname()));
        uiBean.getNumTV().setText(StringUtil.getStr(data.get(groupPosition).getItems().get(childPosition).getValue()));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public ArrayList<CheckBookDetailItemsListResBean> getData() {
        return data;
    }
}
