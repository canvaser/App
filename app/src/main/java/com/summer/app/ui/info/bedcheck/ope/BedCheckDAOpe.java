package com.summer.app.ui.info.bedcheck.ope;

import android.content.Context;

import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ui.info.bedcheck.bean.resbean.BedCheckResBean;
import com.summer.lib.base.ui.ope.BaseOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-13.
 */
public class BedCheckDAOpe extends BaseOpe {

    ArrayList<BedCheckResBean> data;

    private int position = 0;


    public BedCheckDAOpe(Context context) {
        super(context);
    }

    public ArrayList<BedCheckResBean> getData() {
        return data;
    }

    public void setData(ArrayList<BedCheckResBean> data) {
        this.data = data;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<BedCheckResBean> getSelectData() {
        ArrayList<BedCheckResBean> l = new ArrayList<>();
        String disname = MethodValue.getUserInfo(context).getData().getUser().getDisplayname();
        switch (position) {
            case 1:
                return data;
            case 0:
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getDisplayname().equals(disname)) {
                        l.add(data.get(i));
                    }
                }
                return l;
        }
        return data;
    }
}
