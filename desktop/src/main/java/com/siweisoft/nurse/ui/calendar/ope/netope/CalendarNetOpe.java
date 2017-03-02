package com.siweisoft.nurse.ui.calendar.ope.netope;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;

import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.OnProgressInterf;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.nurse.ui.calendar.bean.netbean.DayBean;
import com.siweisoft.nurse.ui.image.bean.dabean.PicBean;
import com.siweisoft.util.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

/**
 * Created by ${viwmox} on 2017-01-23.
 */
public class CalendarNetOpe extends BaseNetOpe {

    public CalendarNetOpe(Context context) {
        super(context);
    }

    public void getNetRecordList(final OnFinishListener onFinishListener) {
        BmobQuery<DayBean> query = new BmobQuery<DayBean>();
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<DayBean>() {
            @Override
            public void done(List<DayBean> object, BmobException e) {
                if (onFinishListener != null && object != null) {
                    onFinishListener.onFinish(object);
                }
            }
        });
    }

    public void getNetRecordListWithDate(Integer year, Integer month, Integer day, final OnFinishListener onFinishListener) {
        BmobQuery<DayBean> query = new BmobQuery<DayBean>();
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        query.addWhereEqualTo("year", year);
        query.addWhereEqualTo("month", month);
        query.addWhereEqualTo("day", day);
        //执行查询方法
        query.findObjects(new FindListener<DayBean>() {
            @Override
            public void done(List<DayBean> object, BmobException e) {
                if (onFinishListener != null && object != null) {
                    onFinishListener.onFinish(object);
                }
            }
        });
    }

    public void addRecordtext(String txt, final OnFinishListener onFinishListener) {
        final DayBean dayBean = new DayBean();
        dayBean.setContent(txt);
        dayBean.setYear(Calendar.getInstance().get(Calendar.YEAR));
        dayBean.setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
        dayBean.setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dayBean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (onFinishListener != null) {
                    onFinishListener.onFinish(s);
                }
            }
        });
    }

    private void uploadImage(DayBean dayBean, Uri url, final OnFinishListener onFinishListener) {
        if (url == null) {
            if (onFinishListener != null) {
                onFinishListener.onFinish("url==null");
            }
            return;
        }
        String str = url.toString().substring(7, url.toString().length());
        File file = new File(str);
        dayBean.setImage(new BmobFile(file));
        LogUtil.E(str + "" + file.exists());
        dayBean.getImage().upload(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (onFinishListener != null) {
                    onFinishListener.onFinish(e);
                }
            }
        });
    }


    private void uploadImage(DayBean dayBean, String url, final OnFinishListener onFinishListener) {
        File file = new File(url);
        dayBean.setImage(new BmobFile(file));
        LogUtil.E(url + "" + file.exists());
        dayBean.getImage().upload(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (onFinishListener != null) {
                    onFinishListener.onFinish(e);
                }
            }
        });
    }

    public int i = 0;

    public void addRecord(final String txt, final ArrayList<PicBean> datas, final OnProgressInterf onProgressInterf) {
        if (i == 0) {
            onProgressInterf.onStart(null);
            onProgressInterf.onProgess((i + 1) + "/" + datas == null ? 0 : datas.size());
        }
        if (datas != null && datas.size() <= i) {
            if (onProgressInterf != null) {
                onProgressInterf.onEnd(null);
                return;
            }
        }
        addRecord(txt, datas == null ? null : datas.get(i).getPath(), new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                i++;
                onProgressInterf.onProgess((i + 1) + "/" + datas == null ? 0 : datas.size());
                addRecord(txt, datas, onProgressInterf);
            }
        });
    }

    public void addRecord(String txt, String url, final OnFinishListener onFinishListener2) {
        final DayBean dayBean = new DayBean();
        dayBean.setContent(txt);
        dayBean.setYear(Calendar.getInstance().get(Calendar.YEAR));
        dayBean.setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
        dayBean.setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        uploadImage(dayBean, url, new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                dayBean.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (onFinishListener2 != null) {
                            onFinishListener2.onFinish(s);
                        }
                    }
                });
            }
        });
    }


}
