package com.siweisoft.nurse.ui.bed.bedlist.ope;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.animation.Animation;

import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.bedlist.adapter.BedListAdapter;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.util.LogUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class BedListDAOpe {


    ArrayList<PatientBedResBean> allList;

    ArrayList<PatientBedResBean> myList;


    private int index=0;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<String> getPatientNames(ArrayList<PatientBedResBean> patientBedResBeen){
        ArrayList<String> strings = new ArrayList<>();
        for(int i=0;i<patientBedResBeen.size();i++){
            strings.add(patientBedResBeen.get(i).get姓名());
        }
        return strings;
    }

    public int getPosition(ArrayList<PatientBedResBean> patientBedResBeen,String zyh){
        for(int i=0;i<patientBedResBeen.size();i++){
            if(patientBedResBeen.get(i).get住院号().equals(zyh)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<PatientBedResBean> getAllList() {
        return allList;
    }

    public void setAllList(ArrayList<PatientBedResBean> allList) {
        this.allList = allList;
    }

    public ArrayList<PatientBedResBean> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<PatientBedResBean> myList) {
        this.myList = myList;
    }

    public void initMyBedList(Context context){
            for(int i=0;i<myList.size();i++){
                String sex = "";
                String age ="";
                String level = "";
                if(myList.get(i).get性别().equals("女")){
                    sex = "woman";
                }else{
                    sex = "man";
                }
                if(myList.get(i).getPatAge()>=60){
                    age="old";
                }else if(myList.get(i).getPatAge()>=14){
                    age="middle";
                }else{
                    age="young";
                }
                switch (myList.get(i).get护理级别名称()){
                    case DataValue.LEVEL_NURSE_1:
                        level="l1";
                        break;
                    case DataValue.LEVEL_NURSE_2:
                        level="l2";
                        break;
                    case DataValue.LEVEL_NURSE_3:
                        level="l3";
                        break;
                }

                int id = context.getResources().getIdentifier(age+"_"+sex+"_"+level,"drawable",context.getPackageName());
                myList.get(i).setResId(id);
            }
    }

    public void initAllBedList(Context context){
        for(int i=0;i<allList.size();i++){
            String sex = "";
            String age ="";
            String level = "";
            if(allList.get(i).get性别().equals("女")){
                sex = "woman";
            }else{
                sex = "man";
            }
            if(allList.get(i).getPatAge()>=60){
                age="old";
            }else if(allList.get(i).getPatAge()>=14){
                age="middle";
            }else{
                age="young";
            }
            switch (allList.get(i).get护理级别名称()){
                case DataValue.LEVEL_NURSE_1:
                    level="l1";
                    break;
                case DataValue.LEVEL_NURSE_2:
                    level="l2";
                    break;
                case DataValue.LEVEL_NURSE_3:
                    level="l3";
                    break;
            }

            int id = context.getResources().getIdentifier(age+"_"+sex+"_"+level,"drawable",context.getPackageName());
            allList.get(i).setResId(id);
        }
    }
}
