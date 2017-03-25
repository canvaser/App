package com.summer.app.ui.info.adddutereport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.lib.util.SheetDialogUtil;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.util.fragment.FragManager;
import com.summer.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.info.adddutereport.ope.AddDuteReportUIOpe;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AddDuteReportFrag extends BaseNurseFrag {

    AddDuteReportUIOpe addDuteReportUIOpe;

    String[] strings = new String[]{"早早班", "早班", "两头班(早)", "大夜班", "小夜班", "两头班"};


    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addDuteReportUIOpe = new AddDuteReportUIOpe(activity, getView());
        addDuteReportUIOpe.getBanCiTV().setText(StringUtil.getStr(strings[0]));
        addDuteReportUIOpe.setInputType();
    }


    @OnClick({BaseID.ID_RIGHT, R.id.tv_bcTitle})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                if (!addDuteReportUIOpe.check()) {
                    ToastUtil.getInstance().show(activity, "数据填写不全");
                    return;
                }
                SimpleNetOpe.writeReportData(activity, addDuteReportUIOpe.getData(), new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            FragManager.getInstance().finish(getFragmentManager(), index);
                        }
                    }
                });
                break;
            case R.id.tv_bcTitle:
                BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, strings);
                SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = (TextView) v;
                        addDuteReportUIOpe.getBanCiTV().setText(textView.getText());
                        SheetDialogUtil.getInstance().dismess();
                    }
                });
                break;
        }
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addshiftdutereport;
    }
}
