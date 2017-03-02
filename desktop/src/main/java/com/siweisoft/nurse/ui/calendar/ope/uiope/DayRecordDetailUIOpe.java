package com.siweisoft.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.calendar.bean.netbean.DayBean;
import com.siweisoft.util.BitmapUtil;
import com.siweisoft.util.StringUtil;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class DayRecordDetailUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.et_addrecord)
    TextView txtET;


    @BindView(R.id.iv_image)
    ImageView imageIV;

    public DayRecordDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void loadData(DayBean d) {
        if (d == null) {
            return;
        }
        txtET.setText(StringUtil.getStr(d.getContent()));
        BitmapUtil.getInstance().setBg(context, imageIV, d.getImage() == null ? "" : d.getImage().getFileUrl());
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(imageIV);
        mAttacher.update();
    }

    public ImageView getImageIV() {
        return imageIV;
    }

    public TextView getTxtET() {
        return txtET;
    }
}
