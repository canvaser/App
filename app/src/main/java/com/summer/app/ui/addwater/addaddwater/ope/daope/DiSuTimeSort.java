package com.summer.app.ui.addwater.addaddwater.ope.daope;

import com.summer.app.ui.addwater.addaddwater.bean.dabean.DishuDABean;

import java.util.Comparator;

/**
 * Created by ${viwmox} on 2017-03-17.
 */

public class DiSuTimeSort implements Comparator<DishuDABean> {
    @Override
    public int compare(DishuDABean o1, DishuDABean o2) {
        if (o1.getTime() > o2.getTime()) {
            return 1;
        } else if (o1.getTime() == o2.getTime()) {
            return 0;
        }
        return -1;
    }
}
