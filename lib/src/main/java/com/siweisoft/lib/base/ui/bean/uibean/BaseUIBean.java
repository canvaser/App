package com.siweisoft.lib.base.ui.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.siweisoft.lib.R;
import com.siweisoft.lib.R2;
import com.siweisoft.lib.uuzuche.lib_zxing.view.ViewfinderView;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-04-21.
 */
public class BaseUIBean extends RecyclerView.ViewHolder implements Serializable {

    protected Context context;


    View rootV;

    public BaseUIBean(Context context, View convertView) {
        super(convertView);
        this.context = context;
        itemView.setTag(this);
        rootV = itemView.findViewById(R.id.root);
        ButterKnife.bind(this, itemView);
    }

    public BaseUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(LayoutInflater.from(context).inflate(convertViewId, parent, false));
        this.context = context;
        itemView.setTag(this);
        rootV = itemView.findViewById(R.id.root);
        ButterKnife.bind(this, itemView);
    }

    @Nullable
    public View getRootV() {
        return rootV;
    }
}
