package com.siweisoft.base.ui.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-06-19.
 */
public class BaseUIWithTitleOpe extends BaseUIOpe{

   @Nullable
    @BindView(R.id.ftv_back)
    TextView backTV;


    @Nullable
    @BindView(R.id.ftv_title)
    TextView midTV;


    @Nullable
    @BindView(R.id.ftv_right)
    TextView rightTV;

    @Nullable
    @BindView(R.id.iv_info)
    ImageView infoIV;

    public BaseUIWithTitleOpe(Context context, View containerView){
        super(context,containerView);
    }

    @Nullable
    public TextView getBackTV() {
        return backTV;
    }

    @Nullable
    public TextView getMidTV() {
        return midTV;
    }

    @Nullable
    public TextView getRightTV() {
        return rightTV;
    }

    @Nullable
    public ImageView getInfoIV() {
        return infoIV;
    }
}
