package com.siweisoft.nurse.ui.base.title;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siweisoft.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BackView extends RelativeLayout{

    @Nullable
    @BindView(R.id.tvt_title)
    TextView textView;

    public BackView(Context context) {
        super(context);
        init(context, null);
    }

    public BackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_title,null);
        addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ButterKnife.bind(this,this);

    }

    @Nullable
    public TextView getTextView() {
        return textView;
    }
}
