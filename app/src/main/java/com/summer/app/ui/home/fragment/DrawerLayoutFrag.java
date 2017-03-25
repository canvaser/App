package com.summer.app.ui.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.ui.bed.addmypatient.bean.AddMyPatientAdapterBean;
import com.summer.app.ui.bed.addmypatient.fragment.AddMyPatientDrawFrag;
import com.summer.app.ui.home.activity.IndexActivity;
import com.summer.app.ui.home.bean.reqbean.WriteAlarmReqBean;
import com.summer.app.ui.home.ope.DrawerLayoutUIOpe;

import java.io.Serializable;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-29.
 */
public class DrawerLayoutFrag extends BaseNurseFrag implements OnAppItemClickListener, Serializable {


    DrawerLayoutUIOpe drawerLayoutUIOpe;

    AddMyPatientAdapterBean bean;

    NurseNetOpe homeNetOpe;


    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerLayoutUIOpe = new DrawerLayoutUIOpe(activity, getView());
        drawerLayoutUIOpe.setItemClickListener(this);
        homeNetOpe = new NurseNetOpe(activity);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_drawer;
    }


    @Override
    public void onAppItemClick(View view, int position) {
        drawerLayoutUIOpe.getSelectVs().get(position).setSelected(!drawerLayoutUIOpe.getSelectVs().get(position).isSelected());
    }

    @OnClick({R.id.tv_sendd, R.id.tv_selectt})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case R.id.tv_selectt:
                AddMyPatientDrawFrag addMyPatientDrawFrag = new AddMyPatientDrawFrag();
                FragmentUtil.getInstance().addToContaier(activity, addMyPatientDrawFrag, R.id.content_frame);
                break;
            case R.id.tv_sendd:
                if (drawerLayoutUIOpe.getSelectTV().getText().toString().equals("请选择病人")) {
                    onClickEvent(getView().findViewById(R.id.tv_selectt));
                } else {
                    WriteAlarmReqBean reqBean = new WriteAlarmReqBean();
                    reqBean.setLevel("1");
                    reqBean.setZyh(bean.get住院号());
                    reqBean.setContent("");
                    reqBean.setUpdate_value("0");
                    reqBean.setPatname(bean.get病床号() + " " + bean.get姓名());
                    String s = "";
                    for (int i = 0; i < drawerLayoutUIOpe.getSelectVs().size(); i++) {
                        if (drawerLayoutUIOpe.getSelectVs().get(i).isSelected()) {
                            s += drawerLayoutUIOpe.getStrings()[i];
                            s += ",";
                        }
                    }
                    if (s.endsWith(",")) {
                        s = s.substring(0, s.length() - 1);

                    }
                    reqBean.setContent(s);
                    if (s.equals("")) {
                        return;
                    }
                    homeNetOpe.writeAlarmLogs(reqBean, new OnNetWorkReqAdapter(activity) {
                        @Override
                        public void onNetWorkResult(boolean success, Object o) {
                            if (success) {
                                IndexActivity indexActivity = (IndexActivity) getActivity();
                                indexActivity.getHomeUIOpe().getDrawerLayout().closeDrawer(Gravity.END);
                            }
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        if (bundle == null || bundle.getSerializable(ValueConstant.DATA_DATA) == null) {
            drawerLayoutUIOpe.getSelectTV().setText("请选择病人");
            return;
        }
        bean = (AddMyPatientAdapterBean) bundle.getSerializable(ValueConstant.DATA_DATA);
        drawerLayoutUIOpe.getSelectTV().setText(bean.get住院号() + " " + bean.get姓名());
    }
}
