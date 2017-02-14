package com.siweisoft.nurse.ui.info.workdetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.info.workdetail.bean.resbean.WorkDetailListResBean;
import com.siweisoft.nurse.ui.info.workdetail.ope.WorkDetailDAOpe;
import com.siweisoft.nurse.ui.info.workdetail.ope.WorkDetailNetOpe;
import com.siweisoft.nurse.ui.info.workdetail.ope.WorkDetailUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.data.DateFormatUtil;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class WorkDetailFrag extends BaseNurseFrag implements OnAppItemClickListener{


    WorkDetailNetOpe workDetailNetOpe;


    WorkDetailUIOpe workDetailUIOpe;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workDetailUIOpe = new WorkDetailUIOpe(activity,getView());
        workDetailNetOpe = new WorkDetailNetOpe(activity);
        getData();
    }

    public void getData(){
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setBegin(DateFormatUtil.getbefore7TimeYYYYMMdd());
        workDetailNetOpe.getWorkloadByUser(reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    WorkDetailListResBean  resBean = GsonUtil.getInstance().fromJson(o.toString(),WorkDetailListResBean.class);
                    workDetailUIOpe.initList(new WorkDetailDAOpe(context).sort(resBean.getData()));
                    workDetailUIOpe.getWorkDetailListAdapter().setOnAppItemClickListener(WorkDetailFrag.this);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_workdetail;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA,workDetailUIOpe.getWorkDetailListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(),index,new WorkDetailsFrag(),bundle);
    }
}
