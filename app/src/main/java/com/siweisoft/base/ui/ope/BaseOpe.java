package com.siweisoft.base.ui.ope;

import android.content.Context;
import android.os.Handler;


/**
 * Created by ${viwmox} on 2016-07-07.
 */
public class BaseOpe {


    protected Context context;

    protected Handler handler=new Handler();


    public BaseOpe(Context context){
        this.context=context;
    }

    private BaseOpe(){

    }
}
