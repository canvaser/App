package com.siweisoft.util.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.siweisoft.app.R;
import com.siweisoft.view.loading.avi.AVLoadingIndicatorView;

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
        alertDialog.show();
        alertDialog.getWindow().setContentView(view);
        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
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
}
