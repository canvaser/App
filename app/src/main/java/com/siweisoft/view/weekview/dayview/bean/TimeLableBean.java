package com.siweisoft.view.weekview.dayview.bean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-11-04.
 */
public class TimeLableBean extends BaseBean{

    public float textSize ;

    public int textColor;

    public String[] txt;

    public int width;

    public int height;

    public int getEachHeigh(){
        return (int)((float)height)/txt.length;
    }


}
