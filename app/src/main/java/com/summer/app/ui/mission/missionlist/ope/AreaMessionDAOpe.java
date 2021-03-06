package com.summer.app.ui.mission.missionlist.ope;

import android.content.Context;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.lib.base.ui.ope.BaseDAOpe;
import com.summer.app.nursevalue.DataValue;
import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class AreaMessionDAOpe extends BaseDAOpe {


    public String myPatientTodayData = null;

    public String myAreaTodayData = null;

    public String myPatientHistoryData = null;

    public String myAreaHistoryData = null;

    public String leftType = ALL;

    public String rightSort = ALL;


    public String areaType = AREA_TYPE_MY_PATIENT;

    public String timeArea = TIME_TODAY;

    public String count = COUNT_ALL;

    public static final String COUNT_ALL = "全部";

    public static final String COUNT_LONG = "长期";

    public static final String COUNT_LIN = "临时";

    public static final String ALL = "全部";

    public static final String TIME_TODAY = "今日";

    public static final String TIME_HISTORY = "历史";

    public static final String AREA_TYPE_AREA = "病区";

    public static final String AREA_TYPE_MY_PATIENT = "我的病人";

    public static HashMap<String, String> hashMap = new HashMap<>();

    private ArrayList<AreaMissionListAdapterBean> missionData;

    public AreaMessionDAOpe(Context context) {
        super(context);
    }

    public ArrayList<AreaMissionListAdapterBean> initData(ArrayList<AreaMissionListAdapterBean> res) {
        if (res == null) {
            return res;
        }
        GetallregionbyuserResBean.Data data = MethodValue.getArea();
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).getData().size(); j++) {
                String bedid = res.get(i).getData().get(j).getBedId();
                res.get(i).getData().get(j).setBedId(data.getWardname() + bedid.substring(2, bedid.length()) + "床");
            }
        }
        return res;
    }

    public String getIDs(List<AreaMessionListResBean.DataBean.TitlesBean> data) {
        String s = "";
        for (int i = 0; i < data.size(); i++) {
            s += data.get(i).getId();
            s += ",";
        }
        if (s.endsWith(",")) {
            s.substring(0, s.length() - 1);
        }
        return s;
    }

    public void setCacheData(String type, String data) {
        switch (type) {
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_AREA:
                myAreaTodayData = data;
                break;
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                myPatientTodayData = data;
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_AREA:
                myAreaHistoryData = data;
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                myPatientHistoryData = data;
                break;
        }
    }

    public String getCahceData(String type) {
        String s = null;
        switch (type) {
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_AREA:
                s = myAreaTodayData;
                break;
            case AreaMessionDAOpe.TIME_TODAY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                s = myPatientTodayData;
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_AREA:
                s = myAreaHistoryData;
                break;
            case AreaMessionDAOpe.TIME_HISTORY + AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                s = myPatientHistoryData;
                break;
        }
        return s;
    }

    public static HashMap<String, String> getHashMap() {
        return hashMap;
    }

    static {
        hashMap.put("全部", AreaMessionDAOpe.ALL);
        hashMap.put("完成", DataValue.STATUS_YI_WAN_CHENG);
        hashMap.put("未完", AreaMessionDAOpe.ALL);
        hashMap.put("删除", DataValue.SSTATUS_SHAN_CHU);
        hashMap.put("拒绝", DataValue.STATUS_BING_REN_JU_JUE);
        hashMap.put("不在", DataValue.STATUS_BING_REN_BU_ZAI);
        hashMap.put("历史", AreaMessionDAOpe.ALL);

    }

    public ArrayList<AreaMissionListAdapterBean> getMissionData() {
        return missionData;
    }

    public void setMissionData(ArrayList<AreaMissionListAdapterBean> missionData) {
        this.missionData = missionData;
    }


    public boolean isLin(String yizhu, String key) {
        String timetype = "";
        if (yizhu.toLowerCase().startsWith("cq")) {
            timetype = "长期";
        }
        if (yizhu.toLowerCase().startsWith("ls")) {
            timetype = "临时";
        }

        if (yizhu.toLowerCase().startsWith("hz")) {
            if ("st".equals(key.toLowerCase())) {
                timetype = "临时";
            } else {
                timetype = "长期";
            }
        }
        if (timetype.equals("长期")) {
            return false;
        } else {
            return true;
        }
    }

    public Object[] getLin(boolean lin) {
        if (lin) {
            return new Object[]{"临", context.getResources().getColor(R.color.color_blue_400)};
        }
        return new Object[]{"长", context.getResources().getColor(R.color.color_red_400)};
    }

    public int[] isInJecting(String codeName) {
        switch (codeName.trim()) {
            case "出院带药":
            case "药品":
            case "输液":
                return new int[]{R.color.light_blue, R.drawable.icon_injecting};
            case "检查":
            case "检验":
            case "化验":
                return new int[]{R.color.light_blue, R.drawable.icon_codename_check};
            case "补液卡":
            case "补液卡（静滴）":
            default:
                return new int[]{R.color.black, R.drawable.icon_medicine};
        }
    }

    //任务状态，A:已审核，F:未执行，T:已完成，N:病人不在，R:病人拒绝，S:删除
    public Integer[] getStatusIcon(String status) {
        switch (status.trim().toUpperCase()) {
            case "T":
                return new Integer[]{R.drawable.icon_gou, View.VISIBLE};
            case "N":
                return new Integer[]{R.drawable.icon_absent, View.VISIBLE};
            case "R":
                return new Integer[]{R.drawable.icon_refuse, View.VISIBLE};
            case "S":
                return new Integer[]{R.drawable.icon_deleted, View.VISIBLE};
            default:
                return new Integer[]{R.color.transparent, View.GONE};

        }
    }
}
