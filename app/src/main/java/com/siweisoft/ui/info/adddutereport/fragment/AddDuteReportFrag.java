package com.siweisoft.ui.info.adddutereport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.lib.util.SheetDialogUtil;
import com.siweisoft.lib.view.bottomdialogmenuview.BottomDialogMenuView;
import com.siweisoft.nursevalue.BaseID;
import com.siweisoft.ui.info.adddutereport.ope.AddDuteReportUIOpe;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AddDuteReportFrag extends BaseNurseFrag {

    AddDuteReportUIOpe addDuteReportUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addDuteReportUIOpe = new AddDuteReportUIOpe(activity, getView());
    }


    @OnClick({BaseID.ID_RIGHT, R.id.tv_bcTitle})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:

                break;
            case R.id.tv_bcTitle:
                BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity, new String[]{"早早班", "早班", "两头班(早)", "大夜班", "小夜班", "两头班"});
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