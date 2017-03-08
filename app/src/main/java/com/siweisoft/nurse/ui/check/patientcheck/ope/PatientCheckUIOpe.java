package com.siweisoft.nurse.ui.check.patientcheck.ope;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag;
import com.siweisoft.lib.base.ui.common.CommonUIOpe;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.nurse.ui.bed.bedlist.ope.BedListDAOpe;
import com.siweisoft.nurse.ui.check.patientcheck.adapter.PatientCheckAdapter;
import com.siweisoft.nurse.ui.check.patientcheck.bean.PatAndTaskInfoResBean;
import com.siweisoft.nurse.ui.check.patientcheck.bean.PatientCheckHeadUIBean;
import com.siweisoft.nurse.ui.mission.missionlist.ope.AreaMessionDAOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class PatientCheckUIOpe extends CommonUIOpe {


    @BindView(R.id.recycle)
    RecyclerView recycle;

    PatientCheckHeadUIBean headUIBean;

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_bedid)
    TextView tvBedid;
    @BindView(R.id.tv_zyh)
    TextView tvZyh;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_guoming)
    TextView tvGuoming;
    @BindView(R.id.tv_taskname)
    TextView tvTaskname;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_key)
    TextView tvKey;
    @BindView(R.id.tv_advid)
    TextView tvAdvid;
    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.iv_codename)
    ImageView codeNameIV;
    @BindView(R.id.ll_head)
    View headLL;


    public PatientCheckUIOpe(CommonUIFrag frag, View containerView) {
        super(frag, containerView);
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("病人用药核对");
    }


    public void initList(PatAndTaskInfoResBean resBean) {
        if (resBean == null || resBean.getData() == null || resBean.getData().getPatInfo() == null || resBean.getData().getTaskInfo() == null || resBean.getData().getTaskInfo().size() == 0) {
            return;
        }
        View head = LayoutInflater.from(frag.getActivity()).inflate(R.layout.head_patientcheck, null);
        getTvName().setText(StringUtil.getStr(resBean.getData().getPatInfo().get姓名()));
        getTvSex().setText(StringUtil.getStr(resBean.getData().getPatInfo().get性别()));
        getTvBedid().setText(StringUtil.getStr(resBean.getData().getPatInfo().get病床名()) + "床");
        getTvZyh().setText(StringUtil.getStr(resBean.getData().getPatInfo().get住院号()));
        getTvAge().setText(StringUtil.getStr(resBean.getData().getPatInfo().getPatAge()));
        getTvGuoming().setText(StringUtil.getStr(resBean.getData().getPatInfo().getSensitiveCodes()));

        getTvTitle().setText(StringUtil.getStr(resBean.getData().getTaskInfo().get(0).getTitles().get(0).getContents()));
        getTvTaskname().setText(StringUtil.getStr(resBean.getData().getTaskInfo().get(0).getTitles().get(0).getTaskname()));
        getTvStart().setText(DateFormatUtil.getMMDDHHMM(StringUtil.getStr(resBean.getData().getTaskInfo().get(0).getTitles().get(0).getExectime())));
        getTvKey().setText(StringUtil.getStr(resBean.getData().getTaskInfo().get(0).getTitles().get(0).getKey()));
        getTvAdvid().setText(StringUtil.getStr(resBean.getData().getTaskInfo().get(0).getTitles().get(0).get医嘱ID()));
        AreaMessionDAOpe areaMessionDAOpe = new AreaMessionDAOpe(frag.getActivity());
        BedListDAOpe bedListDAOpe = new BedListDAOpe(frag.getActivity(), null);
        bedListDAOpe.initMyBedList(frag.getActivity(), resBean.getData().getPatInfo());
        getIvHead().setImageResource(resBean.getData().getPatInfo().getResId());
        getCodeNameIV().setImageResource(areaMessionDAOpe.isInJecting(resBean.getData().getTaskInfo().get(0).getCodename())[1]);
        recycle.setLayoutManager(new LinearLayoutManager(frag.getActivity()));
        recycle.addItemDecoration(new MyItemDecoration2(frag.getActivity(), 2));
        recycle.setAdapter(new PatientCheckAdapter(frag.getActivity(), resBean.getData().getTaskInfo()));
    }


    public RecyclerView getRecycle() {
        return recycle;
    }

    public PatientCheckHeadUIBean getHeadUIBean() {
        return headUIBean;
    }

    public ImageView getIvHead() {
        return ivHead;
    }

    public LinearLayout getLlLeft() {
        return llLeft;
    }

    public TextView getTvAdvid() {
        return tvAdvid;
    }

    public TextView getTvAge() {
        return tvAge;
    }

    public TextView getTvBedid() {
        return tvBedid;
    }

    public TextView getTvGuoming() {
        return tvGuoming;
    }

    public TextView getTvKey() {
        return tvKey;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvSex() {
        return tvSex;
    }

    public TextView getTvStart() {
        return tvStart;
    }

    public TextView getTvTaskname() {
        return tvTaskname;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvZyh() {
        return tvZyh;
    }

    public ImageView getCodeNameIV() {
        return codeNameIV;
    }

    public View getHeadLL() {
        return headLL;
    }
}
