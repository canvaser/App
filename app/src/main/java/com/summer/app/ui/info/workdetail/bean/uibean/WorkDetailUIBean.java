package com.summer.app.ui.info.workdetail.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailUIBean extends BaseUIBean {

    @BindView(R.id.tv_date)
    TextView dateTV;

    @BindView(R.id.tv_num)
    TextView numTV;

    @BindView(R.id.tv_works)
    TextView worksTV;

    public WorkDetailUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getDateTV() {
        return dateTV;
    }

    public void setDateTV(TextView dateTV) {
        this.dateTV = dateTV;
    }

    public TextView getNumTV() {
        return numTV;
    }

    public void setNumTV(TextView numTV) {
        this.numTV = numTV;
    }

    public TextView getWorksTV() {
        return worksTV;
    }

    public void setWorksTV(TextView worksTV) {
        this.worksTV = worksTV;
    }
}
