package com.summer.app.ui.info.bedreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.info.bedreport.bean.resbean.BedReportListResBean;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.summer.lib.bean.reqbean.BaseNurseReqBean;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.ui.info.bedreport.ope.BedReportUIOpe;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class BedReprotFrag extends BaseNurseFrag {


    NurseNetOpe bedReportNetOpe;

    BedReportUIOpe bedReportUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bedReportNetOpe = new NurseNetOpe(activity);
        bedReportUIOpe = new BedReportUIOpe(activity, getView());
        bedReportUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
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
        bedReportUIOpe.getRefreshLayout().autoRefreshWithUI(0);
    }

    public void getData(final OnFinishListener onFinishListener) {
        String s = SPUtil.getInstance().getStr(ValueConstant.AREA_INFO);
        if (s == null) {
            return;
        }
        GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(s, GetallregionbyuserResBean.Data.class);
        if (data == null || data.getWardcode() == null) {
            return;
        }

        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setRegionid(data.getWardcode());
        bedReportNetOpe.getDailyBedReportByRegion(reqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    BedReportListResBean bedReportResBean = GsonUtil.getInstance().fromJson(o.toString(), BedReportListResBean.class);
                    try {
                        JSONObject jsonObject = new JSONObject(o.toString());
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
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
                if (onFinishListener != null) {
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
