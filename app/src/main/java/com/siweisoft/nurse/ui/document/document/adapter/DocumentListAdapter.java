package com.siweisoft.nurse.ui.document.document.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListResBean;
import com.siweisoft.nurse.ui.document.document.bean.uibean.DocumentBean;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentListAdapter extends AppRecycleAdapter<DocumentBean>{

    DocumentListResBean data;

    public DocumentListAdapter(Context context,DocumentListResBean data) {
        super(context);
        this.data =data;
    }


    @Override
    public DocumentBean onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DocumentBean(context, parent,R.layout.list_documentlist);
    }

    @Override
    public void onBindViewHolder(DocumentBean holder, int position) {
        holder.getNameTV().setText(StringUtil.getStr(data.getData().get(position).getTitle()));
    }


    @Override
    public int getItemCount() {
        return data==null?0:data.getData()==null?0:data.getData().size();
    }

    @Override
    public void onClick(View v) {

    }
}
