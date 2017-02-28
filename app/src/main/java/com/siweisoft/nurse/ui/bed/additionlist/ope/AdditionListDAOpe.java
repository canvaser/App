package com.siweisoft.nurse.ui.bed.additionlist.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.nurse.ui.home.bean.resbean.AdditionResbean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditionListDAOpe extends BaseOpe {


    public AdditionListDAOpe(Context context) {
        super(context);
    }

    public String getData(ArrayList<AdditionResbean> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelect()) {
                str += list.get(i).getCode();
                str += ",";
            }
        }
        if (str.lastIndexOf(",") != -1) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
