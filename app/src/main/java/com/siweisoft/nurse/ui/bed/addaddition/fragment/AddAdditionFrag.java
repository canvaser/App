package com.siweisoft.nurse.ui.bed.addaddition.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.bed.addaddition.ope.AddAdditionUIOpe;
import com.siweisoft.nurse.ui.bed.additionlist.fragment.AdditionListFrag;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AddAdditionFrag extends BaseNurseFrag{


    AddAdditionUIOpe addAdditionUIOpe;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null || getArguments().getSerializable(ValueConstant.DATA_DATA2)==null){
            return;
        }
        addAdditionUIOpe = new AddAdditionUIOpe(activity,getView());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addaddition;
    }

    @OnClick({R.id.tv_daoguan,R.id.tv_care})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_daoguan:
                Bundle bundle = new Bundle();
                bundle.putString(ValueConstant.DATA_POSITION,"0");
                bundle.putSerializable(ValueConstant.DATA_DATA2,getArguments().getSerializable(ValueConstant.DATA_DATA2));
                bundle.putSerializable(ValueConstant.DATA_DATA,getArguments().getSerializable(ValueConstant.DATA_DATA));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new AdditionListFrag(),bundle,ValueConstant.CODE_REQUSET);
                break;
            case R.id.tv_care:
                Bundle bundle1 = new Bundle();
                bundle1.putString(ValueConstant.DATA_POSITION,"1");
                bundle1.putSerializable(ValueConstant.DATA_DATA2,getArguments().getSerializable(ValueConstant.DATA_DATA2));
                bundle1.putSerializable(ValueConstant.DATA_DATA,getArguments().getSerializable(ValueConstant.DATA_DATA));
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new AdditionListFrag(),bundle1,ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        if(bundle==null || bundle.getSerializable(ValueConstant.DATA_DATA)==null){
            return ;
        }
        FragManager.getInstance().finish(getFragmentManager(),index);
    }
}
