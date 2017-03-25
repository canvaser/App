package com.summer.lib.util;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.summer.lib.R;
import com.summer.lib.view.bottomdialogmenuview.BottomDialogMenuView;

//import com.siweisoft.imga.R;

/**
 * Created by ${viwmox} on 2016-05-19.
 */
public class SheetDialogUtil {

    private static SheetDialogUtil instance;
    private AlertDialog dialog;

    public static SheetDialogUtil getInstance() {
        if (instance == null) {
            instance = new SheetDialogUtil();
        }
        return instance;
    }

    public void showBottomSheet(Context activity, View view, View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
        dialog.getWindow().getAttributes().width = activity.getResources().getDisplayMetrics().widthPixels;
        dialog.getWindow().setWindowAnimations(R.style.sheetstyle);
        dialog.getWindow().setContentView(view);
//        ViewGroup.LayoutParams params = view.getLayoutParams();
//        params.width = activity.getResources().getDisplayMetrics().widthPixels;
//        view.setLayoutParams(params);
        ViewGroup viewGroup = (ViewGroup) (view.findViewById(R.id.root));
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            ViewGroup group = (ViewGroup) viewGroup.getChildAt(i);
            if (group.getChildAt(0) instanceof TextView) {
                TextView textView = (TextView) group.getChildAt(0);
//                LogUtil.E(textView.getText());
                textView.setOnClickListener(onClickListener);
            }
        }
        if (view instanceof BottomDialogMenuView) {
            BottomDialogMenuView bottomDialogMenuView = (BottomDialogMenuView) view;
            bottomDialogMenuView.getSweetView().show();
        }
    }


    public void showBottomSheet(Context activity, View view, int style, View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
        dialog.getWindow().getAttributes().width = activity.getResources().getDisplayMetrics().widthPixels;
        dialog.getWindow().setWindowAnimations(style);
        dialog.getWindow().setContentView(view);
//        ViewGroup.LayoutParams params = view.getLayoutParams();
//        params.width = activity.getResources().getDisplayMetrics().widthPixels;
//        view.setLayoutParams(params);
        ViewGroup viewGroup = (ViewGroup) (view.findViewById(R.id.root));
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            ViewGroup group = (ViewGroup) viewGroup.getChildAt(i);
            if (group.getChildAt(0) instanceof TextView) {
                TextView textView = (TextView) group.getChildAt(0);
//                LogUtil.E(textView.getText());
                textView.setOnClickListener(onClickListener);
            }
        }

        if (view instanceof BottomDialogMenuView) {
            BottomDialogMenuView bottomDialogMenuView = (BottomDialogMenuView) view;
            bottomDialogMenuView.getSweetView().show();
        }
    }


    public void showBottomSheet(Context activity, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
        dialog.getWindow().getAttributes().width = activity.getResources().getDisplayMetrics().widthPixels;
        dialog.getWindow().setWindowAnimations(R.style.sheetstyle_more);
        dialog.getWindow().setContentView(view);
//        ViewGroup.LayoutParams params = view.getLayoutParams();
//        params.width = activity.getResources().getDisplayMetrics().widthPixels;
//        view.setLayoutParams(params);
    }

    public void dismess() {
        if (dialog != null) {
            dialog.dismiss();
            dialog.cancel();
        }
    }
}
