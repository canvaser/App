package com.siweisoft.lib.base.ui.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.lib.R;
import com.siweisoft.lib.R2;
import com.siweisoft.lib.uuzuche.lib_zxing.view.ViewfinderView;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-06-19.
 */
public class BaseUIWithTitleOpe extends BaseUIOpe{

    TextView backTV;

    TextView midTV;

    TextView rightTV;

    ImageView infoIV;

    public BaseUIWithTitleOpe(Context context, View containerView){
        super(context,containerView);
     backTV = (TextView) containerView.findViewById(R.id.ftv_back);
     midTV = (TextView) containerView.findViewById(R.id.ftv_title);
     rightTV = (TextView) containerView.findViewById(R.id.ftv_right);
     infoIV = (ImageView) containerView.findViewById(R.id.iv_info);
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
