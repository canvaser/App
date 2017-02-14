package com.siweisoft.nurse.ui.home.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseOpe;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class HomeDataOpe extends BaseOpe{

     int index=0;
    public HomeDataOpe(Context context) {
        super(context);
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
