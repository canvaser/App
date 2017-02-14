package com.siweisoft.nurse.ui.info.bedreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.gson.JsonArray;
import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.BaseResultResBean;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.info.bedreport.bean.resbean.BedReportListResBean;
import com.siweisoft.nurse.ui.info.bedreport.bean.resbean.BedReportResBean;
import com.siweisoft.nurse.ui.info.bedreport.ope.BedReportNetOpe;
import com.siweisoft.nurse.ui.info.bedreport.ope.BedReportUIOpe;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginResBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.SPUtil;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReprotFrag extends BaseNurseFrag{


    BedReportNetOpe bedReportNetOpe;

    BedReportUIOpe bedReportUIOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bedReportNetOpe = new BedReportNetOpe(activity);
        bedReportUIOpe= new BedReportUIOpe(activity,getView());
        bedReportUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
        bedReportUIOpe.getRefreshLayout().autoRefresh();
    }

    public void getData(final OnFinishListener onFinishListener){
        String s = SPUtil.getInstance().getStr(ValueConstant.AREA_INFO);
        if(s==null ){
            return;
        }
        GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(s, GetallregionbyuserResBean.Data.class);
        if(data==null || data.getWardcode()==null){
            return;
        }

        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setRegionid(data.getWardcode());
        bedReportNetOpe.getDailyBedReportByRegion(reqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    BedReportListResBean bedReportResBean = GsonUtil.getInstance().fromJson(o.toString(),BedReportListResBean.class);
                    try {
                        JSONObject jsonObject = new JSONObject(o.toString());
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject j = new JSONObject(GsonUtil.getInstance().toJson(jsonArray.get(i)));

                            JSONObject jj = new JSONObject(j.get("nameValuePairs").toString());
                            jj.getString("old");
                            bedReportResBean.getData().get(i).setNeww(jj.get("new").toString());

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    bedReportUIOpe.initList(bedReportResBean.getData());

                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
    }




    @Override
    public int getContainView() {
        return R.layout.frag_bedreport;
    }
}
