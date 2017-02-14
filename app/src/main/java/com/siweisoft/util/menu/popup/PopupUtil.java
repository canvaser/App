package com.siweisoft.util.menu.popup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.util.ScreenUtil;

/**
 * Created by ${viwmox} on 2016-11-14.
 */
public class PopupUtil {

    private static  PopupUtil instance;

    private PopupWindow popupWindow;

    public static PopupUtil getInstance(){
        if(instance==null){
            instance = new PopupUtil();
        }
        return instance;
    }

    public void show(Context context,View view,View archerview){
        ScreenUtil.getInstance().getScreenSize(context);
        popupWindow = new PopupWindow(context);
        //popupWindow.setHeight((int) (ScreenUtil.w/2));
        popupWindow.setWidth(102* ValueConstant.DIMEN_1);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.popanimstyle);
//        popupWindow.getBackground().setAlpha(125);
        popupWindow.setContentView(view);
        popupWindow.showAsDropDown(archerview,(archerview.getWidth()-popupWindow.getWidth())/2,ValueConstant.DIMEN_1*5);
    }

    public void dimess(){
        if(popupWindow!=null){
            popupWindow.dismiss();
        }
    }
}
