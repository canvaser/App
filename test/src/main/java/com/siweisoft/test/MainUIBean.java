package com.siweisoft.test;

//by summer on 2017-03-25.

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.summer.lib.bean.BaseUIBean;

import butterknife.BindView;

public class MainUIBean extends BaseUIBean {


    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.toggleButton)
    ToggleButton toggleButton;
    @BindView(R.id.textView)
    TextView textView;

    public MainUIBean(Context context) {
        super(context, R.layout.frag_test);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public RatingBar getRatingBar() {
        return ratingBar;
    }

    public TextView getTextView() {
        return textView;
    }

    public ToggleButton getToggleButton() {
        return toggleButton;
    }
}
