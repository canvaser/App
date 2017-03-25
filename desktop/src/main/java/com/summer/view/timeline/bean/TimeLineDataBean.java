package com.summer.view.timeline.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-28.
 */

public class TimeLineDataBean implements Serializable {

    ArrayList<CircleDraw> circleXYs;

    ArrayList<LineDraw> lineDraws;

    RedCricleDraw lastCircleDraw;

    InfoTxtDraw centerTxt;


    public TimeLineDataBean() {

    }

    public ArrayList<CircleDraw> getCircleXYs() {
        if (circleXYs == null) {
            circleXYs = new ArrayList<>();
        }
        return circleXYs;
    }

    public void createLineDraw() {


        for (int i = 0; i < circleXYs.size() - 1; i++) {
            CircleDraw left = new CircleDraw(circleXYs.get(i).getX(), circleXYs.get(i).getY(), circleXYs.get(i).getCirclePaint());
            CircleDraw right = new CircleDraw(circleXYs.get(i + 1).getX(), circleXYs.get(i + 1).getY(), circleXYs.get(i + 1).getCirclePaint());
            getLineDraws().add(new LineDraw(left, right));
        }

        for (int i = 0; i < getLineDraws().size(); i++) {
            if (getLineDraws().get(i).getLeftCircle().getX() < getLineDraws().get(i).getRightCircle().getX()) {
                getLineDraws().get(i).getLeftCircle().setY(getLineDraws().get(i).getLeftCircle().getY() - getLineDraws().get(i).getThick());
                getLineDraws().get(i).getRightCircle().setY(getLineDraws().get(i).getRightCircle().getY() + getLineDraws().get(i).getThick());
                getLineDraws().get(i).setDirect(LineDraw.direct_h);
            } else if (getLineDraws().get(i).getLeftCircle().getX() == getLineDraws().get(i).getRightCircle().getX()) {
                getLineDraws().get(i).getLeftCircle().setX(getLineDraws().get(i).getLeftCircle().getX() - getLineDraws().get(i).getThick());
                getLineDraws().get(i).getRightCircle().setX(getLineDraws().get(i).getRightCircle().getX() + getLineDraws().get(i).getThick());
                getLineDraws().get(i).setDirect(LineDraw.direct_v);
            } else {
                CircleDraw circleDraw = getLineDraws().get(i).getLeftCircle();
                getLineDraws().get(i).setLeftCircle(getLineDraws().get(i).getRightCircle());
                getLineDraws().get(i).setRightCircle(circleDraw);
                getLineDraws().get(i).getLeftCircle().setY(getLineDraws().get(i).getLeftCircle().getY() - getLineDraws().get(i).getThick());
                getLineDraws().get(i).getRightCircle().setY(getLineDraws().get(i).getRightCircle().getY() + getLineDraws().get(i).getThick());
                getLineDraws().get(i).setDirect(LineDraw.direct_h);
            }

        }


    }


    public void setCircleXYs(ArrayList<CircleDraw> circleXYs) {
        this.circleXYs = circleXYs;
    }

    public ArrayList<LineDraw> getLineDraws() {
        if (lineDraws == null) {
            lineDraws = new ArrayList<>();
        }
        return lineDraws;
    }

    public void setLineDraws(ArrayList<LineDraw> lineDraws) {
        this.lineDraws = lineDraws;
    }

    public RedCricleDraw getLastCircleDraw() {
        return lastCircleDraw;
    }

    public void setLastCircleDraw(RedCricleDraw lastCircleDraw) {
        this.lastCircleDraw = lastCircleDraw;
    }

    public InfoTxtDraw getCenterTxt() {
        if (centerTxt == null) {
            centerTxt = new InfoTxtDraw(0, 0);
        }
        return centerTxt;
    }

    public void setCenterTxt(InfoTxtDraw centerTxt) {
        this.centerTxt = centerTxt;
    }

}
