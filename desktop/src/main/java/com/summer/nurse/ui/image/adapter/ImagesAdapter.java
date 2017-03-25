package com.summer.nurse.ui.image.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.summer.app.R;
import com.summer.base.ui.adapter.AppRecycleAdapter;
import com.summer.nurse.ui.image.bean.dabean.PicBean;
import com.summer.nurse.ui.image.bean.uibean.ImageUIBean;
import com.summer.util.BitmapUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-02-06.
 */

public class ImagesAdapter extends AppRecycleAdapter {

    ArrayList<PicBean> data;

    ArrayList<PicBean> select = new ArrayList<>();

    public ImagesAdapter(Context context, ArrayList<PicBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageUIBean imageUIBean = new ImageUIBean(context, layoutInflater.inflate(R.layout.grid_images_selectgvpic, parent, false));
        return imageUIBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageUIBean imageUIBean = (ImageUIBean) holder;
        BitmapUtil.getInstance().setBg(context, imageUIBean.getImageView(), data.get(position).getPath());
        imageUIBean.getRootV().setOnClickListener(this);
        imageUIBean.getCheckIV().setSelected(data.get(position).isSelect());
        imageUIBean.getRootV().setTag(R.id.data, data.get(position));
        imageUIBean.getRootV().setTag(R.id.position, position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View v) {
        int p = (int) v.getTag(R.id.position);
        ImageView check = (ImageView) v.findViewById(R.id.iv_check);
        v.setSelected(!v.isSelected());
        check.setSelected(v.isSelected());
        data.get(p).setSelect(v.isSelected());
        PicBean picBean = (PicBean) v.getTag(R.id.data);
        if (v.isSelected() && !select.contains(picBean)) {
            select.add(picBean);
        }
        if (!v.isSelected() && select.contains(picBean)) {
            select.remove(picBean);
        }
    }

    public ArrayList<PicBean> getSelect() {
        return select;
    }

    public void setSelect(ArrayList<PicBean> select) {
        this.select = select;
    }
}
