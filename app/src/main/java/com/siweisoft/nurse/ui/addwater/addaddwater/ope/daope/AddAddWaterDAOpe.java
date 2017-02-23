package com.siweisoft.nurse.ui.addwater.addaddwater.ope.daope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.AddAddWaterResBean;
import com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean.GetBylResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterDAOpe extends BaseDAOpe{

    AreaMessionResBean areaMessionResBean;

    AddAddWaterResBean addAddWaterResBean;

    GetBylResBean getBylResBean;

    int num = -1;

    int click = 0;

    long[] time = new long[]{0l,0l};

    public AddAddWaterDAOpe(Context context) {
        super(context);
    }

    public AreaMessionResBean getAreaMessionResBean() {
        return areaMessionResBean;
    }

    public void setAreaMessionResBean(AreaMessionResBean areaMessionResBean) {
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

    public void fillcontent(String value){
        for(int i=0;i<addAddWaterResBean.getData().get(0).getData().size();i++){
            if(addAddWaterResBean.getData().get(0).getData().get(i).getTermname().equals("补液内容")){
                addAddWaterResBean.getData().get(0).getData().get(i).setValue(value);
            }
        }
    }

    public void numPlus(){
        click++;
        if(click<=11){
            num++;
            if(num==0){
                time[0]=System.currentTimeMillis();
            }
            if(num==10){
                time[1]=System.currentTimeMillis();
            }
        }
    }

    public int getDisu(){
        float f = 600000l/(time[1]-time[0]);
        return Math.round(f);
    }

    public long[] getTime() {
        return time;
    }
}
