package com.summer.nurse.ui.image.ope.daope;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.summer.base.ui.ope.BaseDAOpe;
import com.summer.database.sysdb.ProviderDBHelper;
import com.summer.nurse.ui.image.bean.dabean.PicBean;
import com.summer.nurse.ui.image.bean.dabean.PicFolderBean;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-08-01.
 */
public class SelectPicDAOpe extends BaseDAOpe {

    ArrayList<PicBean> picBeans = null;

    ArrayList<PicFolderBean> picFolderBeans = null;

    public SelectPicDAOpe(Context context) {
        super(context);
    }

    public ArrayList<PicBean> getPics(Context context) {
        if (this.picBeans != null) {
            return this.picBeans;
        }
        ArrayList<PicBean> picBeans = new ArrayList<>();
        String[] str = {MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATA};
        Cursor cursor = ProviderDBHelper.getInstance().query(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str, null, null, MediaStore.Images.Media.DATE_MODIFIED + " desc");
        if (cursor != null) {
            while (cursor.moveToNext()) {
                PicBean picBean = new PicBean(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)), cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
                File file = new File(picBean.getPath());
                picBean.setFolder(file.getParentFile().getName());
                picBeans.add(picBean);
            }
        }
        this.picBeans = picBeans;
        return picBeans;
    }

    public ArrayList<PicFolderBean> sortToFolder(ArrayList<PicBean> picBeans) {
        if (this.picFolderBeans != null) {
            return this.picFolderBeans;
        }

        ArrayList<PicFolderBean> picFolderBeans = new ArrayList<>();


        for (int i = 0; i < picBeans.size(); i++) {
            if (picFolderBeans.size() == 0 && i == 0) {
                PicFolderBean picFolderBean = new PicFolderBean(picBeans.get(i).getFolder());
                picFolderBean.getPaths().add(picBeans.get(i).getPath());
                picFolderBeans.add(picFolderBean);
                continue;
            }
            for (int j = 0; j < picFolderBeans.size(); j++) {
                if (picFolderBeans.get(j).getFolderName().equals(picBeans.get(i).getFolder())) {
                    picFolderBeans.get(j).getPaths().add(picBeans.get(j).getPath());
                    break;
                }
                if (j == picFolderBeans.size() - 1) {
                    PicFolderBean picFolderBean = new PicFolderBean(picBeans.get(i).getFolder());
                    picFolderBean.getPaths().add(picBeans.get(i).getPath());
                    picFolderBeans.add(picFolderBean);
                }
            }
        }
        this.picFolderBeans = picFolderBeans;
        return picFolderBeans;
    }
}
