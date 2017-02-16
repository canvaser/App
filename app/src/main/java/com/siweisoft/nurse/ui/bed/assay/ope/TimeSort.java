package com.siweisoft.nurse.ui.bed.assay.ope;

import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayResBean;

import java.text.ParseException;
import java.util.Comparator;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class TimeSort  implements Comparator<AssayResBean> {

    @Override
    public int compare(AssayResBean o1, AssayResBean o2) {
        try {
            long t1 = DateFormatUtil.convent_yyyyMMddHHmmss(o1.getResulttime()).getTime();
            long t2 = DateFormatUtil.convent_yyyyMMddHHmmss(o1.getResulttime()).getTime();
            return t1>t2?0:1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
