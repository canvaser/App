package com.siweisoft.app.ui.document.document.ope.daope;

import android.content.Context;

import com.siweisoft.app.ui.document.document.bean.netbean.DocumentDetailResBean;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.app.ui.document.document.bean.netbean.DocumentListResBean;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentDetailListDAOpe extends BaseDAOpe {


    DocumentListResBean.DataBean dataBean;

    DocumentDetailResBean documentDetailResBean;

    public DocumentDetailListDAOpe(Context context) {
        super(context);
    }

    public DocumentListResBean.DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DocumentListResBean.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public DocumentDetailResBean getDocumentDetailResBean() {
        return documentDetailResBean;
    }

    public void setDocumentDetailResBean(DocumentDetailResBean documentDetailResBean) {
        this.documentDetailResBean = documentDetailResBean;
    }
}
