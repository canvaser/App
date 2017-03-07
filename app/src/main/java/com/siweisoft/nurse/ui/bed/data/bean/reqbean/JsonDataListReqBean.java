package com.siweisoft.nurse.ui.bed.data.bean.reqbean;


import com.siweisoft.lib.network.bean.req.BaseReqBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-12-05.
 */
public class JsonDataListReqBean extends BaseReqBean {

    private List<HashMap> json_data;

    public List<HashMap> getJson_data() {
        return json_data;
    }

    public void setJson_data(List<HashMap> json_data) {
        this.json_data = json_data;
    }
}
