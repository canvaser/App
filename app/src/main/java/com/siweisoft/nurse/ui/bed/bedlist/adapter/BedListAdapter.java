package com.siweisoft.nurse.ui.bed.bedlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.BitmapUtil;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.bed.bedlist.bean.uibean.BedUIBean;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class BedListAdapter extends AppRecycleAdapter {

    OnAppItemClickListener onAppItemClickListener;

    ArrayList<PatientBedResBean> data;
    public BedListAdapter(Context context,ArrayList<PatientBedResBean> data) {
        super(context);
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_bed,parent,false);
        BedUIBean bedUIBean = new BedUIBean(context,view);
        return bedUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BedUIBean bedUIBean = (BedUIBean) holder;
        switch (data.get(position).get状态()){
            case "空床":
                bedUIBean.getrV().setVisibility(View.INVISIBLE);
                bedUIBean.getEmptyTV().setText(StringUtil.getStr(StringUtil.getSpilitStr(data.get(position).get病床号(),2)+"."+"空床"));
                break;
            default:
                bedUIBean.getNumAndNameTV().setText(StringUtil.getStr(StringUtil.getSpilitStr(data.get(position).get病床号(),2)+"."+ data.get(position).get姓名()));
                bedUIBean.getRootV().setTag(R.id.position,position);
                bedUIBean.getRootV().setOnClickListener(this);
                bedUIBean.getrV().setVisibility(View.VISIBLE);
                bedUIBean.getEmptyTV().setText("");
                if(data.get(position).getAdditionCodes()!=null && data.get(position).getAdditionCodes().size()>0){
                    switch (data.get(position).getAdditionCodes().get(0).getType()){
                        case "过敏":
                            //BitmapUtil.getInstance().setBg(context,bedUIBean.getMingIV(),R.drawable.icon_ming);
                            break;
                        case "手术":
                            //BitmapUtil.getInstance().setBg(context,bedUIBean.getMingIV(),R.drawable.icon_shu);
                            break;
                    }
                }

                if(data.get(position).getResId()!=0){
                    BitmapUtil.getInstance().setBg(context,bedUIBean.getLevelIV(), data.get(position).getResId());
                }

                if(data.get(position).get性别().equals("男")){
                    BitmapUtil.getInstance().setBg(context,bedUIBean.getSexIV(),R.drawable.icon_sex_man);
                }else{
                    BitmapUtil.getInstance().setBg(context,bedUIBean.getSexIV(),R.drawable.icon_sex_woman);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data ==null?0: data.size();
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag(R.id.position);
        if(onAppItemClickListener!=null && !NullUtil.isStrEmpty(data.get(position).get住院号())){
            onAppItemClickListener.onAppItemClick(v,position);
        }
    }

    public ArrayList<PatientBedResBean> getData() {
        return data;
    }
}
