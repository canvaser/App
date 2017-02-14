package com.siweisoft.base.ui.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.siweisoft.app.R;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-04-21.
 */
public class BaseUIBean  extends RecyclerView.ViewHolder implements Serializable{

    protected Context context;


    @Nullable
    @BindView(R.id.root)
    View rootV;

    public BaseUIBean(Context context, View convertView){
        super(convertView);
        this.context=context;
        convertView.setTag(this);
        ButterKnife.bind(this, convertView);
    }

    @Nullable
    public View getRootV() {
        return rootV;
    }
}
