package com.siweisoft.nurse.ui.dialog.dialog.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.dialog.dialog.ope.uiope.NurseDialogUIOpe;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class NurseDialogFrag extends Fragment implements View.OnClickListener{

    NurseDialogUIOpe nurseDialogUIOpe;

    private String[] strings;

    private OnAppItemClickListener onAppItemClickListener;

    public static void show(FragmentManager fragmentManagers , int id, String[]strings, OnAppItemClickListener onAppItemClickListener){
        Bundle bundle = new Bundle();
        bundle.putStringArray(ValueConstant.DATA_DATA,strings);
        NurseDialogFrag nurseDialogFrag = new NurseDialogFrag();
        nurseDialogFrag.setArguments(bundle);
        nurseDialogFrag.onAppItemClickListener = onAppItemClickListener;
        fragmentManagers.beginTransaction().add(id,nurseDialogFrag).commit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_dialog_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nurseDialogUIOpe= new NurseDialogUIOpe(getActivity(),getView());
        strings = getArguments().getStringArray(ValueConstant.DATA_DATA);
        getView().findViewById(R.id.root).setOnClickListener(this);
        nurseDialogUIOpe.showList(strings, new OnAppItemClickListener() {
            @Override
            public void onAppItemClick(View view, int position) {
                getFragmentManager().beginTransaction().remove(NurseDialogFrag.this).commit();
                onAppItemClickListener.onAppItemClick(view,position);
            }
        });
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().remove(NurseDialogFrag.this).commit();
    }
}
