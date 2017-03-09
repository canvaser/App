package com.siweisoft.app.ui.bed.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.bed.data.bean.adatperbean.DataAdapterBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class DataAdapter4 extends BaseExpandableListAdapter {


    Context context;
    LayoutInflater layoutInflater;

    ArrayList<View> containers;
    ArrayList<DataAdapterBean> list;


    public DataAdapter4(Context context, ArrayList<View> containers, ArrayList<DataAdapterBean> list) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.containers = containers;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return containers.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
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
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_data_head, parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_txt);
        textView.setText(list.get(groupPosition).getHead());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return containers.get(groupPosition);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
