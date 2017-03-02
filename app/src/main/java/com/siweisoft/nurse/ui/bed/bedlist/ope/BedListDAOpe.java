package com.siweisoft.nurse.ui.bed.bedlist.ope;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.CommonUIBean;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.util.BitmapUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.bedlist.adapter.BedListAdapter;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.AdditionCodeResBean;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class BedListDAOpe extends BaseDAOpe {


    ArrayList<PatientBedResBean> allList;

    ArrayList<PatientBedResBean> myList;


    private int index = 0;

    public BedListDAOpe(Context context) {
        super(context);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<String> getPatientNames(ArrayList<PatientBedResBean> patientBedResBeen) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < patientBedResBeen.size(); i++) {
            strings.add(patientBedResBeen.get(i).get姓名());
        }
        return strings;
    }

    public int getPosition(ArrayList<PatientBedResBean> patientBedResBeen, String zyh) {
        for (int i = 0; i < patientBedResBeen.size(); i++) {
            if (patientBedResBeen.get(i).get住院号().equals(zyh)) {
                LogUtil.E(zyh + "----" + i);
                return i;
            }
        }
        return -1;
    }

    public PatientBedResBean getPatientBedResBean(ArrayList<PatientBedResBean> patientBedResBeen, String zyh) {
        for (int i = 0; i < patientBedResBeen.size(); i++) {
            if (patientBedResBeen.get(i).get住院号().equals(zyh)) {
                LogUtil.E(zyh + "----" + i);
                return patientBedResBeen.get(i);
            }
        }
        return null;
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

    public void initMyBedList(Context context) {
        for (int i = 0; i < myList.size(); i++) {
            String sex = "";
            String age = "";
            String level = "";
            if (myList.get(i).get性别().equals("女")) {
                sex = "woman";
            } else {
                sex = "man";
            }
            if (myList.get(i).getPatAge() >= 60) {
                age = "old";
            } else if (myList.get(i).getPatAge() >= 14) {
                age = "middle";
            } else {
                age = "young";
            }
            switch (myList.get(i).get护理级别名称()) {
                case DataValue.LEVEL_NURSE_1:
                    level = "l1";
                    break;
                case DataValue.LEVEL_NURSE_2:
                    level = "l2";
                    break;
                case DataValue.LEVEL_NURSE_3:
                    level = "l3";
                    break;
            }

            int id = context.getResources().getIdentifier(age + "_" + sex + "_" + level, "drawable", context.getPackageName());
            myList.get(i).setResId(id);
        }
    }

    public void initAllBedList(final Context context, final OnFinishListener onFinishListener) {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                for (int i = 0; i < allList.size(); i++) {
                    String sex = "";
                    String age = "";
                    String level = "";
                    if (allList.get(i).get性别().equals("女")) {
                        sex = "woman";
                    } else {
                        sex = "man";
                    }
                    if (allList.get(i).getPatAge() >= 60) {
                        age = "old";
                    } else if (allList.get(i).getPatAge() >= 14) {
                        age = "middle";
                    } else {
                        age = "young";
                    }
                    switch (allList.get(i).get护理级别名称()) {
                        case DataValue.LEVEL_NURSE_1:
                            level = "l1";
                            break;
                        case DataValue.LEVEL_NURSE_2:
                            level = "l2";
                            break;
                        case DataValue.LEVEL_NURSE_3:
                            level = "l3";
                            break;
                    }

                    int id = context.getResources().getIdentifier(age + "_" + sex + "_" + level, "drawable", context.getPackageName());
                    allList.get(i).setResId(id);
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                onFinishListener.onFinish(s);
            }
        }.execute();
    }


    public void initBedListDetail(CommonUIBean holder, ArrayList<PatientBedResBean> data, int position) {
        switch (data.get(position).get状态()) {
            case "空床":
                holder.getView(R.id.ll_r).setVisibility(View.INVISIBLE);
                holder.setText(R.id.tv_empty, StringUtil.getStr(StringUtil.getSpilitStr(data.get(position).get病床号(), 2) + "." + "空床"));
                break;
            default:
                holder.setText(R.id.tv_numname, StringUtil.getStr(StringUtil.getSpilitStr(data.get(position).get病床号(), 2) + "." + data.get(position).get姓名()));
                holder.getView(R.id.ll_r).setVisibility(View.VISIBLE);
                holder.setText(R.id.tv_empty, "");
                if (data.get(position).getAdditionCodes() != null && data.get(position).getAdditionCodes().size() > 0) {
                    switch (data.get(position).getAdditionCodes().get(0).getType()) {
                        case "过敏":
                            holder.getView(R.id.iv_ming).setVisibility(View.VISIBLE);
                            break;
                        case "手术":
                            holder.getView(R.id.iv_shu).setVisibility(View.VISIBLE);
                            break;
                        default:
                            holder.getView(R.id.iv_shu).setVisibility(View.VISIBLE);
                            holder.getView(R.id.iv_ming).setVisibility(View.VISIBLE);
                            holder.getView(R.id.iv_ru).setVisibility(View.VISIBLE);
                            holder.getView(R.id.iv_chu).setVisibility(View.VISIBLE);
                    }
                }
                if (data.get(position).getResId() != 0) {
                    BitmapUtil.getInstance().setBg(holder.getmContext(), (ImageView) holder.getView(R.id.iv_level), data.get(position).getResId());
                }
                if (data.get(position).get性别().equals("男")) {
                    BitmapUtil.getInstance().setBg(holder.getmContext(), (ImageView) holder.getView(R.id.iv_sex), R.drawable.icon_sex_man);
                } else {
                    BitmapUtil.getInstance().setBg(holder.getmContext(), (ImageView) holder.getView(R.id.iv_sex), R.drawable.icon_sex_woman);
                }
                break;
        }
    }

    public boolean isEmptyBed(String bed) {
        if (bed.equals("空床")) {
            return true;
        }
        return false;
    }

    public int[] getStatus(ArrayList<AdditionCodeResBean> data) {
        int[] i = new int[]{View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE};
        if (data != null && data.size() > 0) {
            switch (data.get(0).getType()) {
                case "过敏":
                    i = new int[]{View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE};
                    break;
                case "手术":
                    i = new int[]{View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE};
                    break;
                default:
                    i = new int[]{View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE};
            }
        }
        return i;
    }

    public boolean booleanICU(String status) {
        if (status.equals("ICU")) {
            return true;
        }
        return false;
    }


}
