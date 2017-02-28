package com.siweisoft.nurse.ui.bed.patient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.nurse.ui.bed.patient.bean.CareUIBean;
import com.siweisoft.nurse.ui.bed.patient.bean.resbean.PatientAdditionListResBean;
import com.siweisoft.nurse.ui.bed.patient.bean.resbean.PatientAdditionResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class CareListAdapter extends AppRecycleAdapter {


    ArrayList<PatientAdditionResBean> resBeen;

    public CareListAdapter(Context context, ArrayList<PatientAdditionResBean> resBeen) {
        super(context);
        this.resBeen = resBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_care, null);
        CareUIBean careUIBean = new CareUIBean(context, view);
        return careUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CareUIBean careUIBean = (CareUIBean) holder;
        switch (resBeen.get(position).getType()) {
            case "导管":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_hightemp);
                break;
            case "关怀":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_heart);
                break;
            case "病重":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_critical);
                break;
            case "病危":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_danger);
                break;
            case "气管筒":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_hightemp);
                break;
            case "全喉筒":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_hightemp);
                break;
            case "防跌倒":
                careUIBean.getIconIV().setImageResource(R.drawable.drawable_care_heart);
                break;
        }
        careUIBean.getNameTV().setText(resBeen.get(position).getValue());
        careUIBean.getIconIV().setSelected(resBeen.get(position).isSelect());
    }

    @Override
    public int getItemCount() {
        return resBeen == null ? 0 : resBeen.size();
    }

    @Override
    public void onClick(View v) {

    }
}
