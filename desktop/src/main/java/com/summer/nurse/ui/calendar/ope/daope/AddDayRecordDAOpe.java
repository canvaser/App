package com.summer.nurse.ui.calendar.ope.daope;

import android.content.Context;
import android.net.Uri;

import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.nurse.ui.image.bean.dabean.PicBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class AddDayRecordDAOpe extends BaseDAOpe {


    private Uri url;

    ArrayList<PicBean> picBeen;

    public AddDayRecordDAOpe(Context context) {
        super(context);
    }

    public Uri getUrl() {
        return url;
    }

    public void setUrl(Uri url) {
        this.url = url;
    }

    public ArrayList<PicBean> getPicBeen() {
        return picBeen;
    }

    public void setPicBeen(ArrayList<PicBean> picBeen) {
        this.picBeen = picBeen;
    }
}
