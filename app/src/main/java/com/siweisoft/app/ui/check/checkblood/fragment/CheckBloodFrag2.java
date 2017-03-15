package com.siweisoft.app.ui.check.checkblood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.ope.SimpleNetOpe;
import com.siweisoft.app.ui.check.checkblood.bean.CheckPatAndPipeResBean;
import com.siweisoft.app.ui.check.checkblood.ope.CheckBloodDAOpe;
import com.siweisoft.app.ui.check.checkblood.ope.CheckBloodUIOpe;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseOpes;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.uuzuche.lib_zxing.activity.CaptureActivity;
import com.siweisoft.lib.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class CheckBloodFrag2 extends CommonUIFrag2<CheckBloodUIOpe<CheckBloodFrag2>, CheckBloodDAOpe<CheckBloodFrag2>> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseOpes.getDaOpe().setResult(getArguments().getString(ValueConstant.DATA_DATA));
        baseOpes.getUiOpe().showFristInfo(baseOpes.getDaOpe().getResult());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data == null ? "" : data.getExtras() == null ? "" : data.getExtras().getString(CodeUtils.RESULT_STRING);

    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new CheckBloodUIOpe<CheckBloodFrag2>(activity, getView()), new CheckBloodDAOpe<CheckBloodFrag2>(activity));
        }
        return R.layout.frag_checkblood;
    }

    public void checkPatAndPipeCode(final String code, String zyh) {
        if (zyh != null) {
            baseOpes.getDaOpe().setPno(zyh);
        }

        SimpleNetOpe.checkPatAndPipeCode(activity, code == null ? baseOpes.getDaOpe().getResult() : code, baseOpes.getDaOpe().getPno(), new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    CheckPatAndPipeResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), CheckPatAndPipeResBean.class);
                    resBean.getData().setCode(code == null ? baseOpes.getDaOpe().getResult() : code);
                    baseOpes.getDaOpe().getData().add(resBean);
                    baseOpes.getUiOpe().initList(baseOpes.getDaOpe().getData());
                    baseOpes.getUiOpe().showPatientInfo(resBean.getData());
                    if (resBean.getData().getResCode().equals("1")) {
                        DialogUtil.getInstance().showDialog(activity, LayoutInflater.from(activity).inflate(R.layout.dialog_checkpatandpipe, null), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                switch (v.getId()) {
                                    case R.id.tv_contine:
                                        DialogUtil.getInstance().dismiss();
                                        activity.startActivityForResult(new Intent(activity, CaptureActivity.class), ValueConstant.CODE_REQUSET);
                                        break;
                                    case R.id.tv_done:
                                        DialogUtil.getInstance().dismiss();
                                        break;
                                }
                            }
                        }, R.id.tv_contine, R.id.tv_done);
                    }
                }
            }
        });
    }


}
