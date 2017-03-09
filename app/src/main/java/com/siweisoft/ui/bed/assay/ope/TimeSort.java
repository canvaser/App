package com.siweisoft.ui.bed.assay.ope;

import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.ui.bed.assay.bean.resbean.AssayListResBean;

import java.text.ParseException;
import java.util.Comparator;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class TimeSort implements Comparator<AssayListResBean.AssayDataBean> {

    @Override
    public int compare(AssayListResBean.AssayDataBean o1, AssayListResBean.AssayDataBean o2) {
        try {
            long t1 = DateFormatUtil.convent_yyyyMMddHHmmss(o1.getResulttime()).getTime();
            long t2 = DateFormatUtil.convent_yyyyMMddHHmmss(o1.getResulttime()).getTime();
            return t1 > t2 ? 0 : 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
