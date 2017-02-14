package com.siweisoft.nurse.ui.bed.addmypatient.bean;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.network.bean.req.BaseReqBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class MyPaitentUpdateListReqBean extends BaseReqBean{

    private String json_data;

    public String getJson_data() {
        return json_data;
    }

    public void setJson_data(String json_data) {
        this.json_data = json_data;
    }
}
