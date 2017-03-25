package com.summer.app.ui.addwater.addaddwater.ope.daope;

import android.content.Context;

import com.summer.app.ui.addwater.addaddwater.bean.dabean.DishuDABean;
import com.summer.app.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.summer.app.ui.addwater.addaddwater.bean.netbean.GetBylResBean;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.lib.base.ui.ope.BaseDAOpe;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterDAOpe extends BaseDAOpe {

    AreaMessionListResBean.DataBean areaMessionResBean;

    AddAddWaterResBean addAddWaterResBean;

    GetBylResBean getBylResBean;

    int num = -1;


    long[] time = new long[]{0l, 0l};


    int click = 0;


    ArrayList<DishuDABean> dishuList = new ArrayList<>();


    public static final int TYPE_DATE = 0;
    public static final int TYPE_TEXT = 1;

    public AddAddWaterDAOpe(Context context) {
        super(context);
    }

    public AreaMessionListResBean.DataBean getAreaMessionResBean() {
        return areaMessionResBean;
    }

    public void setAreaMessionResBean(AreaMessionListResBean.DataBean areaMessionResBean) {
        this.areaMessionResBean = areaMessionResBean;
    }

    public AddAddWaterResBean getAddAddWaterResBean() {
        return addAddWaterResBean;
    }

    public void setAddAddWaterResBean(AddAddWaterResBean addAddWaterResBean) {
        this.addAddWaterResBean = addAddWaterResBean;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public GetBylResBean getGetBylResBean() {
        return getBylResBean;
    }

    public void setGetBylResBean(GetBylResBean getBylResBean) {
        this.getBylResBean = getBylResBean;
    }

    public void fillcontent(String value) {
        for (int i = 0; i < addAddWaterResBean.getData().get(0).getData().size(); i++) {
            if (addAddWaterResBean.getData().get(0).getData().get(i).getTermname().equals("补液内容")) {
                addAddWaterResBean.getData().get(0).getData().get(i).setValue(value);
            }
        }
    }

    public void fillDisu(String value) {
        for (int i = 0; i < addAddWaterResBean.getData().get(0).getData().size(); i++) {
            if (addAddWaterResBean.getData().get(0).getData().get(i).getTermname().contains("速度") || addAddWaterResBean.getData().get(0).getData().get(i).getTermname().contains("滴速")) {
                addAddWaterResBean.getData().get(0).getData().get(i).setValue(value);
            }
        }
    }


    public void clearDisu() {
        for (int i = 0; i < addAddWaterResBean.getData().get(0).getData().size(); i++) {
            if (addAddWaterResBean.getData().get(0).getData().get(i).getTermname().trim().contains("速度")) {
                addAddWaterResBean.getData().get(0).getData().get(i).setValue("");
            }
        }
    }


    public void numPlus() {
        click++;
        if (click <= 11) {
            num++;
            if (num == 0) {
                time[0] = System.currentTimeMillis();
            }
            if (num == 10) {
                time[1] = System.currentTimeMillis();
            }
        }
    }

    public int getDisu() {
        float f = 600000l / (time[1] - time[0]);
        return Math.round(f);
    }

    public long[] getTime() {
        return time;
    }


    long t = 0;

    long clicktime = 0;

    int clicknum = 0;

    int allnum = 10;

    public int click() {
        clicknum++;
        if ((clicknum - 1) > allnum) {
            return getDishuList().size();
        }
        if (clicknum == 1) {
            clicktime = System.currentTimeMillis();
        }

        DishuDABean dishuDABean = new DishuDABean(clicknum, clicktime, System.currentTimeMillis());
        clicktime = System.currentTimeMillis();
        getDishuList().add(dishuDABean);


        return getDishuList().size();
    }

    public void clear() {
        clicknum = 0;
        clicktime = 0;
        getDishuList().clear();
    }

    public boolean finish() {
        if ((getDishuList().size() - 1) >= allnum) {
            return true;
        }
        return false;
    }


    public long getSudu() {
        ArrayList<DishuDABean> list = new ArrayList<>();
        for (int i = 0; i < getDishuList().size(); i++) {
            list.add(new DishuDABean(getDishuList().get(i).getIndex(), getDishuList().get(i).getS_e()[0], getDishuList().get(i).getS_e()[1]));
        }
        list.remove(0);
        Collections.sort(list, new DiSuTimeSort());
        list.remove(0);
        list.remove(list.size() - 1);
        long l = 0;
        for (int i = 0; i < list.size(); i++) {
            l += list.get(i).getTime();
        }
        return 60 * 1000 * (list.size()) / l;
    }

    public long getAllTime() {
        return getDishuList().get(getDishuList().size() - 1).getS_e()[1] - getDishuList().get(0).getS_e()[0];
    }


    public ArrayList<DishuDABean> getDishuList() {
        return dishuList;
    }

    public int getAllnum() {
        return allnum;
    }

    public void setAllnum(int allnum) {
        this.allnum = allnum;
    }

}
