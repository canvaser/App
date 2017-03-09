package com.siweisoft.ui.bed.data.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.ui.bed.data.bean.adatperbean.DataAdapterBean;
import com.siweisoft.ui.bed.data.bean.resbean.BodyDataResBean;
import com.siweisoft.ui.bed.data.bean.resbean.TitleDataResBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-24.
 */
public class DataDAOpe extends BaseOpe {


    String[] str = null;

    public DataDAOpe(Context context) {
        super(context);
    }

    public HashMap<String, ArrayList<TitleDataResBean>> sort(ArrayList<TitleDataResBean> data) {

        HashMap<String, ArrayList<TitleDataResBean>> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            if ((data.get(i).getGroupname().equals("体温单") && data.get(i).getSignname().equals("录入时间")) ||
                    (data.get(i).getGroupname().equals("图章") && data.get(i).getSignname().equals("图章时间"))) {
                for (int m = 0; m < data.get(i).getJson_data().size(); m++) {
                    String[] s = data.get(i).getJson_data().get(m).getExectime().split(" ");
                    if (s.length == 2) {
                        String[] ss = s[1].split(":");
                        if (ss.length == 3) {
                            data.get(i).getJson_data().get(m).setValue(ss[0] + ":" + ss[1]);
                        }
                    }
                }
            }
            if (map.get(data.get(i).getGroupname()) == null) {
                map.put(data.get(i).getGroupname(), new ArrayList<TitleDataResBean>());
            }
            map.get(data.get(i).getGroupname()).add(data.get(i));
        }
        return map;
    }

    public ArrayList<DataAdapterBean> getData(HashMap<String, ArrayList<TitleDataResBean>> data) {


        ArrayList<DataAdapterBean> ll = new ArrayList<>();

        str = new String[data.size()];
        str = data.keySet().toArray(str);

        for (int i = 0; i < str.length; i++) {
            DataAdapterBean dataAdapterBean = new DataAdapterBean();
            dataAdapterBean.setHead(str[i]);
            //莫一大项的左边标题
            ArrayList<String> title = new ArrayList<>();
            //莫一大项的左边标题包含的数据
            ArrayList<TitleDataResBean> titleData = new ArrayList<>();
            //莫一大项的右边数据
            ArrayList<ArrayList<BodyDataResBean>> d = new ArrayList<>();
            //莫一大项的全部数据
            ArrayList<TitleDataResBean> a = data.get(str[i]);

            ArrayList<Integer> integers = new ArrayList<>();
            int max = 0;
            for (int b = 0; b < a.size(); b++) {
                integers.add(a.get(b).getJson_data().size());
            }
            if (integers.size() != 0) {
                Collections.sort(integers, new IntegerSort());
                max = integers.get(integers.size() - 1);
            }
            dataAdapterBean.setSize(max);

            //莫一小项的数据
            for (int j = 0; j < a.size(); j++) {
                title.add(a.get(j).getSignname());
                titleData.add(a.get(j));
                ArrayList<BodyDataResBean> ss = new ArrayList<>();
                for (int l = 0; l < a.get(j).getJson_data().size(); l++) {
                    for (int t = 0; t < max; t++) {
                        if (t < a.get(j).getJson_data().size()) {
                            ss.add(a.get(j).getJson_data().get(t));
                        } else {
                            BodyDataResBean bodyDataResBean = new BodyDataResBean();
                            ss.add(bodyDataResBean);
                        }
                    }
                }
                d.add(ss);
            }
            dataAdapterBean.setTitle(title);
            dataAdapterBean.setData(d);
            dataAdapterBean.setTitleData(titleData);
            ll.add(dataAdapterBean);
        }


        DataAdapterBean dataAdapterBean = null;
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).getHead().equals("体温单")) {
                dataAdapterBean = ll.get(i);
                ll.remove(i);
                break;
            }
        }
        ll.add(0, dataAdapterBean);
        return ll;
    }
}
