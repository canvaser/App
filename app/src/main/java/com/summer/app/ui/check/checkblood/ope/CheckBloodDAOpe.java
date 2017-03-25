package com.summer.app.ui.check.checkblood.ope;

import android.content.Context;

import com.summer.app.ui.check.checkblood.bean.CheckPatAndPipeResBean;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.ope.BaseDAOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class CheckBloodDAOpe<A extends CommonUIFrag2> extends BaseDAOpe<A> {

    String result;

    String pno;

    ArrayList<CheckPatAndPipeResBean> data = new ArrayList<>();

    public CheckBloodDAOpe(Context context) {
        super(context);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public ArrayList<CheckPatAndPipeResBean> getData() {
        return data;
    }

    public void setData(ArrayList<CheckPatAndPipeResBean> data) {
        this.data = data;
    }
}
