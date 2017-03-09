package com.siweisoft.app.ui.document.document.ope.daope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.app.ui.document.document.bean.netbean.DocumentListResBean;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentListDAOpe extends BaseDAOpe {

    DocumentListResBean.DataBean dataBean;

    DocumentListResBean documentListResBean;


    public DocumentListDAOpe(Context context) {
        super(context);
    }

    public DocumentListResBean.DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DocumentListResBean.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public DocumentListResBean getDocumentListResBean() {
        return documentListResBean;
    }

    public void setDocumentListResBean(DocumentListResBean documentListResBean) {
        this.documentListResBean = documentListResBean;
        if (documentListResBean != null && documentListResBean.getData() != null && documentListResBean.getData().size() > 0) {
            for (int i = 0; i < documentListResBean.getData().size(); i++) {
                if (documentListResBean.getData().get(i).getType().equals(DocumentListResBean.DataBean.TYPE_HAVE_CHILD)) {
                    documentListResBean.getData().get(i).setEnter(true);
                } else {
                    documentListResBean.getData().get(i).setEnter(false);
                }
            }
        }
    }

    public void setEnableEnter() {
        if (documentListResBean != null && documentListResBean.getData() != null && documentListResBean.getData().size() > 0) {
            for (int i = 0; i < documentListResBean.getData().size(); i++) {
                documentListResBean.getData().get(i).setEnter(true);
            }
        }
    }
}
