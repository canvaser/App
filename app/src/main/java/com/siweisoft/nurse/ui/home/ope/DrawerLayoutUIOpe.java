package com.siweisoft.nurse.ui.home.ope;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class DrawerLayoutUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.tv_sendd)
    TextView sendTV;

    @BindView(R.id.tv_selectt)
    TextView selectTV;

    @BindView(R.id.ll_menuroot)
    ViewGroup menuVG;

    ArrayList<View> itemVs=new ArrayList<>();

    ArrayList<View> selectVs= new ArrayList<>();

    String[] strings = new String[]{"手术室","麻醉室","医生","护士长","其他护士"};


    public DrawerLayoutUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){

        getMidTV().setText("紧急报告");

        for(int i=0;i<menuVG.getChildCount();i++){
            if(menuVG.getChildAt(i) instanceof ViewGroup){
                ViewGroup viewGroup = (ViewGroup) menuVG.getChildAt(i);
                itemVs.add(viewGroup);
                selectVs.add(viewGroup.getChildAt(1));
            }
        }
    }

    public ArrayList<View> getItemVs() {
        return itemVs;
    }

    public ViewGroup getMenuVG() {
        return menuVG;
    }

    public ArrayList<View> getSelectVs() {
        return selectVs;
    }

    public void setItemClickListener(final OnAppItemClickListener listener){
        for(int i=0;i<getItemVs().size();i++){
            final int finalI = i;
            getItemVs().get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAppItemClick(v, finalI);
                }
            });
        }
    }

    public TextView getSelectTV() {
        return selectTV;
    }

    public TextView getSendTV() {
        return sendTV;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}
