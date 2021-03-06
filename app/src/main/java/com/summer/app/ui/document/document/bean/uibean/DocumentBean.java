package com.summer.app.ui.document.document.bean.uibean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class DocumentBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.iv_arrow)
    ImageView arrawIV;

    public DocumentBean(Context context, View convertView) {
        super(context, convertView);
    }


    public DocumentBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public ImageView getArrawIV() {
        return arrawIV;
    }
}
