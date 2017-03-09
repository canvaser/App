package com.siweisoft.app.ui.addwater.addwater.ope.daope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.app.ui.addwater.addwater.bean.netbean.AddWaterListResBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-17.
 */
public class AddWaterDetailDAOpe extends BaseDAOpe {

    private List<AddWaterListResBean.DataBean.FilesBean> filesBeans;

    public AddWaterDetailDAOpe(Context context) {
        super(context);
    }

    public List<AddWaterListResBean.DataBean.FilesBean> getFilesBeans() {
        return filesBeans;
    }

    public void setFilesBeans(List<AddWaterListResBean.DataBean.FilesBean> filesBeans) {
        this.filesBeans = filesBeans;
    }
}
