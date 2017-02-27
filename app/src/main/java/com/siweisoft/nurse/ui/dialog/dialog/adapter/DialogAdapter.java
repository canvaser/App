package com.siweisoft.nurse.ui.dialog.dialog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.base.ui.bean.uibean.PupListUIBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class DialogAdapter extends AppRecycleAdapter{

    String[] strings;

    OnAppItemClickListener onAppItemClickListener;

    public DialogAdapter(Context context, String[] strings) {
        super(context);
        this.strings =strings;
    }


    ArrayList<String> ss = new ArrayList<>();
    public DialogAdapter(Context context,ArrayList<String> ss) {
        super(context);
        strings = new String[ss.size()];
        strings  =ss.toArray(strings);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_pop,parent,false);
        PupListUIBean pupListUIBean = new PupListUIBean(context,view);
        return pupListUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PupListUIBean pupListUIBean = (PupListUIBean) holder;
        pupListUIBean.getTextView().setText(StringUtil.getStr(strings[position]));
        pupListUIBean.getTextView().setTag(R.id.position,position);
        pupListUIBean.getTextView().setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return strings==null?0:strings.length;
    }



    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    @Override
    public void onClick(View v) {
        int position  = (int) v.getTag(R.id.position);
        if(onAppItemClickListener!=null){
            onAppItemClickListener.onAppItemClick(v,position);
        }
    }
}
