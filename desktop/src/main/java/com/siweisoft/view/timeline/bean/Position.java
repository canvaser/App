package com.siweisoft.view.timeline.bean;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2016-12-28.
 */

public class Position implements Serializable {

    private int x;

    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
