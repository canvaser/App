package com.siweisoft.base.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.siweisoft.app.R;

/**
 * Created by ${viwmox} on 2016-06-24.
 */
public class PopMenuView extends LinearLayout implements View.OnClickListener{


    public PopMenuView(Context context,int resId) {
        super(context);
        init(context, resId);
    }

    private void init(Context context, int resId){
        View view = LayoutInflater.from(context).inflate(resId, null);
        this.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.root);
        for(int i=0;i<viewGroup.getChildCount();i++){
            View view1 = viewGroup.getChildAt(i);
            view1.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
