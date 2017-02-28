package com.siweisoft.lib.view.textview;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AppEditText extends EditText implements View.OnFocusChangeListener {

    Context context;

    String subTxt = "";

    int type = InputType.TYPE_NULL;


    public AppEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setInputType(type);
            setText(getText().toString().replace(subTxt, ""));
        } else {
            setInputType(InputType.TYPE_NULL);
            setText(getText().toString() + subTxt);
        }
    }

    public String getSubTxt() {
        return subTxt;
    }

    public void setSubTxt(String subTxt) {
        this.subTxt = subTxt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
