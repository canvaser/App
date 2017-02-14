package com.siweisoft.nurse.ui.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.fragment.BaseUIFragment;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public abstract class BaseNurseTestFrag extends BaseUIFragment{

    protected  int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(getArguments()!=null){
            index = getArguments().getInt(ValueConstant.FRAG_POSITION);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Optional
    @OnClick({R.id.ftv_back})
    public void onBackClick(View v){
        switch (v.getId()){
            case R.id.ftv_back:
                FragManager.getInstance().finish(getFragmentManager(), index);
                break;
        }
    }

    public void onResult(int req ,Bundle bundle){

    }

    public int getLayoutID(){
        return R.layout.layout_baseui;
    }

}
