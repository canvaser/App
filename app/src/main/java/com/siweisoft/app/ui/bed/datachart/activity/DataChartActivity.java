package com.siweisoft.app.ui.bed.datachart.activity;

import android.os.Bundle;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.bed.datachart.fragment.DataChartFrag;
import com.siweisoft.lib.base.ui.activity.BaseUIWithOutTitleActivity;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.FragmentUtil;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class DataChartActivity extends BaseUIWithOutTitleActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() == null || getIntent().getSerializableExtra(ValueConstant.DATA_DATA) == null || getIntent().getSerializableExtra(ValueConstant.DATA_DATA2) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA, getIntent().getSerializableExtra(ValueConstant.DATA_DATA));
        bundle.putSerializable(ValueConstant.DATA_DATA2, getIntent().getSerializableExtra(ValueConstant.DATA_DATA2));
        DataChartFrag dataChartFrag = new DataChartFrag();
        dataChartFrag.setArguments(bundle);
        FragmentUtil.getInstance().addToContaier(activity, dataChartFrag, R.id.chartcontainer);
    }

    @Override
    protected int onCreateContainerView() {
        return R.layout.activity_datachart;
    }

    @Override
    public boolean isFullScreen() {
        return true;
    }

    @Override
    public boolean isLandScape() {
        return true;
    }
}
