package com.siweisoft.nurse.ui.bed.data.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.nurse.ui.bed.data.bean.adatperbean.DataAdapterBean;
import com.siweisoft.nurse.ui.bed.data.bean.uibean.DataBodyUIBean3;

/**
 * Created by ${viwmox} on 2016-11-24.
 */
public class DataAdapter3 extends AppRecycleAdapter {

    DataAdapterBean data;

    int color = Color.WHITE;

    boolean b=true;

    View.OnClickListener onClickListener;

    public DataAdapter3(Context context, DataAdapterBean data,boolean b) {
        super(context);
        this.data = data;
        color = context.getResources().getColor(R.color.light_pink);
        this.b= b;
    }

    public DataAdapter3(Context context, DataAdapterBean data) {
        super(context);
        this.data = data;
        color = context.getResources().getColor(R.color.light_pink);
        this.b= b;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(data.getSize()==0){
            LinearLayout view = (LinearLayout) layoutInflater.inflate(R.layout.list_data_cotainer2,parent,false);
            DataBodyUIBean3 uiBean = new DataBodyUIBean3(context,view);
            for(int i=0;i<data.getTitle().size();i++){
                View v = layoutInflater.inflate(R.layout.list_data2,null);
                view.addView(v,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ValueConstant.DIMEN_1*40));
                if(i==data.getTitle().size()-1&& b){
                    TextView textView = (TextView) v.findViewById(R.id.tv_txt);
                    ViewGroup.LayoutParams p =textView.getLayoutParams();
                    p.height = ValueConstant.DIMEN_1*40;
                    textView.setLayoutParams(p);
                }
            }
            return uiBean;
        }else{
            LinearLayout view = (LinearLayout) layoutInflater.inflate(R.layout.list_data_cotainer,null);
            DataBodyUIBean3 uiBean = new DataBodyUIBean3(context,view);
            for(int i=0;i<data.getTitle().size();i++){
                View v = layoutInflater.inflate(R.layout.list_data,null);
                view.addView(v,new LinearLayout.LayoutParams(ValueConstant.DIMEN_1*100, ValueConstant.DIMEN_1*40));
                if(i==data.getTitle().size()-1&& b){
                    TextView textView = (TextView) v.findViewById(R.id.tv_txt);
                    ViewGroup.LayoutParams p =textView.getLayoutParams();
                    p.height = ValueConstant.DIMEN_1*40;
                    textView.setLayoutParams(p);
                }
            }
            return uiBean;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(data.getSize()==0){
            DataBodyUIBean3 uiBean = (DataBodyUIBean3) holder;
            for(int i=0;i<uiBean.getTextLL().getChildCount();i++){
                TextView textView = (TextView) uiBean.getTextLL().getChildAt(i).findViewById(R.id.tv_txt);
                textView.setText(StringUtil.getStr(""));
                if(i%2==0){
                    textView.setBackgroundColor(Color.WHITE);
                }else{
                    textView.setBackgroundColor(color);
                }
            }
        }else{
            DataBodyUIBean3 uiBean = (DataBodyUIBean3) holder;
            for(int i=0;i<uiBean.getTextLL().getChildCount();i++){
                TextView textView = (TextView) uiBean.getTextLL().getChildAt(i).findViewById(R.id.tv_txt);
                if(data.getData().get(i).size()>position){
                    textView.setText(StringUtil.getStr(data.getData().get(i).get(position).getValue()));
                    textView.setTag(R.id.position,data.getData().get(i).get(position));
                    if(onClickListener!=null){
                        textView.setOnClickListener(onClickListener);
                    }
                }
                if(i%2==0){
                    textView.setBackgroundColor(Color.WHITE);
                }else{
                    textView.setBackgroundColor(color);
                }

            }
        }

    }

    @Override
    public int getItemCount() {
        return data.getSize()==0?1:data.getSize();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {

    }
}
