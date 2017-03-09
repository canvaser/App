package com.siweisoft.app.ui.info.infolist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.util.BitmapUtil;
import com.siweisoft.app.ui.info.infolist.bean.InfoListUIBean;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class InfoListAdapter extends AppRecycleAdapter {


    OnAppItemClickListener onAppItemClickListener;


    public static final String[] titles = new String[]{"病房巡视", "语音联系", "通知公告", "病床日报", "紧急报告", "交班本", "点物本", "工作明细", "排班表"};

    public static final int[] icons = new int[]{R.drawable.icon_info_bedscan,
            R.drawable.icon_info_voice,
            R.drawable.icon_info_notice,
            R.drawable.icon_info_bedreport,
            R.drawable.icon_info_seri,
            R.drawable.icon_info_jiao,
            R.drawable.icon_info_dian,
            R.drawable.icon_info_detail,
            R.drawable.icon_info_chart};

    public InfoListAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_info, parent, false);
        InfoListUIBean infoListUIBean = new InfoListUIBean(context, view);
        return infoListUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        InfoListUIBean infoListUIBean = (InfoListUIBean) holder;
        infoListUIBean.getTitleView().setText(titles[position]);
        infoListUIBean.getRootV().setTag(R.id.position, position);
        infoListUIBean.getRootV().setOnClickListener(this);
        BitmapUtil.getInstance().setBg(context, infoListUIBean.getImageView(), icons[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        if (onAppItemClickListener != null) {
            onAppItemClickListener.onAppItemClick(v, p);
        }
    }

    public void setOnAppItemClickListener(OnAppItemClickListener onAppItemClickListener) {
        this.onAppItemClickListener = onAppItemClickListener;
    }
}
