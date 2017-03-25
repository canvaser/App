package com.summer.app.ui.dialog.dialog.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.summer.app.R;
import com.summer.app.ui.dialog.dialog.ope.uiope.NurseDialogUIOpe;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.AnimUtil;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class NurseDialogFrag extends Fragment implements View.OnClickListener {

    NurseDialogUIOpe nurseDialogUIOpe;

    private String[] strings;

    private OnAppItemClickListener onAppItemClickListener;

    public static final int LEFT = 0;

    public static final int MID = 1;

    public static final int RIGHT = 2;

    public static void show(FragmentManager fragmentManagers, int id, String[] strings, int position, OnAppItemClickListener onAppItemClickListener) {
        Bundle bundle = new Bundle();
        bundle.putStringArray(ValueConstant.DATA_DATA, strings);
        bundle.putInt(ValueConstant.DATA_POSITION, position);
        NurseDialogFrag nurseDialogFrag = new NurseDialogFrag();
        nurseDialogFrag.setArguments(bundle);
        nurseDialogFrag.onAppItemClickListener = onAppItemClickListener;
        fragmentManagers.beginTransaction().add(id, nurseDialogFrag).commit();
    }

    public static void show(FragmentManager fragmentManagers, int id, ArrayList<String> strings, int position, OnAppItemClickListener onAppItemClickListener) {
        Bundle bundle = new Bundle();
        bundle.putStringArray(ValueConstant.DATA_DATA, strings.toArray(new String[strings.size()]));
        bundle.putInt(ValueConstant.DATA_POSITION, position);
        NurseDialogFrag nurseDialogFrag = new NurseDialogFrag();
        nurseDialogFrag.setArguments(bundle);
        nurseDialogFrag.onAppItemClickListener = onAppItemClickListener;
        fragmentManagers.beginTransaction().add(id, nurseDialogFrag).commit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_dialog_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nurseDialogUIOpe = new NurseDialogUIOpe(getActivity(), getView());
        strings = getArguments().getStringArray(ValueConstant.DATA_DATA);
        getView().findViewById(R.id.root).setOnClickListener(this);
        switch (getArguments().getInt(ValueConstant.DATA_POSITION)) {
            case LEFT:
                nurseDialogUIOpe.showLeft(strings, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        AnimUtil.getInstance().startAnim(getActivity(), nurseDialogUIOpe.getLeftRecycle(), R.anim.anim_out_fast, new OnFinishListener() {
                            @Override
                            public void onFinish(Object o) {
                                getFragmentManager().beginTransaction().remove(NurseDialogFrag.this).commit();
                            }
                        });
                        onAppItemClickListener.onAppItemClick(view, position);
                    }
                });
                break;
            case RIGHT:
                nurseDialogUIOpe.showRight(strings, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        AnimUtil.getInstance().startAnim(getActivity(), nurseDialogUIOpe.getRightRecycle(), R.anim.anim_out_fast_right, new OnFinishListener() {
                            @Override
                            public void onFinish(Object o) {
                                getFragmentManager().beginTransaction().remove(NurseDialogFrag.this).commit();
                            }
                        });
                        onAppItemClickListener.onAppItemClick(view, position);
                    }
                });
                break;
            default:
                nurseDialogUIOpe.showList(strings, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        AnimUtil.getInstance().startAnim(getActivity(), nurseDialogUIOpe.getRecyclerView(), R.anim.anim_out_fast_mid, new OnFinishListener() {
                            @Override
                            public void onFinish(Object o) {
                                getFragmentManager().beginTransaction().remove(NurseDialogFrag.this).commit();
                            }
                        });
                        onAppItemClickListener.onAppItemClick(view, position);
                    }
                });
                break;
        }

    }

    boolean showing = false;

    @Override
    public void onClick(View v) {
        int anim = R.anim.anim_out_fast_mid;

        RecyclerView recyclerView = nurseDialogUIOpe.getRecyclerView();

        if (nurseDialogUIOpe.getLeftRecycle().getVisibility() == View.VISIBLE) {
            anim = R.anim.anim_out_fast;
            recyclerView = nurseDialogUIOpe.getLeftRecycle();
        } else if (nurseDialogUIOpe.getRightRecycle().getVisibility() == View.VISIBLE) {
            anim = R.anim.anim_out_fast_right;
            recyclerView = nurseDialogUIOpe.getRightRecycle();
        } else {
            anim = R.anim.anim_out_fast_mid;
            recyclerView = nurseDialogUIOpe.getRecyclerView();
        }

        if (!showing) {
            AnimUtil.getInstance().startAnim(getActivity(), recyclerView, anim, new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    showing = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    getFragmentManager().beginTransaction().remove(NurseDialogFrag.this).commit();
                    showing = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }

    }
}
