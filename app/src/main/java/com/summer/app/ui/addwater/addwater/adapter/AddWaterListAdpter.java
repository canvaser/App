package com.summer.app.ui.addwater.addwater.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.summer.app.ui.addwater.addwater.bean.uibean.AddWaterListHeadUIBean;
import com.summer.app.ui.addwater.addwater.bean.uibean.AddWaterListItemUIBean;
import com.summer.lib.base.ui.adapter.AppBaseExpandableListAdapter;
import com.summer.lib.util.StringUtil;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterListAdpter extends AppBaseExpandableListAdapter {

    AddWaterListResBean addWaterListResBean;

    public AddWaterListAdpter(Context context, AddWaterListResBean addWaterListResBean) {
        super(context);
        this.addWaterListResBean = addWaterListResBean;
    }


    @Override
    public int getGroupCount() {
        return addWaterListResBean == null ? 0 : addWaterListResBean.getData() == null ? 0 : addWaterListResBean.getData().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return addWaterListResBean == null ? 0 : addWaterListResBean.getData() == null ? 0 : addWaterListResBean.getData().get(groupPosition).getFiles() == null ? 0 : addWaterListResBean.getData().get(groupPosition).getFiles().size();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            AddWaterListHeadUIBean headUIBean = new AddWaterListHeadUIBean(context, parent, R.layout.list_head_addwater);
            convertView = headUIBean.itemView;
        }
        AddWaterListHeadUIBean headUIBean = (AddWaterListHeadUIBean) convertView.getTag();
        headUIBean.getNameTV().setText(addWaterListResBean.getData().get(groupPosition).getAdvCon() + addWaterListResBean.getData().get(groupPosition).getStart());
        return headUIBean.itemView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            AddWaterListItemUIBean headUIBean = new AddWaterListItemUIBean(context, parent, R.layout.list_item_addwater);
            convertView = headUIBean.itemView;
        }
        AddWaterListItemUIBean headUIBean = (AddWaterListItemUIBean) convertView.getTag();
        headUIBean.getTimeTV().setText(StringUtil.getStr(
                addWaterListResBean.getData().get(groupPosition).getFiles() == null ? "" :
                        addWaterListResBean.getData().get(groupPosition).getFiles().size() == 0 ? "" :
                                addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition) == null ? "" :
                                        addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).size() == 0 ? "" :
                                                addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).get(0) == null ? "" : addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).get(0).getTermname() + " " + addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).get(0).getValue()));
        headUIBean.getNameTV().setText("补液护士：" + StringUtil.getStr(addWaterListResBean.getData().get(groupPosition).getFiles() == null ? "" :
                addWaterListResBean.getData().get(groupPosition).getFiles().size() == 0 ? "" :
                        addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition) == null ? "" :
                                addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).size() == 0 ? "" :
                                        addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).get(0) == null ? "" : addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition).get(0).getUser_name()));
        headUIBean.itemView.setOnClickListener(this);
        headUIBean.itemView.setTag(R.id.groupposition, groupPosition);
        headUIBean.itemView.setTag(R.id.childposition, childPosition);
        headUIBean.itemView.setTag(R.id.data, addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition));
        return headUIBean.itemView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return addWaterListResBean.getData().get(groupPosition).getFiles().get(childPosition);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (onAppItemsClickListener != null) {
            onAppItemsClickListener.onAppItemClick((int) v.getTag(R.id.groupposition), v, (int) v.getTag(R.id.childposition));
        }
    }
}
