package com.siweisoft.nurse.ui.bed.assay.ope;

import com.siweisoft.nurse.ui.bed.assay.bean.adapterbean.AssayAdapterBean;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayListResBean;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayResBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssaySortOpe {


    public ArrayList<AssayAdapterBean> sortAssay(List<AssayListResBean.AssayDataBean> data) {
        HashMap<String, ArrayList<AssayListResBean.AssayDataBean>> hashMap = new HashMap<>();
        ArrayList<AssayAdapterBean> assayAdapterBeen = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (hashMap.get(data.get(i).getApplyno()) == null) {
                hashMap.put(data.get(i).getApplyno(), new ArrayList<AssayListResBean.AssayDataBean>());
            }
            ArrayList<AssayListResBean.AssayDataBean> l = hashMap.get(data.get(i).getApplyno());
            l.add(data.get(i));
        }
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            AssayAdapterBean assayAdapterBean = new AssayAdapterBean();
            String key = iterator.next();
            assayAdapterBean.setApplyno(key);
            assayAdapterBean.setList(hashMap.get(key));
            assayAdapterBean.setTitle(assayAdapterBean.getList().get(0).getReporttitle());
            assayAdapterBean.setTitle(assayAdapterBean.getList().get(0).getResulttime());
            Collections.sort(assayAdapterBean.getList(), new TimeSort());
            assayAdapterBeen.add(assayAdapterBean);
        }

        return assayAdapterBeen;
    }
}
