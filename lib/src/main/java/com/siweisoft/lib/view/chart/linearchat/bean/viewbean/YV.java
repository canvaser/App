package com.siweisoft.lib.view.chart.linearchat.bean.viewbean;


import com.siweisoft.lib.constant.ValueConstant;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class YV extends ChartItemBean {

    private int ply = ValueConstant.DIMEN_1 * 3;

    private int radous = ValueConstant.DIMEN_1 * 5;

    public int getPly() {
        return ply;
    }

    public void setPly(int ply) {
        this.ply = ply;
    }

    public int getRadous() {
        return radous;
    }

    public void setRadous(int radous) {
        this.radous = radous;
    }
}
