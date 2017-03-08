package com.siweisoft.nurse.ui.document.document.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentDetailResBean;
import com.siweisoft.nurse.ui.document.document.bean.uibean.DocumentDetailUIBean;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentDetailListAdapter extends AppRecycleAdapter<DocumentDetailUIBean> {

    DocumentDetailResBean data;

    public DocumentDetailListAdapter(Context context, DocumentDetailResBean data) {
        super(context);
        this.data = data;
    }

    @Override
    public DocumentDetailUIBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DocumentDetailUIBean(context, parent, R.layout.list_documentdetaillist);
    }

    @Override
    public void onBindViewHolder(DocumentDetailUIBean holder, int position) {
        holder.getNameTV().setText(StringUtil.getStr(data.getData().get(0).getData().get(position).getTermname()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.getData() == null ? 0 : data.getData().get(0) == null ? 0 : data.getData().get(0).getData() == null ? 0 : data.getData().get(0).getData().size();
    }

    @Override
    public void onClick(View v) {

    }
}
