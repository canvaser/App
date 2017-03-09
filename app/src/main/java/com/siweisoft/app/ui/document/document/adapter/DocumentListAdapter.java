package com.siweisoft.app.ui.document.document.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.document.document.bean.uibean.DocumentBean;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.app.ui.document.document.bean.netbean.DocumentListResBean;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentListAdapter extends AppRecycleAdapter<DocumentBean> {

    DocumentListResBean data;

    OnAppItemClickListener onAppItemClickListener;

    public DocumentListAdapter(Context context, DocumentListResBean data) {
        super(context);
        this.data = data;
    }


    @Override
    public DocumentBean onCreateViewHolder(ViewGroup parent, int viewType) {
        DocumentBean documentBean = new DocumentBean(context, parent, R.layout.list_documentlist);
        // AnimUtil.getInstance().startAnim(context,documentBean.getRootV(),R.anim.anim_scale_in);
        return documentBean;
    }

    @Override
    public void onBindViewHolder(DocumentBean holder, int position) {
        holder.getNameTV().setText(StringUtil.getStr(data.getData().get(position).getTitle()));
        holder.getArrawIV().setVisibility(data.getData().get(position).isEnter() ? View.VISIBLE : View.GONE);
        holder.getRootV().setOnClickListener(this);
        holder.getRootV().setTag(R.id.data, data.getData().get(position));
        holder.getRootV().setTag(R.id.position, position);
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.getData() == null ? 0 : data.getData().size();
    }

    @Override
    public void onClick(View v) {
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, (Integer) v.getTag(R.id.position));
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    public DocumentListResBean getData() {
        return data;
    }
}
