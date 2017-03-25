package com.summer.app.ui.addwater.addaddwater.bean.dabean;

import com.summer.lib.bean.databean.BaseDABean;

/**
 * Created by ${viwmox} on 2017-03-17.
 */

public class DishuDABean extends BaseDABean {

    private int index;

    private long time;

    private long[] s_e = new long[]{0, 0};


    public DishuDABean(int index, long start, long end) {
        this.index = index;
        s_e[0] = start;
        s_e[1] = end;
        time = s_e[1] - s_e[0];
    }

    public int getIndex() {
        return index;
    }

    public int getDisu() {
        return index - 1;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTime() {
        return s_e[1] - s_e[0];
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long[] getS_e() {
        return s_e;
    }
}
