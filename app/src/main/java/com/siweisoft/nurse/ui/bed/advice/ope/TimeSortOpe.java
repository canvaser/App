package com.siweisoft.nurse.ui.bed.advice.ope;

import com.siweisoft.nurse.ui.bed.advice.bean.resbean.AdviceResBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class TimeSortOpe {

    private HashMap<String,ArrayList<AdviceResBean>> hashMap=new HashMap<>();

    public HashMap<String,ArrayList<AdviceResBean>> sortTime(ArrayList<AdviceResBean> data){
        for(int i=0;i<data.size();i++){
            if(hashMap.get(data.get(i).getAdvType())==null){
                hashMap.put(data.get(i).getAdvType(),new ArrayList<AdviceResBean>());
            }
            hashMap.get(data.get(i).getAdvType()).add(data.get(i));
        }
        return hashMap;
    }
}
