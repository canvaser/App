package com.siweisoft.ui.bed.data.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class DataHeadUIBean extends BaseUIBean {

    @BindView(R.id.tv_head_tem)
    TextView textView;

    public DataHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getTextView() {
        return textView;
    }
}
