package com.siweisoft.nurse.ui.mission.missionlist.ope;

import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.data.DateFormatUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMessionTimeOpe {

    HashMap<Integer,HashMap<Integer,HashMap<Integer,HashMap<Integer,ArrayList<AreaMessionResBean>>>>> sorthashMap=new HashMap<>();


    public ArrayList<AreaMissionListAdapterBean> sort(AreaMessionListResBean resBean,String type,String sort,String count){

        LogUtil.E(System.currentTimeMillis());
        for(int i=0;i<resBean.getData().size();i++){
            try {
                if(type.equals("全部")&&sort.equals("全部")||
                        type.equals("全部")&&sort.equals(resBean.getData().get(i).getTitles().get(0).getNurse_type())||
                        type.equals(resBean.getData().get(i).getTitles().get(0).getStatus()) &&sort.equals("全部")||
                        type.equals(resBean.getData().get(i).getTitles().get(0).getStatus()) &&sort.equals(resBean.getData().get(i).getTitles().get(0).getNurse_type())
                        ){
                    String l;
                    if("st".equals(resBean.getData().get(i).getTitles().get(0).getKey().toLowerCase())|| resBean.getData().get(i).getCodename().equals("出院带药")){
                        l= "临时";
                    }else{
                        l = "长期";
                    }
                    if(count.equals("全部")||
                            count.equals(l)){
                        Calendar calendar = DateFormatUtil.convent_yyyyMMddHHmmssCalendar(resBean.getData().get(i).getStart());
                        int y =calendar.get(Calendar.YEAR);
                        int m = calendar.get(Calendar.MONTH);
                        int d= calendar.get(Calendar.DAY_OF_MONTH);
                        int h = calendar.get(Calendar.HOUR_OF_DAY);
                        if(sorthashMap.get(y)==null){
                            sorthashMap.put(y,new HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<AreaMessionResBean>>>>());
                        }
                        if(sorthashMap.get(y).get(m)==null){
                            sorthashMap.get(y).put(m,new HashMap<Integer, HashMap<Integer, ArrayList<AreaMessionResBean>>>());
                        }
                        if(sorthashMap.get(y).get(m).get(d)==null){
                            sorthashMap.get(y).get(m).put(d,new HashMap<Integer, ArrayList<AreaMessionResBean>>());
                        }
                        int hourarea = (h/2)*2;
                        if(sorthashMap.get(y).get(m).get(d).get(hourarea)==null){
                            sorthashMap.get(y).get(m).get(d).put(hourarea,new ArrayList<AreaMessionResBean>());
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






    private ArrayList<AreaMissionListAdapterBean> sortList(){
        ArrayList<AreaMissionListAdapterBean> areaMissionListAdapterBeen = new ArrayList<>();
        Iterator<Integer> year = sorthashMap.keySet().iterator();
        while(year.hasNext()){
            int y = year.next();
            Iterator<Integer> month = sorthashMap.get(y).keySet().iterator();
            while (month.hasNext()){
                int m = month.next();
                Iterator<Integer> day = sorthashMap.get(y).get(m).keySet().iterator();
                while (day.hasNext()){
                    int d = day.next();
                    Iterator<Integer> area = sorthashMap.get(y).get(m).get(d).keySet().iterator();
                   while (area.hasNext()){
                       int a = area.next();
                       ArrayList<AreaMessionResBean> list = sorthashMap.get(y).get(m).get(d).get(a);
                       Collections.sort(list,new SortByTime());
                       areaMissionListAdapterBeen.add(new AreaMissionListAdapterBean(y,m,d,a,list));
                   }
                }
            }
        }
        LogUtil.E(areaMissionListAdapterBeen);
        Collections.sort(areaMissionListAdapterBeen,new SortByYND());
        LogUtil.E(System.currentTimeMillis());
        return areaMissionListAdapterBeen;
    }


}
