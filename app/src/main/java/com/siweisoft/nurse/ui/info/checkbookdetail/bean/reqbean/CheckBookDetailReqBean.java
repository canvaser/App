package com.siweisoft.nurse.ui.info.checkbookdetail.bean.reqbean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookDetailReqBean extends BaseReqBean {

    private String fileid;

    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }
}
