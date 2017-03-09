package com.siweisoft.app.ui.info.workdetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.ui.info.workdetail.bean.resbean.WorkDetailListResBean;
import com.siweisoft.app.ui.info.workdetail.ope.WorkDetailDAOpe;
import com.siweisoft.app.ui.info.workdetail.ope.WorkDetailUIOpe;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.base.ui.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.lib.util.fragment.FragManager;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class WorkDetailFrag extends BaseNurseFrag implements OnAppItemClickListener {


    NurseNetOpe workDetailNetOpe;


    WorkDetailUIOpe workDetailUIOpe;

    WorkDetailDAOpe workDetailDAOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workDetailUIOpe = new WorkDetailUIOpe(activity, getView());
        workDetailNetOpe = new NurseNetOpe(activity);
        workDetailDAOpe = new WorkDetailDAOpe(activity);
        getData();
    }

    public void getData() {
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setBegin(DateFormatUtil.getbefore7TimeYYYYMMdd());
        workDetailNetOpe.getWorkloadByUser(reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    WorkDetailListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), WorkDetailListResBean.class);
                    workDetailDAOpe.setWorkDetailAdapterBeen(workDetailDAOpe.sort(resBean.getData()));
                    workDetailUIOpe.initList(workDetailDAOpe.getWorkDetailAdapterBeen());
                    workDetailUIOpe.inithead(workDetailDAOpe.getNumWorks(workDetailDAOpe.getWorkDetailAdapterBeen()));
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
        bundle.putSerializable(ValueConstant.DATA_DATA, workDetailUIOpe.getWorkDetailListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(), index, new WorkDetailsFrag(), bundle);
    }
}
