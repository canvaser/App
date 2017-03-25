package com.summer.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.summer.app.R;
import com.summer.nurse.ui.base.ope.BaseNurseUIOpe;
import com.summer.nurse.ui.calendar.bean.netbean.DayBean;
import com.summer.util.BitmapUtil;
import com.summer.util.StringUtil;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class DayRecordDetailUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.et_addrecord)
    EditText txtET;


    @BindView(R.id.iv_image)
    ImageView imageIV;

    public DayRecordDetailUIOpe(Context context, View containerView) {
        super(context, containerView);
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("返回");
    }

    public void loadData(DayBean d) {
        if (d == null) {
            return;
        }
        txtET.setText(StringUtil.getStr(d.getContent()));
        BitmapUtil.getInstance().setBg(context, imageIV, d.getImage() == null ? "" : d.getImage().getFileUrl());
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(imageIV);
        mAttacher.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        mAttacher.update();
    }

    public ImageView getImageIV() {
        return imageIV;
    }

    public EditText getTxtET() {
        return txtET;
    }
}
