package com.summer.app.ui.check.checklist.ope;

import android.os.AsyncTask;

import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ui.check.checklist.bean.bean.TitleBean;
import com.summer.app.ui.check.checklist.bean.resbean.CheckDataResBean;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;
import com.summer.app.ui.check.checklist.bean.resbean.CheckResBean;
import com.summer.lib.base.ui.interf.OnFinishListener;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class CheckDAOpe {

    private int position = 0;

    ArrayList<TitleBean> titles = new ArrayList<>();

    private String sort = "全部";

    ArrayList<CheckResBean> res;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<TitleBean> getTitles() {
        return titles;
    }

    public ArrayList<CheckResBean> initData(ArrayList<CheckResBean> res) {
        GetallregionbyuserResBean.Data data = MethodValue.getArea();
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).getData().size(); j++) {
                String bedid = res.get(i).getData().get(j).getBedId();
                res.get(i).getData().get(j).setBedId(data.getWardname() + bedid.substring(2, bedid.length()) + "床");
            }
        }
        return res;
    }


    public void initData2(final OnFinishListener onFinishListener) {
        new AsyncTask<String, String, ArrayList<CheckResBean>>() {
            @Override
            protected ArrayList<CheckResBean> doInBackground(String... params) {
                GetallregionbyuserResBean.Data data = MethodValue.getArea();
                ArrayList<CheckResBean> r = new ArrayList<>();
                for (int i = 0; i < res.size(); i++) {
                    CheckResBean checkResBean = new CheckResBean();
                    checkResBean.setItemName(res.get(i).getItemName());
                    ArrayList<CheckDataResBean> d = new ArrayList<>();
                    checkResBean.setData(d);
                    for (int j = 0; j < res.get(i).getData().size(); j++) {
                        if (sort == "全部" || res.get(i).getData().get(j).getTaskname().contains(sort)
                                || (res.get(i).getData().get(j).getTaskname().contains("静脉输液") && sort.contains("静滴"))
                                || (res.get(i).getData().get(j).getTaskname().contains("静脉推") && sort.contains("静推"))) {
                            d.add(res.get(i).getData().get(j));
                        }
                    }
                    r.add(checkResBean);
                }
                return r;
            }

            @Override
            protected void onPostExecute(ArrayList<CheckResBean> s) {
                if (onFinishListener != null) {
                    onFinishListener.onFinish(s);
                }
            }
        }.execute();
    }


    public void setRes(ArrayList<CheckResBean> res) {
        this.res = res;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ArrayList<CheckResBean> getRes() {
        return res;
    }
}
