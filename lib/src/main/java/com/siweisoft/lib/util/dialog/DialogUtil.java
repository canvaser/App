package com.siweisoft.lib.util.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.siweisoft.lib.R;
import com.siweisoft.lib.view.loading.avi.AVLoadingIndicatorView;
import com.siweisoft.lib.view.pickerview.TimePickerDialog;
import com.siweisoft.lib.view.pickerview.data.Type;
import com.siweisoft.lib.view.pickerview.listener.OnDateSetListener;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class DialogUtil {

    private static DialogUtil instance;

    AlertDialog alertDialog;

    public static DialogUtil getInstance() {
        if (instance == null) {
            instance = new DialogUtil();
        }
        return instance;
    }

    public void showDialog(Context context, View view, View.OnClickListener listener, int... id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        alertDialog = builder.create();
        alertDialog.setCancelable(true);
//        alertDialog.setView(view);
        alertDialog.getWindow().setWindowAnimations(R.style.fadein);
        // alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        alertDialog.show();
        alertDialog.getWindow().setContentView(view);

        for (int i = 0; i < id.length; i++) {
            view.findViewById(id[i]).setOnClickListener(listener);
        }
    }


    public void showLoadDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        AVLoadingIndicatorView v = (AVLoadingIndicatorView) view.findViewById(R.id.av);
        AlertDialog dialog = builder.create();
        dialog.show();
        builder.setView(view);
        v.show();
    }

    public void dismiss() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static void showTimePick(Context context, FragmentManager fragmentManager, String name, Type type, OnDateSetListener onDateSetListener) {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(onDateSetListener)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("选择日期")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis() - tenYears)
                .setMaxMillseconds(System.currentTimeMillis())
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(context.getResources().getColor(R.color.color_base_txt_gray))
                .setType(type)
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();
        mDialogAll.show(fragmentManager, name);
    }
}
