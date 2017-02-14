package com.siweisoft.nurse.ui.check.checklist.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.siweisoft.app.R;
import com.siweisoft.base.ui.fragment.BaseUIFragment;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.view.OnAppItemsClickListener;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.check.checklist.bean.CheckDABean;
import com.siweisoft.nurse.ui.check.checklist.bean.CheckHeadUIBean;
import com.siweisoft.nurse.ui.check.checklist.bean.bean.TitleBean;
import com.siweisoft.nurse.ui.check.checklist.bean.reqbean.UpdateCheckListReqBean;
import com.siweisoft.nurse.ui.check.checklist.bean.resbean.CheckListResBean;
import com.siweisoft.nurse.ui.check.checklist.ope.CheckDAOpe;
import com.siweisoft.nurse.ui.check.checklist.ope.CheckListFGMUIOpe;
import com.siweisoft.nurse.ui.check.checklist.ope.CheckListNetOpe;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.StringUtil;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.StickyLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class CheckListFGM extends BaseNurseFrag implements
        PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        OnAppItemsClickListener{


    CheckListFGMUIOpe checkListFGMUIOpe;

    CheckListNetOpe checkListNetOpe;
    CheckDAOpe checkDAOpe;


    CheckDABean checkDABean;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkListFGMUIOpe = new CheckListFGMUIOpe(activity,getView());
        checkListNetOpe = new CheckListNetOpe(activity);
        checkDAOpe= new CheckDAOpe();
        checkDABean = new CheckDABean();
        checkListFGMUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        checkListFGMUIOpe.getRefreshLayout().finishRefresh();
                    }
                });
            }
        });
        checkListFGMUIOpe.getMissionExpandView().setOnHeaderUpdateListener(this);
        checkListFGMUIOpe.getRefreshLayout().autoRefresh();

    }

    public void getData(final OnFinishListener onFinishListener){
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setBegin("2016-10-01");
        baseNurseReqBean.setEnd("2016-12-01");
        checkListNetOpe.getCheckTasks(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    CheckListResBean checkListResBean = GsonUtil.getInstance().fromJson(o.toString(),CheckListResBean.class);
                    checkListFGMUIOpe.initList(new CheckDAOpe().initData(checkListResBean.getData()));
                    for(int i=0;i<checkListResBean.getData().size();i++){
                        checkDAOpe.getTitles().add(new TitleBean(checkListResBean.getData().get(i).getData().size(),checkListResBean.getData().get(i).getItemName()));
                    }
                    checkListFGMUIOpe.getCheckListAdapter().setOnAppItemsClickListener(CheckListFGM.this);
                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
    }



    @Override
    public int getContainView() {
        return R.layout.frag_checklist;
    }



    @Override
    public View getPinnedHeader() {
        View headerView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.list_head_check, null);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        if(checkDAOpe==null || checkDAOpe.getTitles()==null || firstVisibleGroupPos<0 || checkDAOpe.getTitles().get(firstVisibleGroupPos)==null){
            headerView.setVisibility(View.GONE);
            return;
        }
        headerView.setVisibility(View.VISIBLE);
        TextView count = (TextView) headerView.findViewById(R.id.tv_count);
        TextView name = (TextView) headerView.findViewById(R.id.tv_name);
        count.setText("总数:"+checkDAOpe.getTitles().get(firstVisibleGroupPos).getNum()+"");
        name.setText(checkDAOpe.getTitles().get(firstVisibleGroupPos).getTitle()+"");
    }

    @Override
    public void onAppItemClick(int index, View view, int position) {
        switch (view.getId()){
            case R.id.ll_left:

                break;
            case R.id.tv_finish:
                UpdateCheckListReqBean reqBean = new UpdateCheckListReqBean();
                if(checkListFGMUIOpe.getCheckListAdapter().getData().get(index).getData().get(position).getCheckStatus().equals("T")){
                    reqBean.setStatus("F");
                }else{
                    reqBean.setStatus("T");
                }
                reqBean.setId(checkListFGMUIOpe.getCheckListAdapter().getData().get(index).getData().get(position).getId());
                checkListNetOpe.updateCheckStatus(reqBean, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            checkListFGMUIOpe.getRefreshLayout().autoRefresh();
                        }
                    }
                });
                break;
        }
    }
}
