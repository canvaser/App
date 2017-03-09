package com.siweisoft.ui.info.workdetail.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;
import com.siweisoft.ui.info.workdetail.bean.resbean.WorkDetailResBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailDAOpe extends BaseOpe {


    public WorkDetailDAOpe(Context context) {
        super(context);
    }


    public ArrayList<WorkDetailAdapterBean> sort(ArrayList<WorkDetailResBean> data) {
        HashMap<String, WorkDetailAdapterBean> adapterBeanHashMap = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            if (adapterBeanHashMap.get(data.get(i).getExecdate()) == null) {
                WorkDetailAdapterBean workDetailAdapterBean = new WorkDetailAdapterBean();
                workDetailAdapterBean.setDate(data.get(i).getExecdate());
                ArrayList<WorkDetailResBean> list = new ArrayList<>();
                list.add(data.get(i));
                workDetailAdapterBean.setList(list);
                adapterBeanHashMap.put(data.get(i).getExecdate(), workDetailAdapterBean);
            } else {
                WorkDetailAdapterBean workDetailAdapterBean = adapterBeanHashMap.get(data.get(i).getExecdate());
                workDetailAdapterBean.getList().add(data.get(i));
            }
        }
        String[] strings = new String[adapterBeanHashMap.size()];
        strings = adapterBeanHashMap.keySet().toArray(strings);
        for (int i = 0; i < adapterBeanHashMap.size(); i++) {
            ArrayList<WorkDetailResBean> list = adapterBeanHashMap.get(strings[i]).getList();
            int w = 0;
            int n = 0;
            for (int j = 0; j < list.size(); j++) {
                w += list.get(j).getWorkload();
                n += list.get(j).get次数();
            }
            adapterBeanHashMap.get(strings[i]).setNum(n + "");
            adapterBeanHashMap.get(strings[i]).setWorks(w + "");
        }

        ArrayList<WorkDetailAdapterBean> list = new ArrayList<>();
        for (int i = 0; i < adapterBeanHashMap.size(); i++) {
            list.add(adapterBeanHashMap.get(strings[i]));
        }
        return list;
    }


}
