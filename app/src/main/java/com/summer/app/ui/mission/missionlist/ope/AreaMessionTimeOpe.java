package com.summer.app.ui.mission.missionlist.ope;

import android.os.AsyncTask;

import com.summer.lib.base.ui.interf.OnNetFinishWithObjInter;
import com.summer.lib.util.LogUtil;
import com.summer.lib.util.data.DateFormatUtil;
import com.summer.app.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMessionTimeOpe {

    HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<AreaMessionListResBean.DataBean>>>>> sorthashMap = new HashMap<>();


    public void sort(final AreaMessionListResBean resBean, final String type, final String sort, final String count, final OnNetFinishWithObjInter instener) {
        final AreaMessionDAOpe areaMessionDAOpe = new AreaMessionDAOpe(null);
        new AsyncTask<String, String, ArrayList<AreaMissionListAdapterBean>>() {
            @Override
            protected ArrayList<AreaMissionListAdapterBean> doInBackground(String... params) {
                if (resBean == null || resBean.getData() == null) {
                    return sortList();
                }
                for (int i = 0; i < resBean.getData().size(); i++) {
                    try {
                        if (type.equals("全部") && sort.equals("全部") ||
                                type.equals("全部") && sort.equals(resBean.getData().get(i).getTitles().get(0).getNurse_type()) ||
                                type.equals(resBean.getData().get(i).getTitles().get(0).getStatus()) && sort.equals("全部") ||
                                type.equals(resBean.getData().get(i).getTitles().get(0).getStatus()) && sort.equals(resBean.getData().get(i).getTitles().get(0).getNurse_type())

                                || (type.equals(resBean.getData().get(i).getTitles().get(0).getStatus()) && (resBean.getData().get(i).getTitles().get(0).getNurse_type().contains("静脉输液") && sort.contains("静滴")))
                                || (type.equals(resBean.getData().get(i).getTitles().get(0).getStatus()) && (resBean.getData().get(i).getTitles().get(0).getNurse_type().contains("静脉推") && sort.contains("静推")))
                                ) {
                            String l;
                            if (areaMessionDAOpe.isLin(resBean.getData().get(i).getTitles().get(0).get医嘱ID(), resBean.getData().get(i).getTitles().get(0).getKey())) {
                                l = "临时";
                            } else {
                                l = "长期";
                            }
                            if (count.equals("全部") ||
                                    count.equals(l)) {
                                Calendar calendar = DateFormatUtil.convent_yyyyMMddHHmmssCalendar(resBean.getData().get(i).getStart());
                                int y = calendar.get(Calendar.YEAR);
                                int m = calendar.get(Calendar.MONTH);
                                int d = calendar.get(Calendar.DAY_OF_MONTH);
                                int h = calendar.get(Calendar.HOUR_OF_DAY);
                                if (sorthashMap.get(y) == null) {
                                    sorthashMap.put(y, new HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<AreaMessionListResBean.DataBean>>>>());
                                }
                                if (sorthashMap.get(y).get(m) == null) {
                                    sorthashMap.get(y).put(m, new HashMap<Integer, HashMap<Integer, ArrayList<AreaMessionListResBean.DataBean>>>());
                                }
                                if (sorthashMap.get(y).get(m).get(d) == null) {
                                    sorthashMap.get(y).get(m).put(d, new HashMap<Integer, ArrayList<AreaMessionListResBean.DataBean>>());
                                }
                                int hourarea = (h / 2) * 2;
                                if (sorthashMap.get(y).get(m).get(d).get(hourarea) == null) {
                                    sorthashMap.get(y).get(m).get(d).put(hourarea, new ArrayList<AreaMessionListResBean.DataBean>());
                                }
//                ArrayList<AreaMessionResBean> list =sorthashMap.get(calendar.get(Calendar.YEAR)).get(calendar.get(Calendar.MONTH)).get(calendar.get(Calendar.DAY_OF_MONTH)).get(hourarea);
                                sorthashMap.get(y).get(m).get(d).get(hourarea).add(resBean.getData().get(i));
                            }

                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return sortList();
            }

            @Override
            protected void onPostExecute(ArrayList<AreaMissionListAdapterBean> areaMissionListAdapterBeen) {
                super.onPostExecute(areaMissionListAdapterBeen);
                if (instener != null) {
                    instener.onNetFinish(areaMissionListAdapterBeen);
                }
            }
        }.execute();
    }


    private ArrayList<AreaMissionListAdapterBean> sortList() {
        ArrayList<AreaMissionListAdapterBean> areaMissionListAdapterBeen = new ArrayList<>();
        Iterator<Integer> year = sorthashMap.keySet().iterator();
        while (year.hasNext()) {
            int y = year.next();
            Iterator<Integer> month = sorthashMap.get(y).keySet().iterator();
            while (month.hasNext()) {
                int m = month.next();
                Iterator<Integer> day = sorthashMap.get(y).get(m).keySet().iterator();
                while (day.hasNext()) {
                    int d = day.next();
                    Iterator<Integer> area = sorthashMap.get(y).get(m).get(d).keySet().iterator();
                    while (area.hasNext()) {
                        int a = area.next();
                        ArrayList<AreaMessionListResBean.DataBean> list = sorthashMap.get(y).get(m).get(d).get(a);
                        Collections.sort(list, new SortByTime());
                        areaMissionListAdapterBeen.add(new AreaMissionListAdapterBean(y, m, d, a, list));
                    }
                }
            }
        }
        LogUtil.E(areaMissionListAdapterBeen);
        Collections.sort(areaMissionListAdapterBeen, new SortByYND());
        LogUtil.E(System.currentTimeMillis());
        return areaMissionListAdapterBeen;
    }


}
